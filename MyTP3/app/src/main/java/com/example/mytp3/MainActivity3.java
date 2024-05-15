package com.example.mytp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    private static final int SMS_PERMISSION_REQUEST_CODE = 100;
    private EditText editTextPhoneNumber;
    private String moyenne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView textViewMoyenne = findViewById(R.id.textView);
        Intent intent=getIntent();
        moyenne = intent.getStringExtra(MainActivity.Moyenne);

        textViewMoyenne.setText("Navre , nous n'avez pas réussi et votre moyenne est de "+moyenne);

        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        Button buttonSendSMS = findViewById(R.id.buttonSendSMS);
        buttonSendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMS2();
            }
        });
    }
    private void sendSMS2() {
        String phoneNumber = editTextPhoneNumber.getText().toString();
        if (phoneNumber.isEmpty()) {
            Toast.makeText(this, "Veuillez saisir un numéro de téléphone", Toast.LENGTH_SHORT).show();
            return;
        }

        String message = "Navre , nous n'avez pas réussi et votre moyenne est de" + moyenne;

        Uri uri = Uri.parse("smsto:" + phoneNumber);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", message);
        startActivity(intent);
    }
}