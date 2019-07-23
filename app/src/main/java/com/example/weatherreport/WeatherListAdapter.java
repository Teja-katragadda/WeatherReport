package com.example.weatherreport;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.weatherreport.databinding.ItemWeatherBinding;

import java.util.List;

public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.ViewHolder> {

    private List<WeatherItemViewModel> weatherItemViewModels;

    public WeatherListAdapter(List<WeatherItemViewModel> weatherItemViewModels) {
        this.weatherItemViewModels = weatherItemViewModels;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        ItemWeatherBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_weather, viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        WeatherItemViewModel weatherItemViewModel = weatherItemViewModels.get(i);
        viewHolder.bind(weatherItemViewModel);
    }

    @Override
    public int getItemCount() {
        return weatherItemViewModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemWeatherBinding binding;

        public ViewHolder(ItemWeatherBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(WeatherItemViewModel itemViewModel) {
            binding.setItemViewModel(itemViewModel);
            binding.executePendingBindings();

        }


    }
}
