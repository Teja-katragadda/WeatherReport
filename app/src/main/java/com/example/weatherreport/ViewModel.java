package com.example.weatherreport;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.example.weatherreport.Models.WeatherInfo;

import java.util.ArrayList;
import java.util.List;

public class ViewModel {
    private WeatherResponse weatherResponse;
    private  List<WeatherInfo> weatherInfoList = new ArrayList<>();

    public ViewModel(WeatherResponse weatherRes) {
        weatherResponse = new WeatherResponse(weatherRes.getPlace(), weatherRes.getHumidity(), weatherRes.getHumidity_degree(), weatherRes.getTemperature(), weatherRes.getTemperature_degree());
    }

    public ViewModel() {

    }


    public String getPlace() {
        return weatherResponse.getPlace();
    }


    public String getHumidity() {
        return weatherResponse.getHumidity();
    }


    public String getHumidity_degree() {
        return weatherResponse.getHumidity_degree();
    }


    public String getTemperature() {
        return weatherResponse.getTemperature();
    }


    public String getTemeprature_degree() {
        return weatherResponse.getTemperature_degree();
    }

    public ViewPagerAdapter getAdap(View view) {

        return new ViewPagerAdapter(view.getContext(),weatherInfoList);
    }


}
