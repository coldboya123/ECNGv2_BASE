package com.example.ecngv2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.Shop;
import com.example.ecngv2.R;
import com.example.ecngv2.View.Shop.ShopActivity;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class RCV_FavShop_Adapter extends RecyclerView.Adapter<RCV_FavShop_Adapter.ViewHolder> {

    Context context;
    List<Shop> list;

    public RCV_FavShop_Adapter(Context context, List<Shop> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rcv_favshop, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Shop shop = list.get(position);
        holder.img.setImageResource(shop.getImg());
        holder.name.setText(shop.getName());
        holder.block.setOnClickListener(v -> context.startActivity(new Intent(context, ShopActivity.class)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView img;
        TextView name;
        ConstraintLayout block;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            block = itemView.findViewById(R.id.block);
        }
    }
}
