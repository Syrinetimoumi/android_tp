package com.example.mytp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.Manifest;
import android.content.pm.PackageManager;
import android.telephony.SmsManager;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
public class MainActivity2 extends AppCompatActivity {
    private static final int SMS_PERMISSION_REQUEST_CODE = 100;
    private EditText editTextPhoneNumber;
    private String moyenne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textViewMoyenne = findViewById(R.id.textView);

        Intent intent=getIntent();
        moyenne = intent.getStringExtra(MainActivity.Moyenne);
        textViewMoyenne.setText("Felicitation , votre moyenne est de "+moyenne);

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

        String message = "Felicitation, votre moyenne est de " + moyenne;

        Uri uri = Uri.parse("smsto:" + phoneNumber);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", message);
        startActivity(intent);
    }

}