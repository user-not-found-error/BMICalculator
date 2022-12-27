package com.example.bmicalculator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class MainActivity3 extends AppCompatActivity {

    private Button apiButton, eduButton;
    private RequestQueue requestQueue;
    private BMI webResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        requestQueue = Volley.newRequestQueue(this);

        apiButton = (Button)findViewById(R.id.APIButton);
        eduButton = (Button)findViewById(R.id.EduButton);

        apiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText heightEditText = (EditText)findViewById(R.id.heightEditText2);
                EditText weightEditText = (EditText)findViewById(R.id.weightEditText2);

                double height = Double.parseDouble(heightEditText.getText().toString());
                double weight = Double.parseDouble(weightEditText.getText().toString());

                getAPIresult(height, weight);
            }


        });

        eduButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(webResult.getUrl() != null)
                {
                    loadPage();
                }
            }
        });
    }

    public void getAPIresult(double height, double weight)
    {
        Gson gson = new Gson();
        String url = "http://webstrar99.fulton.asu.edu/page3/Service1.svc/calculateBMI?height=" + height + "&weight=" + weight;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        webResult = gson.fromJson(response, BMI.class);
                        calculateBMIbyAPI();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error", error.toString());
                    }
                });



        requestQueue.add(stringRequest);
    }

    public void calculateBMIbyAPI()
    {
        TextView labelTextView = (TextView)findViewById(R.id.LabelTextView2);
        TextView messageTextView = (TextView)findViewById(R.id.MessageTextView2);

        int BMIresult = (int)webResult.getBMIvalue();

        labelTextView.setText(BMIresult + "");

        if(BMIresult < 18)
        {
            messageTextView.setText(webResult.getRisk());
            messageTextView.setTextColor(Color.BLUE);
        }
        else if(BMIresult >= 18 && BMIresult < 25)
        {
            messageTextView.setText(webResult.getRisk());
            messageTextView.setTextColor(Color.GREEN);
        }
        else if(BMIresult >= 25 && BMIresult < 30)
        {
            messageTextView.setText(webResult.getRisk());
            messageTextView.setTextColor(Color.parseColor("#6a0dad"));
        }
        else if(BMIresult >= 30)
        {
            messageTextView.setText(webResult.getRisk());
            messageTextView.setTextColor(Color.RED);
        }
    }

    public void loadPage()
    {
        Intent intent = new Intent(this, MainActivity4.class);
        intent.putExtra("url", webResult.getUrl());
        startActivity(intent);
    }
}