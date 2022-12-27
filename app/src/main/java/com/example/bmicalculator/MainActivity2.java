package com.example.bmicalculator;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private Button calButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        calButton = (Button)findViewById(R.id.APIButton);
        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText heightEditText = (EditText)findViewById(R.id.heightEditText);
                EditText weightEditText = (EditText)findViewById(R.id.weightEditText);
                TextView labelTextView = (TextView)findViewById(R.id.LabelTextView);
                TextView messageTextView = (TextView)findViewById(R.id.MessageTextView);

                double height = Double.parseDouble(heightEditText.getText().toString());
                double weight = Double.parseDouble(weightEditText.getText().toString());

                int BMIresult = (int)((weight/((height)*(height)))*703);

                labelTextView.setText(BMIresult + "");

                if(BMIresult < 18)
                {
                    messageTextView.setText("You are underweight");
                    messageTextView.setTextColor(Color.BLUE);
                }
                else if(BMIresult >= 18 && BMIresult < 25)
                {
                    messageTextView.setText("You are normal");
                    messageTextView.setTextColor(Color.GREEN);
                }
                else if(BMIresult >= 25 && BMIresult < 30)
                {
                    messageTextView.setText("You are pre-obese");
                    messageTextView.setTextColor(Color.parseColor("#6a0dad"));
                }
                else if(BMIresult >= 30)
                {
                    messageTextView.setText("You are obese");
                    messageTextView.setTextColor(Color.RED);
                }


            }
        });
    }
}