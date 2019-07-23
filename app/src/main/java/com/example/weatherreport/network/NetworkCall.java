package com.example.weatherreport.network;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkCall {

    public static final String BASIC_URL = "https://community-open-weather-map.p.rapidapi.com";


    @Provides
    WeatherServiceData providesRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASIC_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(WeatherServiceData.class);
    }

}
