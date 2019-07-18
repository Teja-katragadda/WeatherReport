package com.example.weatherreport.dependencyinjection;

import com.example.weatherreport.network.NetworkCall;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules={NetworkCall.class,AndroidBuilderModule.class,AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<WeatherApplication> {




}
