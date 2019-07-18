package com.example.weatherreport.network;

import android.databinding.ObservableField;

import com.example.weatherreport.models.WeatherInfo;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface WeatherServiceData {

    @Headers({"X-RapidAPI-Key: b9a5b58ef3msh4c673aa296f5128p16d422jsnca79c1476ad4",})

    @GET("/weather")
    Observable<WeatherInfo> getInfo(@Query("q") String place);

}
