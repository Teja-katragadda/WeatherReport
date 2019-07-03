package com.example.weatherreport;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
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


public class FragmentFirstScreen extends Fragment {
    WeatherInfo weatherInfo ;

    TextView fragment1;
    TextView humidity_degree;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragment_first_screen, container, false);
        fragment1 = view.findViewById(R.id.fragment1);
        humidity_degree=view.findViewById(R.id.humidity_degree);
getWeatherInfo();
        return view;

    }

    public void getWeatherInfo() {

        GetServiceData getServiceData = RetrofitClientInstance.getRetrofitInstance().create(GetServiceData.class);
        Call<WeatherInfo> call = getServiceData.getInfo("chennai");
        call.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                weatherInfo = response.body();
                fragment1.setText(weatherInfo.getName());
                humidity_degree.setText(String.valueOf(weatherInfo.getMain().getHumidity()));



            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {


            }
        });


    }}
