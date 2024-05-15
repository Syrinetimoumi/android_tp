package com.example.mytp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    public static final String Moyenne="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextNote1 = findViewById(R.id.editTextText);
        EditText editTextNote2 = findViewById(R.id.editTextText2);
        EditText editTextNote3 = findViewById(R.id.editTextText3);

        EditText editTextCoff1 = findViewById(R.id.editTextText4);
        EditText editTextCoff2 = findViewById(R.id.editTextText5);
        EditText editTextCoff3 = findViewById(R.id.editTextText6);
        TextView textView = findViewById(R.id.textView);
        button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double note1 = Double.parseDouble(editTextNote1.getText().toString());
                double note2 = Double.parseDouble(editTextNote2.getText().toString());
                double note3 = Double.parseDouble(editTextNote3.getText().toString());

                double coeff1 = Double.parseDouble(editTextCoff1.getText().toString());
                double coeff2 = Double.parseDouble(editTextCoff2.getText().toString());
                double coeff3 = Double.parseDouble(editTextCoff3.getText().toString());

                // Calcul de la moyenne pondérée
                double moyenne = (note1 * coeff1 + note2 * coeff2 + note3 * coeff3) / (coeff1 + coeff2 + coeff3);
                if (moyenne >= 10){
                    openActivityR(moyenne);
                } else{
                    openActivityF(moyenne);
                }

            }
        });
    }
    public void openActivityR(double moyenne){
        String Moy=String.valueOf(moyenne);
        Intent intent= new Intent(this, MainActivity2.class);
        intent.putExtra(Moyenne,Moy);
        startActivity(intent);
    }
    public void openActivityF(double moyenne){
        String Moy=String.valueOf(moyenne);
        Intent intent= new Intent(this, MainActivity3.class);
        intent.putExtra(Moyenne,Moy);
        startActivity(intent);
    }
}