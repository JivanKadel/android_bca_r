package com.jivan.bcamidterm.activities;

import android.app.Activity;
import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jivan.bcamidterm.R;

public class SenderActivity extends AppCompatActivity {
    EditText etNumberToSend;
    TextView tvReceivedBackNumber;
    Button btnSendNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sender);

        etNumberToSend = findViewById(R.id.etNumberToSend);
        tvReceivedBackNumber = findViewById(R.id.tvReceivedBackNumber);
        btnSendNumber = findViewById(R.id.btnSendNumber);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        btnSendNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // Send number via intent
                    int inputNumber = Integer.parseInt(etNumberToSend.getText().toString());
                    Intent intent = new Intent(getApplicationContext(), ReceiverActivity.class);
                    intent.putExtra("inputNumber", inputNumber);
//                    startActivity(intent);
                    startActivityForResult(intent, 101);

                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Incorrect Input, " + e, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == Activity.RESULT_OK) {
            try {
                int resultValue = data.getIntExtra("inputNumberIntoTen", 0);
//                tvReceivedBackNumber.setText(String.valueOf(resultValue));

                Toast.makeText(getApplicationContext(), "Received Number: " + resultValue, Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            }

        }
    }
}