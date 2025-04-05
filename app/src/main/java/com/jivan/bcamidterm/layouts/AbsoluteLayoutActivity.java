package com.jivan.bcamidterm.layouts;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jivan.bcamidterm.R;

public class AbsoluteLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_absolute_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.alParent), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            var layoutPadding = findViewById(R.id.alParent).getPaddingTop();
            v.setPadding(layoutPadding, layoutPadding, layoutPadding, layoutPadding);
            return insets;
        });
    }
}