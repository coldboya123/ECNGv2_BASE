package com.example.ecngv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.ItemCateTab;
import com.example.ecngv2.R;

import java.util.List;

public class Cate_Computer_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<ItemCateTab> listItem;

    public Cate_Computer_Adapter(Context context, List<ItemCateTab> listItem) {
        this.context = context;
        this.listItem = listItem;
    }

    final int COMMON = 0;
    final int LAPTOP = 1;
    final int COMPUTER = 2;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        switch (viewType) {
            case COMMON:
            case LAPTOP:
            case COMPUTER:
                v = LayoutInflater.from(context).inflate(R.layout.cate_tabcontent_item, parent, false);
                return new ItemHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RCV_Home_Category_Adapter adapter;
        if (position == 0){
            ((ItemHolder) holder).title.setText(listItem.get(0).getTitle());
            ((ItemHolder) holder).all.setVisibility(View.INVISIBLE);
            adapter = new RCV_Home_Category_Adapter(context, listItem.get(0).getList());
            ((ItemHolder) holder).rcv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            ((ItemHolder) holder).rcv.setAdapter(adapter);
        }else {
            for (int i=1; i<listItem.size(); i++){
                if (position == i){
                    ((ItemHolder) holder).title.setText(listItem.get(i).getTitle());
                    adapter = new RCV_Home_Category_Adapter(context, listItem.get(i).getList());
                    ((ItemHolder) holder).rcv.setLayoutManager(new GridLayoutManager(context, 3));
                    ((ItemHolder) holder).rcv.setAdapter(adapter);
                }
            }
        }

    }


    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return COMMON;
            case 1:
                return LAPTOP;
            case 2:
                return COMPUTER;
        }
        return -1;
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        TextView title, all;
        RecyclerView rcv;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.cate_item_title);
            all = itemView.findViewById(R.id.cate_item_all);
            rcv = itemView.findViewById(R.id.rcv_catecontent_item);
        }
    }
}
