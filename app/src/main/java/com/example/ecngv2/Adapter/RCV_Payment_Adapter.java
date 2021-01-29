package com.example.ecngv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.PaymentProduct;
import com.example.ecngv2.R;

import java.util.List;

import javax.xml.namespace.QName;

public class RCV_Payment_Adapter extends RecyclerView.Adapter<RCV_Payment_Adapter.Holder> {

    Context context;
    List<PaymentProduct> list;

    public RCV_Payment_Adapter(Context context, List<PaymentProduct> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rcv_payment, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        PaymentProduct  product = list.get(position);
        holder.img.setImageResource(product.getImg());
        holder.name.setText(product.getName());
        holder.num.setText("Số lượng: "+ product.getNum());
        holder.price.setText(product.getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name, num, price;
        public Holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.payment_product_img);
            name = itemView.findViewById(R.id.payment_product_name);
            num = itemView.findViewById(R.id.payment_product_num);
            price = itemView.findViewById(R.id.payment_product_price);
        }
    }
}
