package com.example.mytpn03;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 70;

    private TextView receivedMessageTextView;
    private TextView textView;
    private EditText messageEditText;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receivedMessageTextView = findViewById(R.id.textView);
        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                if (message != null && !message.isEmpty()){
                    intent.putExtra("message", message);
                    startActivityForResult(intent, REQUEST_CODE);
                }else{
                    Toast.makeText(MainActivity.this, "Empty message received", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String response = data.getStringExtra("response");
                if (response != null && !response.isEmpty()) {
                    textView.setText(response);
                } else {
                    Toast.makeText(this, "Empty response received", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}