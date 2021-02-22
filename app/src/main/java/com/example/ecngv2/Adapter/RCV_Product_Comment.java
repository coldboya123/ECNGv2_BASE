package com.example.ecngv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.Comment;
import com.example.ecngv2.R;

import java.util.List;

public class RCV_Product_Comment extends RecyclerView.Adapter<RCV_Product_Comment.Holder> {

    Context context;
    List<Comment> list;

    public RCV_Product_Comment(Context context, List<Comment> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RCV_Product_Comment.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rcv_product_cmt, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RCV_Product_Comment.Holder holder, int position) {
        Comment comment = list.get(position);
        holder.avatar.setImageResource(comment.getAvatar());
        holder.img1.setImageResource(comment.getImg1());
        holder.img2.setImageResource(comment.getImg2());
        holder.rating.setRating(comment.getRating());
        holder.name.setText(comment.getName());
        holder.cmt.setText(comment.getCmt());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        ImageView avatar, img1, img2;
        RatingBar rating;
        TextView name, cmt;
        public Holder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.product_cmt_cus_img);
            img1 = itemView.findViewById(R.id.product_cmt_img1);
            img2 = itemView.findViewById(R.id.product_cmt_img2);
            rating = itemView.findViewById(R.id.product_cmt_rating);
            name = itemView.findViewById(R.id.product_cmt_cus_name);
            cmt = itemView.findViewById(R.id.product_cmt_content);
        }
    }
}
