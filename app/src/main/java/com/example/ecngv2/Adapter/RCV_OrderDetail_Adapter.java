package com.example.ecngv2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.ProductCart;
import com.example.ecngv2.R;
import com.example.ecngv2.View.OrderManager.ShippingDetailActivity;
import com.example.ecngv2.View.Shop.ShopActivity;

import java.util.List;

public class RCV_OrderDetail_Adapter extends RecyclerView.Adapter<RCV_OrderDetail_Adapter.ViewHolder> {

    Context context;
    List<ProductCart> list;
    boolean show = false;

    public RCV_OrderDetail_Adapter(Context context, List<ProductCart> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rcv_orderdetail, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductCart item = list.get(position);
        holder.shop.setText(item.getShop());
        holder.shop.setOnClickListener(v -> {
            context.startActivity(new Intent(context, ShopActivity.class));
        });
        holder.rcv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        holder.rcv.setAdapter(new RCV_Payment_Item_Adapter(context, item.getList()));
        holder.btn_show.setOnClickListener(v -> {
            if (!show){
                holder.block_shippingstatus.setVisibility(View.VISIBLE);
                holder.btn_show.setImageResource(R.drawable.ic_hide_primary);
                show = !show;
            } else {
                holder.block_shippingstatus.setVisibility(View.GONE);
                holder.btn_show.setImageResource(R.drawable.ic_more_primary);
                show = !show;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView shop;
        RecyclerView rcv;
        ImageButton btn_show;
        LinearLayout block_shippingstatus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shop = itemView.findViewById(R.id.orderdetail_shop);
            rcv = itemView.findViewById(R.id.rcv_orderdetail_product);
            btn_show = itemView.findViewById(R.id.orderdetail_btnshow_shippingstatus);
            block_shippingstatus = itemView.findViewById(R.id.orderdetail_block_shippingstatus);
        }
    }
}
