package com.example.ecngv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.R;

import java.util.List;

public class RCV_CateDetail_TradeMark_Adapter extends RecyclerView.Adapter<RCV_CateDetail_TradeMark_Adapter.ViewHolder> {

    Context context;
    List<Integer> list;
    boolean check_selected = false;

    public RCV_CateDetail_TradeMark_Adapter(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rcv_trademark, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img.setImageResource(list.get(position));
        holder.img.setOnClickListener(view -> {
            if (check_selected){
                holder.img.setBackground(context.getDrawable(R.drawable.border_primary_color));
            }
            else {
                holder.img.setBackgroundResource(0);
            }
            check_selected = !check_selected;
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.trademark_img);
        }
    }
}
