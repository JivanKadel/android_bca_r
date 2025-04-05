package com.jivan.bcamidterm.layouts;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jivan.bcamidterm.R;

public class TableLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_table_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tlParent), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            var layoutPadding = findViewById(R.id.tlParent).getPaddingTop();
            v.setPadding(layoutPadding, systemBars.top, layoutPadding, systemBars.bottom);
            return insets;
        });
    }
}