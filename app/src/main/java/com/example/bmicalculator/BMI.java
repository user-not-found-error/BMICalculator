package com.example.bmicalculator;

import com.google.gson.annotations.SerializedName;

import java.util.Random;

public class BMI {
    @SerializedName("bmi")
    private double bmi;
    @SerializedName("more")
    private String[] more;
    @SerializedName("risk")
    private String risk;

    public BMI(double bmi, String[] more, String risk)
    {
        this.bmi = bmi;
        this.more = more;
        this.risk = risk;
    }

    public double getBMIvalue() {
        return bmi;
    }

    public String getRisk() {
        return risk;
    }

    public String getUrl() {
        Random random = new Random();
        int index = random.nextInt(more.length);
        return more[index];
    }


}
