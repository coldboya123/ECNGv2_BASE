package com.example.ecngv2.Adapter;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.NotiSecure;
import com.example.ecngv2.R;

import java.util.List;

public class RCV_Noti_Secure_Adapter extends RecyclerView.Adapter<RCV_Noti_Secure_Adapter.ViewHolder> {

    Context context;
    List<NotiSecure> list;

    public RCV_Noti_Secure_Adapter(Context context, List<NotiSecure> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rcv_noti_secure, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NotiSecure secure = list.get(position);
        if (!secure.isStatus()){
            holder.txtStatus.setVisibility(View.GONE);
            holder.txtDate.setTypeface(holder.txtDate.getTypeface(), Typeface.BOLD);
            holder.txtContent.setTypeface(holder.txtContent.getTypeface(), Typeface.BOLD);
        } else {
            holder.txtStatus.setVisibility(View.VISIBLE);
            holder.txtDate.setTypeface(null, Typeface.NORMAL);
            holder.txtContent.setTypeface(null, Typeface.NORMAL);
        }
        holder.txtDate.setText(secure.getDate());
        holder.txtContent.setText(secure.getContent());
        holder.detail.setPaintFlags(holder.detail.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        holder.block.setOnClickListener(view -> {
            secure.setStatus(true);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtDate, txtStatus, txtContent, detail;
        ConstraintLayout block;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDate = itemView.findViewById(R.id.noti_secure_date);
            txtStatus = itemView.findViewById(R.id.noti_secure_status);
            txtContent = itemView.findViewById(R.id.noti_secure_content);
            detail = itemView.findViewById(R.id.noti_secure_detail);
            block = itemView.findViewById(R.id.noti_secure_block);
        }
    }
}
