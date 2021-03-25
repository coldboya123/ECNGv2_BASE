package com.example.ecngv2.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.OrderManager;
import com.example.ecngv2.R;
import com.example.ecngv2.View.OrderManager.OrderDetail.OrderDetailActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class RCV_OrderManager_Adapter extends RecyclerView.Adapter<RCV_OrderManager_Adapter.ViewHolder> {

    Activity activity;
    Context context;
    List<OrderManager> list;
    boolean hide_shipping;
    BottomSheetDialog dialog;

    public RCV_OrderManager_Adapter(Activity activity, Context context, List<OrderManager> list, boolean hide_shipping) {
        this.activity = activity;
        this.context = context;
        this.list = list;
        this.hide_shipping = hide_shipping;
    }
//    public RCV_OrderManager_Adapter(Context context, List<OrderManager> list, boolean hide_shipping) {
//        this.context = context;
//        this.list = list;
//        this.hide_shipping = hide_shipping;
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rcv_ordermanager, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderManager order = list.get(position);
        holder.id.setText(order.getId());
        holder.time.setText(order.getTime());
        holder.total.setText(String.format("%,d", order.getTotal())+" đ");
        holder.rcv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        holder.rcv.setAdapter(new RCV_Delivering_Item_Adapter(context, order.getList(), hide_shipping));
        holder.btn_detail.setOnClickListener(view -> {
            context.startActivity(new Intent(context, OrderDetailActivity.class));
//            activity.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        });
        dialog = new BottomSheetDialog(context);
        dialog.setContentView(R.layout.dialog_choose_type);
        holder.btn_rating.setOnClickListener(view -> {
            dialog = new BottomSheetDialog(context);

        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, time, total;
        RecyclerView rcv;
        AppCompatButton btn_detail, btn_rating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.ordermanager_orderid);
            time = itemView.findViewById(R.id.ordermanager_ordertime);
            total = itemView.findViewById(R.id.ordermanager_total);
            rcv = itemView.findViewById(R.id.rcv_ordermanager_item);
            btn_detail = itemView.findViewById(R.id.ordermanager_btn_detail);
            btn_rating = itemView.findViewById(R.id.ordermanager_ratenow);
        }
    }
}
