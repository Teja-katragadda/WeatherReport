package com.example.weatherreport;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.ObservableField;
import android.util.Log;

import com.example.weatherreport.models.WeatherInfo;
import com.example.weatherreport.network.WeatherServiceManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class WeatherViewModel implements LifecycleObserver {


    private static final String TAG = "WeatherViewModel";
    public ObservableField<String> cityName = new ObservableField<>();
    public ObservableField<String> temperature = new ObservableField<>();
    public ObservableField<String> description = new ObservableField<>();
    public List<WeatherItemViewModel> weatherItemViewModelList = new ArrayList<>();
    public WeatherListAdapter weatherListAdapter;
    public WeatherServiceManager weatherServiceManager;
    private ArrayList<String> mcity = new ArrayList<>();

    @Inject
    public WeatherViewModel(WeatherServiceManager weatherServiceManager) {
        this.weatherServiceManager = weatherServiceManager;
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void getWeatherData() {

        weatherListAdapter = new WeatherListAdapter(weatherItemViewModelList);
        createCityList();
        getWeatherInfo();

    }


    public void createCityList() {

        mcity.add("chennai");
        mcity.add("bangalore");
        mcity.add("mumbai");
        mcity.add("hyderabad");
        mcity.add("erode");
        mcity.add("salem");
        mcity.add("coimbatore");
        mcity.add("vizag");
        mcity.add("kanyakumari");
        mcity.add("chennai");
        mcity.add("bangalore");
        mcity.add("mumbai");
        mcity.add("hyderabad");
        mcity.add("erode");
        mcity.add("salem");
        mcity.add("coimbatore");
        mcity.add("vizag");
        mcity.add("kanyakumari");
        mcity.add("chennai");
        mcity.add("bangalore");
        mcity.add("mumbai");
        mcity.add("hyderabad");
        mcity.add("erode");
        mcity.add("salem");
        mcity.add("coimbatore");


    }


    public WeatherListAdapter getAdapter() {
        return weatherListAdapter;
    }


    public void getWeatherInfo() {
        for(String mCityName : mcity){

            weatherServiceManager.getInfo(mCityName).subscribe(this::bindViews,this::failure);

        }

    }

    private void failure(Throwable throwable) {


    }

    private void bindViews(WeatherInfo weatherInfo) {

        if(weatherInfo!=null){
            WeatherItemViewModel weatherItemViewModel = new WeatherItemViewModel();
            weatherItemViewModel.setTemperature(String.valueOf(weatherInfo.getMain().getTemp()));
            weatherItemViewModel.setCityName(weatherInfo.getName());
            weatherItemViewModel.setDescription(weatherInfo.getWeather().get(0).getDescription());

            weatherItemViewModelList.add(weatherItemViewModel);

            weatherListAdapter.notifyDataSetChanged();


        }
    }


}

