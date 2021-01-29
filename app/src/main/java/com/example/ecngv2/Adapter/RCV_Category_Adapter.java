package com.example.ecngv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Category;
import com.example.ecngv2.R;
import java.util.List;

import static android.os.Build.VERSION_CODES.R;

public class RCV_Category_Adapter extends RecyclerView.Adapter<RCV_Category_Adapter.Holder> {

    Context context;
    List<Category> list;

    public RCV_Category_Adapter(Context context, List<Category> list) {
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
    public void onBindViewHolder(@NonNull RCV_Category_Adapter.Holder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getSrc());
        holder.textView.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(com.example.ecngv2.R.id.cate_img);
            textView = itemView.findViewById(com.example.ecngv2.R.id.cate_title);
        }
    }
}
