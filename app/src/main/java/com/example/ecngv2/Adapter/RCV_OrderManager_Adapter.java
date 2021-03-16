package com.example.ecngv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.OrderManager;
import com.example.ecngv2.R;

import java.util.List;

public class RCV_OrderManager_Adapter extends RecyclerView.Adapter<RCV_OrderManager_Adapter.ViewHolder> {

    Context context;
    List<OrderManager> list;
    boolean hide_shipping;

    public RCV_OrderManager_Adapter(Context context, List<OrderManager> list, boolean hide_shipping) {
        this.context = context;
        this.list = list;
        this.hide_shipping = hide_shipping;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rcv_ordermanager, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderManager order = list.get(position);
        holder.id.setText(order.getId());
        holder.time.setText(order.getTime());
        holder.total.setText(String.format("%,d", order.getTotal())+" đ");
        holder.rcv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        holder.rcv.setAdapter(new RCV_Delivering_Item_Adapter(context, order.getList(), hide_shipping));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, time, total;
        RecyclerView rcv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.ordermanager_orderid);
            time = itemView.findViewById(R.id.ordermanager_ordertime);
            total = itemView.findViewById(R.id.ordermanager_total);
            rcv = itemView.findViewById(R.id.rcv_ordermanager_item);
        }
    }
}