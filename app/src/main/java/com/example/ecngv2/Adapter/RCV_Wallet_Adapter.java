package com.example.ecngv2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.Cash;
import com.example.ecngv2.Model.Object.OrderManager;
import com.example.ecngv2.R;

import java.util.List;

public class RCV_Wallet_Adapter extends RecyclerView.Adapter<RCV_Wallet_Adapter.ViewHolder> {

    Context context;
    List<Cash> list;

    public RCV_Wallet_Adapter(Context context, List<Cash> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rcv_wallet, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cash cash = list.get(position);
        holder.id.setText("#"+ cash.getId());
        holder.money.setText(String.format("%,d", cash.getMoney())+" đ");
        if(cash.getMoney()>0){
            holder.money.setTextColor(context.getColor(R.color.green));
        }else holder.money.setTextColor(context.getColor(R.color.red));
        holder.date.setText(cash.getDate());
        holder.btn_vieworder.setOnClickListener(v -> context.startActivity(new Intent(context, OrderManager.class)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, money, date;
        AppCompatButton btn_vieworder;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            money = itemView.findViewById(R.id.money);
            date = itemView.findViewById(R.id.date);
            btn_vieworder = itemView.findViewById(R.id.btn_vieworder);
        }
    }
}
