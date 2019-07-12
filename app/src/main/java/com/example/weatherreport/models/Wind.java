package com.example.weatherreport.models;

import com.google.gson.annotations.SerializedName;

public class Wind {
    @SerializedName("speed")
    private Double speed;
    @SerializedName("deg")
    private Double deg;

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public void setDeg(Double deg) {
        this.deg = deg;
    }

    public Double getSpeed() {
        return speed;
    }

    public Double getDeg() {
        return deg;
    }


}
