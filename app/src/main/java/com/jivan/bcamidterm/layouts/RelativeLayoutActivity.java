package com.jivan.bcamidterm.layouts;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jivan.bcamidterm.R;

public class RelativeLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_relative_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rlForm), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            var viewPadding = findViewById(R.id.rlForm).getPaddingTop();
            v.setPadding(viewPadding, systemBars.top, viewPadding, viewPadding);
            return insets;
        });
    }
}