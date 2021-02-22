package com.example.ecngv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.Cart;
import com.example.ecngv2.R;

import java.util.List;

public class RCV_Cart_Adapter extends RecyclerView.Adapter<RCV_Cart_Adapter.Holder> {

    Context context;
    List<Cart> list;

    public RCV_Cart_Adapter(Context context, List<Cart> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rcv_cart, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Cart cart = list.get(position);
        holder.img.setImageResource(cart.getImg());
        holder.shop.setText(cart.getShop());
        holder.product.setText(cart.getProduct());
        holder.price.setText(cart.getPrice());
        holder.btn_del.setOnClickListener(view ->{
//            holder.item.setVisibility(View.GONE);
            list.remove(position);
            notifyDataSetChanged();
            //ád
            int asd;
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView shop, product, price;
        ImageButton btn_del;
        CardView item;
        public Holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.cart_img);
            shop = itemView.findViewById(R.id.cart_shop_name);
            product = itemView.findViewById(R.id.cart_product_name);
            price = itemView.findViewById(R.id.cart_price);
            btn_del = itemView.findViewById(R.id.cart_btn_del);
            item = itemView.findViewById(R.id.cart_item);
        }
    }
}
