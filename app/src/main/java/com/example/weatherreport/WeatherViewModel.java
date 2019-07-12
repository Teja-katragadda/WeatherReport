package com.example.weatherreport;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.util.Log;

import com.example.weatherreport.ServiceLayer.GetServiceData;
import com.example.weatherreport.ServiceLayer.RetrofitClientInstance;
import com.example.weatherreport.databinding.ItemWeatherBinding;
import com.example.weatherreport.models.WeatherInfo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel implements LifecycleObserver {


    private static final String TAG = "WeatherViewModel";

    private ArrayList<String> mcity = new ArrayList<>();
    public ObservableField<String> cityName = new ObservableField<>();
    public ObservableField<String> temperature = new ObservableField<>();
    public ObservableField<String> description = new ObservableField<>();
    public List<WeatherItemViewModel> weatherItemViewModelList = new ArrayList<>();
    public WeatherListAdapter weatherListAdapter;


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void getWeatherData(){

        weatherListAdapter = new WeatherListAdapter(weatherItemViewModelList);
        createCityList();
        getWeatherInfo();

    }


    public void createCityList(){

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



    }


    public WeatherListAdapter getAdapter(){
        return weatherListAdapter;
    }



    public void getWeatherInfo() {

        for (final String mCityName : mcity) {

            GetServiceData getServiceData = RetrofitClientInstance.getRetrofitInstance().create(GetServiceData.class);
            Call<WeatherInfo> call = getServiceData.getInfo(mCityName);
            call.enqueue(new Callback<WeatherInfo>() {
                @Override
                public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {

                    WeatherInfo weatherInfo = response.body();

                    if(weatherInfo != null){

                        cityName.set(weatherInfo.getName());
                        temperature.set(weatherInfo.getMain().getTemp().toString());
                        description.set(weatherInfo.getWeather().get(0).getDescription());

                        WeatherItemViewModel weatherItemViewModel = new WeatherItemViewModel();

                        weatherItemViewModel.setTemperature(temperature.get());
                        weatherItemViewModel.setCityName(cityName.get());
                        weatherItemViewModel.setDescription(description.get());

                        weatherItemViewModelList.add(weatherItemViewModel);

                        weatherListAdapter.notifyDataSetChanged();
                    }


                }

                @Override
                public void onFailure(Call<WeatherInfo> call, Throwable t) {

                    Log.e(TAG, "onFailure: "+t.getLocalizedMessage() );
                }
            });


        }

    }

}
