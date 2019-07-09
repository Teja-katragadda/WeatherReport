package com.example.weatherreport;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.weatherreport.ServiceLayer.GetServiceData;
import com.example.weatherreport.ServiceLayer.RetrofitClientInstance;
import com.example.weatherreport.Models.WeatherInfo;
import com.example.weatherreport.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<WeatherInfo> weatherInfo = new ArrayList<>();
    private ArrayList<String> mcity = new ArrayList<>();
    ViewModel model;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        WeatherResponse weatherResponse=new WeatherResponse();
//        model=new ViewModel(weatherResponse);
//
//        viewPager = findViewById(R.id.viewPager);
        mcity();
        weatherInfo(mcity);

    }

    private void weatherInfo(final ArrayList<String> mcity) {
        for (String cityName : mcity) {
            GetServiceData getServiceData = RetrofitClientInstance.getRetrofitInstance().create(GetServiceData.class);
            Call<WeatherInfo> call = getServiceData.getInfo(cityName);
            call.enqueue(new Callback<WeatherInfo>() {
                @Override
                public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {


                    if (response != null) {
                        WeatherInfo weatherInfoTemp = response.body();
                        weatherInfo.add(weatherInfoTemp);
                    }


                    if (mcity.size() == weatherInfo.size()) {
                       ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(MainActivity.this, weatherInfo);


                    }
                }

                @Override
                public void onFailure(Call<WeatherInfo> call, Throwable t) {

                }
            });
        }
    }


    private void mcity() {
        mcity.add("chennai");
        mcity.add("bangalore");
        mcity.add("mumbai");
        mcity.add("dubai");
    }

}




