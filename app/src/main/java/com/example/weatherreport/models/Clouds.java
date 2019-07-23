package com.example.weatherreport.models;

import com.google.gson.annotations.SerializedName;

 public class Clouds {
    @SerializedName("all")
    private Integer all;

    public void setAll(Integer all) {
        this.all = all;
    }

    public Integer getAll() {
        return all;
    }
}
