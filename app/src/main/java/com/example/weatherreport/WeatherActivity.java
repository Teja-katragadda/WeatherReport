package com.example.weatherreport;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.weatherreport.databinding.WeatherActivityBinding;
import com.example.weatherreport.models.WeatherInfo;

import java.util.ArrayList;
import java.util.List;

public class WeatherActivity extends AppCompatActivity implements LifecycleOwner {


    WeatherViewModel weatherViewModel;
    WeatherActivityBinding weatherActivityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        weatherViewModel = new WeatherViewModel();
        weatherActivityBinding = DataBindingUtil.setContentView(this,R.layout.weather_activity);
        weatherActivityBinding.setViewModel(weatherViewModel);
        this.getLifecycle().addObserver(weatherViewModel);
//        weatherActivityBinding.recyclerView1.setAdapter(weatherViewModel.getAdapter());
      weatherActivityBinding.setViewModel(weatherViewModel);

    }
}
