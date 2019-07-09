package com.example.weatherreport;

class WeatherResponse {
   private String place;
   private String humidity_degree;
   private String temperature_degree;
   private String temperature;
   private String humidity;

    public WeatherResponse(String place, String humidity_degree, String temperature_degree, String temperature, String humidity) {
        this.place = place;
        this.humidity_degree = humidity_degree;
        this.temperature_degree = temperature_degree;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public WeatherResponse() {

    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setHumidity_degree(String humidity_degree) {
        this.humidity_degree = humidity_degree;
    }

    public void setTemperature_degree(String temperature_degree) {
        this.temperature_degree = temperature_degree;
    }

    public String getPlace() {
        return place;
    }

    public String getHumidity_degree() {
        return humidity_degree;
    }

    public String getTemperature_degree() {
        return temperature_degree;
    }
}
