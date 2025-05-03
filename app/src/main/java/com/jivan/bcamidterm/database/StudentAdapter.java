package com.jivan.bcamidterm.database;


import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jivan.bcamidterm.R;
import com.jivan.bcamidterm.database.inputdialog.StudentInputDialogFragment;
import com.jivan.bcamidterm.database.model.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private List<Student> studentList;
    private DBHelper dbHelper;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.tvId.setText("Roll Number: " + student.getId());
        holder.tvName.setText("Name: " + student.getName());
        holder.tvAddress.setText("Address: " + student.getAddress());
        holder.tvFaculty.setText("Faculty: " + student.getFaculty());

        // set click listeners
        holder.ivEditThisTodo.setOnClickListener(v -> {

            new AlertDialog.Builder(v.getContext()).setTitle("Update A Row")
                    .setMessage("This dialog helps update students!")
                    .setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.dismiss()).show();

        });

        holder.ivDeleteThisTodo.setOnClickListener(v -> {
            dbHelper = new DBHelper(v.getContext());
            new AlertDialog.Builder(v.getContext()).setTitle("Delete This Record")
                    .setMessage("Are you sure you want to delete this student's record?")
                    .setPositiveButton("Yes", (dialogInterface, i) -> {
                        boolean deleted = dbHelper.deleteStudent(Integer.parseInt(holder.tvId.getText().toString().split(": ")[1]));
                        if (deleted) {
                            Toast.makeText(v.getContext(), "Student Deleted Successfully", Toast.LENGTH_SHORT).show();
                            studentList.remove(position);
                            this.notifyItemRemoved(position);
                        } else {
                            Toast.makeText(v.getContext(), "Deletion Failed", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancel", ((dialogInterface, i) -> dialogInterface.dismiss()))
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView tvId, tvName, tvAddress, tvFaculty;
        ImageView ivEditThisTodo, ivDeleteThisTodo;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvFaculty = itemView.findViewById(R.id.tvFaculty);

            ivEditThisTodo = itemView.findViewById(R.id.ivEditThisTodo);
            ivDeleteThisTodo = itemView.findViewById(R.id.ivDeleteThisTodo);

        }
    }
}
