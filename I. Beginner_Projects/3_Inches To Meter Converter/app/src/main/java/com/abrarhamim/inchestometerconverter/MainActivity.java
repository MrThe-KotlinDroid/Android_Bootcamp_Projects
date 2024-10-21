package com.abrarhamim.inchestometerconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    private EditText inchesEditText;
    private Button buttonConvert;
    private TextView meterResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setUpButtonClickConverter();
    }

    private void findView() {
        inchesEditText = findViewById(R.id.edit_text_inches);
        buttonConvert = findViewById(R.id.button_convert);
        meterResultText = findViewById(R.id.text_view_meter_result);
    }

    private void setUpButtonClickConverter() {
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inchesString = inchesEditText.getText().toString();


                if (inchesString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please input inches", Toast.LENGTH_LONG).show();
                } else {
                    double result = calculateHeight(inchesString);
                    displayResult(result);
                }
            }
        });
    }

    private double calculateHeight(String inchesString) {
        int inches = Integer.parseInt(inchesString);
        return inches * 0.0254;
    }

    private void displayResult(double result) {
        DecimalFormat myFormatter = new DecimalFormat("0.00");
        String resultString = myFormatter.format(result);
        meterResultText.setText(resultString + " meters");
    }

}