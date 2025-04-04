package com.jivan.bcamidterm.layouts;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jivan.bcamidterm.R;

public class LinearLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        LinearLayout rootView = findViewById(R.id.llRoot);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            Insets cutoutInsets = insets.getInsets(WindowInsetsCompat.Type.displayCutout());

            var topPadding = Math.max(systemBars.top, cutoutInsets.top);

            view.setPadding(view.getPaddingLeft(), topPadding, view.getPaddingRight(), view.getPaddingBottom());
            return insets;
        });

    }
}