package com.example.ecngv2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.R;
import com.example.ecngv2.ShopActivity;

import java.util.List;

public class RCV_vendor_adapter extends RecyclerView.Adapter<RCV_vendor_adapter.ViewHolder> {
    Context context;
    List<Integer> list;

    public RCV_vendor_adapter(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RCV_vendor_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rcv_vendor, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RCV_vendor_adapter.ViewHolder holder, int position) {
        holder.img.setImageResource(list.get(position));
        holder.img.setOnClickListener(view -> context.startActivity(new Intent(context, ShopActivity.class)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_vendor);
        }
    }
}
