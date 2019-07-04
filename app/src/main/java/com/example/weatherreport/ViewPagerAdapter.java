package com.example.weatherreport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.weatherreport.Models.WeatherInfo;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    private Context context;
    private List<WeatherInfo> weatherList;


    public ViewPagerAdapter(Context context, List<WeatherInfo> weatherList) {
        this.context = context;
        this.weatherList = weatherList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_fragment_first_screen, container, false);
        TextView place = view.findViewById(R.id.place);
        TextView humidity = view.findViewById(R.id.humidity_degree);
        TextView temperature = view.findViewById(R.id.temperature_degree);
        place.setText(weatherList.get(position).getName());
        humidity.setText(String.valueOf(weatherList.get(position).getMain().getHumidity()));
        temperature.setText(String.valueOf(weatherList.get(position).getMain().getTempMax()));
        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return weatherList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return  view == o;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }
}
