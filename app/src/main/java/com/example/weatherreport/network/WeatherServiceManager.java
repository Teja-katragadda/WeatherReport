package com.example.weatherreport.network;

import android.databinding.ObservableField;

import com.example.weatherreport.models.WeatherInfo;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class WeatherServiceManager {

    WeatherServiceData weatherServiceData;

    @Inject
    public WeatherServiceManager(WeatherServiceData weatherServiceData) {
        this.weatherServiceData = weatherServiceData;
    }

    public Observable<WeatherInfo> getInfo(String cityName) {
        return weatherServiceData.getInfo(cityName).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

    }
}
