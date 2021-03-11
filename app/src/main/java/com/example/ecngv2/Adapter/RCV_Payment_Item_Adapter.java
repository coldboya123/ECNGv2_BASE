package com.example.ecngv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.ProductCartItem;
import com.example.ecngv2.R;

import java.util.List;

public class RCV_Payment_Item_Adapter extends RecyclerView.Adapter<RCV_Payment_Item_Adapter.ViewHolder> {

    Context context;
    List<ProductCartItem> list;

    public RCV_Payment_Item_Adapter(Context context, List<ProductCartItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rcv_payment_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductCartItem item = list.get(position);
        holder.img.setImageResource(item.getImg());
        holder.name.setText(item.getName());
        holder.property.setText(item.getProperty());
        holder.number.setText("Số lượng: " + item.getNum());
        holder.price.setText(String.format("%,d", item.getPrice())+" đ");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name, price, property, number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.payment_img);
            name = itemView.findViewById(R.id.payment_product_name);
            price = itemView.findViewById(R.id.payment_product_price);
            property = itemView.findViewById(R.id.payment_product_property);
            number = itemView.findViewById(R.id.payment_product_num);
        }
    }
}
