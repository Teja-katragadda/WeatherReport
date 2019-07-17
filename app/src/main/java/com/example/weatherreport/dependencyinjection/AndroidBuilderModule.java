package com.example.weatherreport.dependencyinjection;

import com.example.weatherreport.WeatherActivity;
import com.example.weatherreport.WeatherViewModel;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AndroidBuilderModule {

    @ContributesAndroidInjector
    abstract WeatherActivity providesWeather();

    @ContributesAndroidInjector
    abstract WeatherViewModel weatherViewModel();


}
