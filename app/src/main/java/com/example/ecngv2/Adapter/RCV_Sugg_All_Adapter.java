package com.example.ecngv2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.Product;
import com.example.ecngv2.View.Product.ProductActivity;
import com.example.ecngv2.R;

import java.util.List;

public class RCV_Sugg_All_Adapter extends RecyclerView.Adapter<RCV_Sugg_All_Adapter.ViewHolder> {
    Context context;
    List<Product> list;

    public RCV_Sugg_All_Adapter(Context context, List<Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_product, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = list.get(position);
        holder.img.setImageResource(product.getImg());
        holder.name.setText(product.getName());
        holder.price.setText(String.format("%,d", product.getPrice())+" đ");
        holder.numrating.setText("("+product.getNumrating()+")");
        holder.ratingBar.setRating(product.getRating());
        holder.cardView.setOnClickListener(view -> context.startActivity(new Intent(context, ProductActivity.class)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name, numrating, price;
        RatingBar ratingBar;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_product);
            name = itemView.findViewById(R.id.name_product);
            numrating = itemView.findViewById(R.id.numrating_product);
            price = itemView.findViewById(R.id.price_product);
            ratingBar = itemView.findViewById(R.id.rating_product);
            cardView = itemView.findViewById(R.id.product_background);
        }
    }
}
