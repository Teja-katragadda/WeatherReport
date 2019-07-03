package com.example.weatherreport;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import com.example.weatherreport.Models.WeatherInfo;

public class AdapterClass extends FragmentPagerAdapter {
    FragmentManager manager;
    WeatherInfo weatherInfo;


    public AdapterClass(FragmentManager fragmentManager) {
        super(fragmentManager);
    }


    @Override
    public Fragment getItem(int i) {
        Fragment fragment ;
        if (i == 0) {
            fragment = new FragmentFirstScreen();


        } else  {
            fragment = new SecondFragment();
        }

        return fragment;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
