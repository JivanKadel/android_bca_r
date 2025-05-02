package com.jivan.bcamidterm.viewgroups;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jivan.bcamidterm.R;
import com.jivan.bcamidterm.models.Todo;

public class RecyclerViewsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TodoAdapter todoAdapter;

    Todo[] todos = new Todo[]{
            new Todo("Name (for lab report)", "Jivan Kadel, 10, BCA, Samriddhi", true),
            new Todo("MP Assignment", "Complete Android Assignments", false),
            new Todo("Economics Assignment", "Complete Economics Assignment", true),
            new Todo("AJP Assignment", "Advanced Java Assignment", false),
            new Todo("DS Assignment", "Distributed System Assignment", true),
            new Todo("NP Assignment", "Java Networking Assignment", false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_views);

        todoAdapter = new TodoAdapter(todos);


        recyclerView = findViewById(R.id.rvTodos);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(todoAdapter);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rvParent), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());

            var layoutPadding = findViewById(R.id.rvParent).getPaddingTop();
            v.setPadding(layoutPadding, systemBars.top + layoutPadding, layoutPadding, systemBars.bottom);
            return insets;
        });
    }
}