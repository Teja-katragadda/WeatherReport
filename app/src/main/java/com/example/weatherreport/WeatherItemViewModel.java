package com.example.weatherreport;

public class WeatherItemViewModel {
    private String cityName;
    private Integer temperature;
    private String description;

    public WeatherItemViewModel() {
    }

    public WeatherItemViewModel(String cityName, Integer temperature, String description) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.description = description;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTemperature() {
        return temperature.toString();
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
