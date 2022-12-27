package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button myBMICalculator, APIButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myBMICalculator = (Button)findViewById(R.id.BMIbutton);
        APIButton = (Button)findViewById(R.id.BMIAPIbutton);

        myBMICalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMyBMICalculator();
            }
        });

        APIButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBmiApiCall();
            }
        });
    }

    public void openMyBMICalculator()
    {
        Intent myCalculator = new Intent(this, MainActivity2.class);
        startActivity(myCalculator);
    }

    public void openBmiApiCall()
    {
        Intent myAPICall = new Intent(this, MainActivity3.class);
        startActivity(myAPICall);
    }
}