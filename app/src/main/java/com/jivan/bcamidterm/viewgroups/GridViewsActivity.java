package com.jivan.bcamidterm.viewgroups;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jivan.bcamidterm.R;

public class GridViewsActivity extends AppCompatActivity {

    GridView gvGrid;
    ArrayAdapter<String> adapter;
    String[] info = {
            "Jivan Kadel", "10", "BCA",
            "Pratik Satta", "17", "BCA",
            "Pranil Shrestha", "18", "BIT",
            "Kishor BK", "11", "BIM",
            "Dilli Razz", "7", "CSIT"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid_views);

        gvGrid = findViewById(R.id.gvGrid);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.gvParent), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            var layoutPadding = v.getPaddingTop();
            v.setPadding(layoutPadding, systemBars.top + layoutPadding, layoutPadding, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        gvGrid.setNumColumns(3);
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, info);
        gvGrid.setAdapter(adapter);
    }
}