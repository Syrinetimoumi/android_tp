package com.example.newproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private EditText responseEditText;
    private TextView message ;
    private Button sendResponseButton;
    private static final int REQUEST_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        message =findViewById(R.id.textView2);
        responseEditText = findViewById(R.id.responseEditText);
        sendResponseButton = findViewById(R.id.sendResponseButton);


        final String receivedMessage = getIntent().getStringExtra("message");
        message.setText(receivedMessage);
        sendResponseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String responseMessage = responseEditText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("response", responseMessage);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}