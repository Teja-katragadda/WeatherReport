package com.example.weatherreport;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.weatherreport.models.WeatherInfo;
import com.example.weatherreport.ServiceLayer.GetServiceData;
import com.example.weatherreport.ServiceLayer.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SecondFragment extends Fragment {
    WeatherInfo weatherInfo=new WeatherInfo();
    TextView fragment,humidity_degree,temperature,temperature_degree;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         //view= inflater.inflate(R.layout.fragment_second, container, false);
//       fragment=view.findViewById(R.id.fragment2);
        humidity_degree=view.findViewById(R.id.humidity_degree);
        temperature=view.findViewById(R.id.temperature);
        temperature_degree=view.findViewById(R.id.temperature_degree);
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
                humidity_degree.setText(String.valueOf(weatherInfo.getMain().getHumidity()));
                temperature_degree.setText(String.valueOf(weatherInfo.getMain().getTempMax()));
            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {


            }
        });


    }



}
