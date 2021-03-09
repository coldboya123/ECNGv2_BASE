package com.example.ecngv2.Adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.NotiOrder;
import com.example.ecngv2.R;

import java.util.List;

public class RCV_Noti_Order_Adapter extends RecyclerView.Adapter<RCV_Noti_Order_Adapter.ViewHolder> {

    Context context;
    List<NotiOrder> list;

    public RCV_Noti_Order_Adapter(Context context, List<NotiOrder> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rcv_noti_order, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NotiOrder order = list.get(position);
        holder.txtName.setText(order.getName());
        holder.img.setImageResource(order.getImg());
        holder.detail.setPaintFlags(holder.detail.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        switch (order.getStatus()){
            case "Đang giao":
                holder.txtStatus.setText(order.getStatus());
                holder.txtStatus.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_danggiao, 0);
                break;
            case "Đã giao":
                holder.txtStatus.setText(order.getStatus());
                holder.txtStatus.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_dagiao, 0);
                break;
            case "Đã hủy":
                holder.txtStatus.setText(order.getStatus());
                holder.txtStatus.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_dahuy, 0);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView txtName, txtStatus, detail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.noti_order_img);
            txtName = itemView.findViewById(R.id.noti_order_name);
            txtStatus = itemView.findViewById(R.id.noti_order_status);
            detail = itemView.findViewById(R.id.noti_order_detail);
        }
    }
}
