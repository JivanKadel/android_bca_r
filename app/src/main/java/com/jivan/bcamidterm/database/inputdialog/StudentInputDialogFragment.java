package com.jivan.bcamidterm.database.inputdialog;


import android.app.Dialog;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.jivan.bcamidterm.R;

public class StudentInputDialogFragment extends DialogFragment {
    private EditText etStudentName, etStudentAddress, etStudentFaculty;

    private StudentDialogListener listener;

    public interface StudentDialogListener {
        void onStudentAdded(String name, String address, String faculty);
    }

    public StudentInputDialogFragment() {

    }

    public void setListener(StudentDialogListener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_input_dialog, container, false);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_student_input_dialog, null);

        etStudentName = view.findViewById(R.id.etStudentName);
        etStudentAddress = view.findViewById(R.id.etStudentAddress);
        etStudentFaculty = view.findViewById(R.id.etStudentFaculty);

        builder.setView(view)
                .setTitle("Add Student To Database")
                .setPositiveButton("Add Student", (dialog, which) -> {
                    // Retrieve the input value
                    if (etStudentName.getText() != null && etStudentFaculty.getText() != null && etStudentAddress.getText() != null) {
                        String name = etStudentName.getText().toString();
                        String address = etStudentAddress.getText().toString();
                        String age = etStudentFaculty.getText().toString();
                        if (listener != null) {
                            listener.onStudentAdded(name, age, address);
                        }
                    }
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        return builder.create();
    }


}