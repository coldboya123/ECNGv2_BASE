package com.example.ecngv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.Ward;
import com.example.ecngv2.R;
import com.example.ecngv2.View.Address.IAddUserAddress;

import java.util.ArrayList;
import java.util.List;

public class RCV_AddressChooseWard_Adapter extends RecyclerView.Adapter<RCV_AddressChooseWard_Adapter.ViewHolder> {

    Context context;
    List<Ward> list;
    IAddUserAddress iAddUserAddress;

    public RCV_AddressChooseWard_Adapter(Context context, List<Ward> list, IAddUserAddress iAddUserAddress) {
        this.context = context;
        this.list = list;
        this.iAddUserAddress = iAddUserAddress;
    }

    @NonNull
    @Override
    public RCV_AddressChooseWard_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rcv_chooseaddress, parent, false);
        return new RCV_AddressChooseWard_Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RCV_AddressChooseWard_Adapter.ViewHolder holder, int position) {
        holder.txt.setText(list.get(position).getName());
        holder.txt.setOnClickListener(v -> iAddUserAddress.OnSelectedWard(list.get(position)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setFilter(List<Ward> newList) {
        list = new ArrayList<>();
        list.addAll(newList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.txt);
        }
    }
}
