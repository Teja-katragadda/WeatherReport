package com.example.weatherreport;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class WeatherViewModel extends ViewModel implements LifecycleObserver {

    public List<WeatherItemViewModel> weatherItemViewModelList = new ArrayList<>();
    public WeatherListAdapter weatherListAdapter =  new WeatherListAdapter();


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void getWeatherData(){

        WeatherItemViewModel weatherItemViewModel = new WeatherItemViewModel();

        weatherItemViewModel.setCityName("Chennai 1");
        weatherItemViewModel.setDescription("Partly cloudy 1");
        weatherItemViewModel.setTemperature(33);

        WeatherItemViewModel weatherItemViewModel1 = new WeatherItemViewModel();

        weatherItemViewModel1.setCityName("Chennai 2");
        weatherItemViewModel1.setDescription("Partly cloudy 2");
        weatherItemViewModel1.setTemperature(34);

        WeatherItemViewModel weatherItemViewModel2 = new WeatherItemViewModel();

        weatherItemViewModel2.setCityName("Chennai 3");
        weatherItemViewModel2.setDescription("Partly cloudy 3");
        weatherItemViewModel2.setTemperature(35);

//        WeatherItemViewModel weatherItemViewModel3 = new WeatherItemViewModel("chennai3", 33,"clud");



        weatherItemViewModelList.add(weatherItemViewModel);
        weatherItemViewModelList.add(weatherItemViewModel1);
        weatherItemViewModelList.add(weatherItemViewModel2);



        weatherListAdapter.setWeatherItemViewModels(weatherItemViewModelList);
    }


    public WeatherListAdapter getAdapter(){
        return weatherListAdapter;
    }


}
