package com.example.camilomtz.Tenistas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.camilomtz.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterTenistas extends RecyclerView.Adapter<AdapterTenistas.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<ModelTenistas> dataModelArrayList;

    public  AdapterTenistas(Context ctx, ArrayList<ModelTenistas> dataModelArrayList){
        inflater = LayoutInflater.from(ctx);
        this.dataModelArrayList = dataModelArrayList;
    }

    @NonNull
    @Override
    public AdapterTenistas.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.view_tenistas, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(AdapterTenistas.MyViewHolder holder, int position) {
        Picasso.get().load(dataModelArrayList.get(position).getImgURL()).into(holder.iv);
        holder.name.setText(dataModelArrayList.get(position).getName());
        holder.country.setText(dataModelArrayList.get(position).getCountry());
        holder.city.setText(dataModelArrayList.get(position).getCity());
    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView country, name, city;
        ImageView iv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            country = (TextView) itemView.findViewById(R.id.country);
            name = (TextView) itemView.findViewById(R.id.name);
            city = (TextView) itemView.findViewById(R.id.city);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }
}
