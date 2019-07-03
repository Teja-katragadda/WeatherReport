package com.example.weatherreport.Models;

import com.google.gson.annotations.SerializedName;

class Wind {
    @SerializedName("speed")
    private Double speed;

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    public Double getSpeed() {
        return speed;
    }

    public Integer getDeg() {
        return deg;
    }

    @SerializedName("deg")
    private Integer deg;
}
