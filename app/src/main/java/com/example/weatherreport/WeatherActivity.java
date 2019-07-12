package com.example.weatherreport;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.weatherreport.databinding.WeatherActivityBinding;

public class WeatherActivity extends AppCompatActivity implements LifecycleOwner {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WeatherViewModel weatherViewModel = new WeatherViewModel();
        WeatherActivityBinding weatherActivityBinding = DataBindingUtil.setContentView(this, R.layout.weather_activity);
        this.getLifecycle().addObserver(weatherViewModel);

        weatherActivityBinding.recyclerView1.setAdapter(weatherViewModel.getAdapter());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        weatherActivityBinding.recyclerView1.setLayoutManager(linearLayoutManager);
        weatherActivityBinding.recyclerView1.setHasFixedSize(true);
        weatherActivityBinding.setViewModel(weatherViewModel);

    }
}
