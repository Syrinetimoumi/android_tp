package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNumber1, editTextNumber2;
    private TextView textViewResult;
    private RadioButton radioButtonAdd, radioButtonSubtract, radioButtonMultiply, radioButtonDivide;
    private Button buttonCalculate;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextText);
        editTextNumber2 = findViewById(R.id.editTextText);
        textViewResult = findViewById(R.id.textView3);
        radioButtonAdd = findViewById(R.id.radioButton);
        radioButtonSubtract = findViewById(R.id.radioButton2);
        radioButtonMultiply = findViewById(R.id.radioButton4);
        radioButtonDivide = findViewById(R.id.radioButton3);
        buttonCalculate = findViewById(R.id.buttonCalcul);
        imageView = findViewById(R.id.imageView);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }


    private void calculate() {
        try {
            double num1 = Double.parseDouble(editTextNumber1.getText().toString());
            double num2 = Double.parseDouble(editTextNumber2.getText().toString());
            double result = 0;

            if (radioButtonAdd.isChecked()) {
                result = num1 + num2;
            } else if (radioButtonSubtract.isChecked()) {
                result = num1 - num2;
            } else if (radioButtonMultiply.isChecked()) {
                result = num1 * num2;
            } else if (radioButtonDivide.isChecked()) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    textViewResult.setText("Cannot divide by zero");
                    return;
                }
            }

            textViewResult.setText("Result: " + result);
        } catch (NumberFormatException e) {
            textViewResult.setText("Please enter valid numbers");
        }
    }

}