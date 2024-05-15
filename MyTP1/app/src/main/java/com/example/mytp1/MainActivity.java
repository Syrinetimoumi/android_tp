
package com.example.mytp1;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAmount;

    private RadioGroup monRadioGroup;
    private RadioButton radioDinarToEuro, radioEuroToDinar;
    private Button buttonConvert;
    private TextView textViewResult;

    private double dinarToEuroRate = 0.008; // 1 Dinar = 0.008 Euro

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAmount = findViewById(R.id.editTextAmount);
        monRadioGroup =  findViewById(R.id.monRadioGroup );
        radioDinarToEuro = findViewById(R.id.radioDinarToEuro);
        radioEuroToDinar = findViewById(R.id.radioEuroToDinar);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrency();
            }
        });
    }

    private void convertCurrency() {
        double amount = Double.parseDouble(editTextAmount.getText().toString());
        double result;

        if (radioDinarToEuro.isChecked()) {
            result = amount * dinarToEuroRate;
            textViewResult.setText(String.format("%.2f Dinar(s) = %.2f Euro(s)", amount, result));
        } else if (radioEuroToDinar.isChecked()) {
            result = amount / dinarToEuroRate;
            textViewResult.setText(String.format("%.2f Euro(s) = %.2f Dinar(s)", amount, result));
        }
    }
}
