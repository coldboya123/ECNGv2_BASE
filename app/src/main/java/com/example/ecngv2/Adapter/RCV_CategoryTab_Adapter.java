package com.example.ecngv2.Adapter;

import android.content.Context;
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

import java.util.List;

public class RCV_CategoryTab_Adapter extends RecyclerView.Adapter<RCV_CategoryTab_Adapter.Holder> {

    Context context;
    List<Category> list;
    int selectedPosition = 0;

    public RCV_CategoryTab_Adapter(Context context, List<Category> list) {
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
    public void onBindViewHolder(@NonNull RCV_CategoryTab_Adapter.Holder holder, int position) {
        Category category = list.get(position);
        holder.imageView.setImageResource(category.getSrc());
        holder.textView.setText(category.getTitle());
        if (selectedPosition == position) {
            holder.cate_block.setBackground(context.getDrawable(R.drawable.border_primary_color));
        } else {
            holder.cate_block.setBackground(null);
        }

        holder.cate_block.setOnClickListener(v -> {
            if (selectedPosition >= 0)
                notifyItemChanged(selectedPosition);
            selectedPosition = holder.getAdapterPosition();
            notifyItemChanged(selectedPosition);
        });
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
