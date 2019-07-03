package com.example.weatherreport;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.weatherreport.Models.WeatherInfo;
import com.example.weatherreport.ServiceLayer.GetServiceData;
import com.example.weatherreport.ServiceLayer.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SecondFragment extends Fragment {
    WeatherInfo weatherInfo=new WeatherInfo();
    TextView fragment;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         view= inflater.inflate(R.layout.fragment_second, container, false);
        fragment=view.findViewById(R.id.fragment2);
        getWeatherInfo();
        return view;
    }

    public void getWeatherInfo() {

        GetServiceData getServiceData = RetrofitClientInstance.getRetrofitInstance().create(GetServiceData.class);
        Call<WeatherInfo> call = getServiceData.getInfo("bangalore");
        call.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                weatherInfo = response.body();
                fragment.setText(weatherInfo.getName());
            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {


            }
        });


    }



}
