package com.jivan.bcamidterm.widgets;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jivan.bcamidterm.R;


public class WidgetsImplementationActivity extends AppCompatActivity {

    String[] faculty = {
            "BCA", "BIM", "CSIT", "CE", "BIT"
    };
    Spinner facultySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_widgets_implementation);

        facultySpinner = findViewById(R.id.wiSpinnerFaculty);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.widgets), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            Insets imeInsets = insets.getInsets(WindowInsetsCompat.Type.ime());

            // Apply only the necessary padding
            int topPadding = systemBars.top; // Keep padding for the status bar
            int bottomPadding = imeInsets.bottom; // Handle IME (keyboard) insets
            int existingPadding = findViewById(R.id.widgets).getPaddingLeft();

            v.setPadding(existingPadding, topPadding, existingPadding, bottomPadding + existingPadding);
            return insets;
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, faculty);
        facultySpinner.setAdapter(adapter);
    }
}