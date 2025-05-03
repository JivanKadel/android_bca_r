package com.jivan.bcamidterm.database;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jivan.bcamidterm.R;
import com.jivan.bcamidterm.database.inputdialog.StudentInputDialogFragment;
import com.jivan.bcamidterm.database.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentCRUDActivity extends AppCompatActivity implements StudentInputDialogFragment.StudentDialogListener {
    private DBHelper dbHelper;
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private List<Student> studentList;
    private FloatingActionButton fabAddStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_crud_activity);

        dbHelper = new DBHelper(this);
        recyclerView = findViewById(R.id.rvStudents);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fabAddStudent = findViewById(R.id.fabAddStudent);

        loadStudents();

        fabAddStudent.setOnClickListener(v -> {
            StudentInputDialogFragment dialog = new StudentInputDialogFragment();
            dialog.setListener(this);
            dialog.show(getSupportFragmentManager(), "Student Dialog");
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.student_crud), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void loadStudents() {
        studentList = dbHelper.getAllStudents();
        if (studentList.isEmpty()) {
            Toast.makeText(this, "Student table is empty", Toast.LENGTH_SHORT).show();
        } else {
            studentAdapter = new StudentAdapter(studentList);
            recyclerView.setAdapter(studentAdapter);
        }
    }

    @Override
    public void onStudentAdded(String name, String address, String faculty) {
        dbHelper.insertStudent(name, address, faculty);
        loadStudents();
    }
}