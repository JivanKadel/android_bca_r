package com.jivan.bcamidterm.fragments;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jivan.bcamidterm.R;

public class FragmentParent extends AppCompatActivity {

    Button btnFragment1, btnFragment2;

    FormFragment firstFragment;
    NextFormFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragment_parent);

        btnFragment1 = findViewById(R.id.btnFragment1);
        btnFragment2 = findViewById(R.id.btnFragment2);

        firstFragment = new FormFragment();
        secondFragment = new NextFormFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.flFragmentParent, firstFragment).commit();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());

            var layoutPadding = v.getPaddingTop();
            v.setPadding(layoutPadding, systemBars.top, layoutPadding, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        btnFragment1.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragmentParent, secondFragment).commit();
        });

        btnFragment2.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragmentParent, firstFragment).commit();
        });

    }
}