package com.example.weatherreport;

import com.example.weatherreport.ServiceLayer.GetServiceData;
import com.example.weatherreport.ServiceLayer.RetrofitClientInstance;
import com.example.weatherreport.models.WeatherInfo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherInfoResponse {
 private List<WeatherInfo> responseList;

    private ArrayList<String> mcity = new ArrayList<>();

    public List<WeatherInfo> getWeatherInfo() {
        mcity.add("chennai");
        mcity.add("bangalore");
        mcity.add("mumbai");
        for (String cityName : mcity) {
            GetServiceData getServiceData = RetrofitClientInstance.getRetrofitInstance().create(GetServiceData.class);
            Call<WeatherInfo> call = getServiceData.getInfo(cityName);
            call.enqueue(new Callback<com.example.weatherreport.models.WeatherInfo>() {
                @Override
                public void onResponse(Call<com.example.weatherreport.models.WeatherInfo> call, Response<WeatherInfo> response) {
                    responseList.add(response.body());


                }

                @Override
                public void onFailure(Call<com.example.weatherreport.models.WeatherInfo> call, Throwable t) {

                }
            });


        }

        return responseList;

    }





}

