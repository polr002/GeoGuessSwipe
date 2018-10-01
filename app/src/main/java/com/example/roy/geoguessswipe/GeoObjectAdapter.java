package com.example.roy.geoguessswipe;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class GeoObjectAdapter extends RecyclerView.Adapter<GeoObjectViewHolder> {

    //Create Constructer
    private Context context;
    public List<GeoObject> listGeoObject;

    public GeoObjectAdapter(Context context, List<GeoObject> listGeoObject) {
        this.context = context;
        this.listGeoObject = listGeoObject;
    }
    //Inflate Layout to display row items in recyclerview
    @Override
    public GeoObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell, parent, false);
            return new GeoObjectViewHolder(view);

    }
    //Bind data to the view holders
    @Override
    public void onBindViewHolder(final GeoObjectViewHolder holder, final int position) {
        final GeoObject geoObject = listGeoObject.get(position);

        holder.geoImage.setImageResource(geoObject.getmGeoName());
        holder.geoMessage.setText(geoObject.getmGeoMessage());
    }

    @Override
    public int getItemCount() {
        return listGeoObject.size();
    }
}

