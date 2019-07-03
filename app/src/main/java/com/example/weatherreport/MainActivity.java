package com.example.weatherreport;

import android.app.ProgressDialog;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.weatherreport.ServiceLayer.GetServiceData;
import com.example.weatherreport.ServiceLayer.RetrofitClientInstance;
import com.example.weatherreport.Models.WeatherInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    WeatherInfo weatherInfo = new WeatherInfo();
    ViewPager viewPager;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new AdapterClass(fragmentManager));

    }

    }




