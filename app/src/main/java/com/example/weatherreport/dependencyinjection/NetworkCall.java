package com.example.weatherreport.dependencyinjection;


import dagger.Module;
import dagger.Provides;

@Module
public class NetworkCall {

    @Provides
    static String giveString(){
        return "subrat";
    }


}
