package com.jivan.bcamidterm.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jivan.bcamidterm.R;

public class ReceiverActivity extends AppCompatActivity {

    EditText etReceivedNumber, etNumberToSendBack;
    Button btnSendNumberBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_receiver);

        etReceivedNumber = findViewById(R.id.etReceivedNumber);
        etNumberToSendBack = findViewById(R.id.etNumberToSendBack);
        btnSendNumberBack = findViewById(R.id.btnSendNumberBack);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.receiverActivity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            var layoutPadding = findViewById(R.id.receiverActivity).getPaddingTop();
            v.setPadding(layoutPadding, systemBars.top, layoutPadding, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Get sent number
        int number = getIntent().getIntExtra("inputNumber", 0);
        etReceivedNumber.setText(String.valueOf(number));


        btnSendNumberBack.setOnClickListener(v -> {
            int numberToSend = Integer.parseInt(etNumberToSendBack.getText().toString());
            // Send Number Back
            Intent intent = new Intent();
            intent.putExtra("inputNumberIntoTen", numberToSend);
            Log.d("ChildActivity", "Sending back number: " + numberToSend);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });

    }
}