package com.example.ecngv2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.Category;
import com.example.ecngv2.R;
import com.example.ecngv2.View.CateDetail.CateDetailActivity;

import java.util.List;

public class RCV_CateDetail_Cate_Adapter extends RecyclerView.Adapter<RCV_CateDetail_Cate_Adapter.Holder> {

    Context context;
    List<Category> list;
    boolean check_selected = false;

    public RCV_CateDetail_Cate_Adapter(Context context, List<Category> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(com.example.ecngv2.R.layout.custom_rcv_category, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RCV_CateDetail_Cate_Adapter.Holder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getSrc());
        holder.textView.setText(list.get(position).getTitle());
        holder.cate_block.setOnClickListener(view -> {
//            Intent intent = new Intent(context, CateDetailActivity.class);
//            intent.putExtra("position", position);
//            context.startActivity(intent);
            if (check_selected){
                holder.cate_block.setBackground(context.getDrawable(R.drawable.border_primary_color));
                check_selected = !check_selected;
            } else {
                holder.cate_block.setBackgroundResource(0);
                check_selected = !check_selected;
            }
        })  ;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        LinearLayout cate_block;
        ImageView imageView;
        TextView textView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cate_img);
            textView = itemView.findViewById(R.id.cate_title);
            cate_block = itemView.findViewById(R.id.cate_block);
        }
    }
}
