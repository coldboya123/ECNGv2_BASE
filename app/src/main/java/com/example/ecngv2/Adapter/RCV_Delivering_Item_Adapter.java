package com.example.ecngv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.OrderItem;
import com.example.ecngv2.R;

import java.util.List;

public class RCV_Delivering_Item_Adapter extends RecyclerView.Adapter<RCV_Delivering_Item_Adapter.ViewHolder> {

    Context context;
    List<OrderItem> list;
    boolean hide_shipping;

    public RCV_Delivering_Item_Adapter(Context context, List<OrderItem> list, boolean hide_shipping) {
        this.context = context;
        this.list = list;
        this.hide_shipping = hide_shipping;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rcv_delivering_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderItem item = list.get(position);
        holder.shop.setText(item.getShop());
        if (!hide_shipping){
            holder.shipping.setText(item.getShipping());
        } else holder.shipping.setVisibility(View.GONE);
        holder.rcv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        holder.rcv.setAdapter(new RCV_Payment_Item_Adapter(context, item.getList()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView shop, shipping;
        RecyclerView rcv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shop = itemView.findViewById(R.id.ordermanager_shop);
            shipping = itemView.findViewById(R.id.ordermanager_shipping);
            rcv = itemView.findViewById(R.id.rcv_ordermanager_product);
        }
    }
}
