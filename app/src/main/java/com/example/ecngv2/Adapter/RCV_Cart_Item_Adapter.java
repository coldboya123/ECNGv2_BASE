package com.example.ecngv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Adapter.Handle.HandleRCVCartItemAdapter;
import com.example.ecngv2.Model.Object.ProductCartItem;
import com.example.ecngv2.R;
import com.google.android.material.checkbox.MaterialCheckBox;

import java.util.List;

public class RCV_Cart_Item_Adapter extends RecyclerView.Adapter<RCV_Cart_Item_Adapter.ViewHolder> {

    Context context;
    List<ProductCartItem> list;
    HandleRCVCartItemAdapter handle;

    public RCV_Cart_Item_Adapter(Context context, List<ProductCartItem> list, HandleRCVCartItemAdapter handle) {
        this.context = context;
        this.list = list;
        this.handle = handle;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rcv_cart_item, parent, false);
        return new RCV_Cart_Item_Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductCartItem cart = list.get(position);
        holder.check.setChecked(cart.isCheck());
        holder.img.setImageResource(cart.getImg());
        holder.name.setText(cart.getName());
        holder.price.setText(String.format("%,d", cart.getPrice())+" đ");
        holder.property.setText("Phân loại: "+ cart.getProperty());
        holder.number.setText(cart.getNum()+"");
        holder.check.setOnCheckedChangeListener((compoundButton, b) -> {
            cart.setCheck(!cart.isCheck());
            handle.updateTotalPrice();
        });
        holder.btn_del.setOnClickListener(view ->{
            list.remove(position);
            notifyDataSetChanged();
            handle.updateTotalPrice();
            if (list.size() == 0){
                handle.removeItem();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name, price, property, number;
        ImageButton btn_del;
        MaterialCheckBox check;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.cart_img);
            name = itemView.findViewById(R.id.cart_product_name);
            price = itemView.findViewById(R.id.cart_price);
            btn_del = itemView.findViewById(R.id.cart_btn_del);
            property = itemView.findViewById(R.id.cart_product_property);
            number = itemView.findViewById(R.id.cart_product_number);
            check = itemView.findViewById(R.id.cart_item_check);
        }
    }
}
