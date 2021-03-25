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

import com.example.ecngv2.Model.Object.CategoryList;
import com.example.ecngv2.R;

import java.util.List;

public class RCV_Category_Adapter extends RecyclerView.Adapter<RCV_Category_Adapter.ViewHolder> {

    Context context;
    List<CategoryList> lists;

    public RCV_Category_Adapter(Context context, List<CategoryList> lists) {
        this.context = context;
        this.lists = lists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.rcv_category_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoryList item = lists.get(position);
        holder.title.setText(item.getTitle());
        if (item.isHide()){
            holder.rcv.setVisibility(View.GONE);
            holder.title.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_drop_down, 0);
        } else {
            holder.rcv.setVisibility(View.VISIBLE);
            holder.title.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_drop_up, 0);
        }
        holder.rcv.setLayoutManager(new GridLayoutManager(context, 3, RecyclerView.VERTICAL, false));
        holder.rcv.setAdapter(new RCV_CategoryItem_Adapter(context, item.getList()));
        holder.title.setOnClickListener(v -> {
            item.setHide(!item.isHide());
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        RecyclerView rcv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            rcv = itemView.findViewById(R.id.rcv);
        }
    }
}
