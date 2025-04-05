package com.jivan.bcamidterm.viewgroups;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jivan.bcamidterm.R;

public class ListViewsActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    String[] faculty = {"BCA", "BIM", "BIT", "CSIT", "BBS", "BBA", "BSc. IT", "BSW", "BE", "BM", "BP", "BPH", "BN"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_views);

        listView = findViewById(R.id.lvList);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lvParent), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            var layoutPadding = findViewById(R.id.lvParent).getPaddingTop();
            v.setPadding(layoutPadding, systemBars.top + layoutPadding, layoutPadding, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, faculty);
        listView.setAdapter(adapter);

    }
}