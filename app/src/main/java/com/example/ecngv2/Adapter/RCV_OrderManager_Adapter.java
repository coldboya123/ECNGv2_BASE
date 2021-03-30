package com.example.ecngv2.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
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

public class RCV_OrderManager_Adapter extends RecyclerView.Adapter<RCV_OrderManager_Adapter.ViewHolder> implements View.OnClickListener {

    Activity activity;
    Context context;
    List<OrderManager> list;
    boolean hide_shipping;
    BottomSheetDialog dialog;
    ImageButton start_1, start_2, start_3, start_4, start_5;
    AppCompatButton btn_sendrating;
    AlertDialog alertDialog;

    public RCV_OrderManager_Adapter(Activity activity, Context context, List<OrderManager> list, boolean hide_shipping) {
        this.activity = activity;
        this.context = context;
        this.list = list;
        this.hide_shipping = hide_shipping;
    }

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
        holder.total.setText(String.format("%,d", order.getTotal()) + " đ");
        holder.rcv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        holder.rcv.setAdapter(new RCV_Delivering_Item_Adapter(context, order.getList(), hide_shipping));
        holder.btn_detail.setOnClickListener(view -> {
            context.startActivity(new Intent(context, OrderDetailActivity.class));
//            activity.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        });
        if (order.isRatting()) {
            holder.btn_rating.setVisibility(View.GONE);

        }
        holder.btn_rating.setOnClickListener(view -> {
            dialog = new BottomSheetDialog(context);
            dialog.setContentView(R.layout.custom_rating_dialog);
            dialog.show();
            start_1 = dialog.findViewById(R.id.rating_1start);
            start_2 = dialog.findViewById(R.id.rating_2start);
            start_3 = dialog.findViewById(R.id.rating_3start);
            start_4 = dialog.findViewById(R.id.rating_4start);
            start_5 = dialog.findViewById(R.id.rating_5start);
            btn_sendrating = dialog.findViewById(R.id.btn_sendrating);
            start_1.setOnClickListener(this);
            start_2.setOnClickListener(this);
            start_3.setOnClickListener(this);
            start_4.setOnClickListener(this);
            start_5.setOnClickListener(this);
            btn_sendrating.setOnClickListener(view1 -> {
                dialog.hide();
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
                View layoutView = LayoutInflater.from(context).inflate(R.layout.dialog_sendrating_dialog, null);
                dialogBuilder.setView(layoutView);
                alertDialog = dialogBuilder.create();
                Window window = alertDialog.getWindow();
                window.getAttributes().windowAnimations = R.style.DialogAnimation;
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                WindowManager.LayoutParams wlp = window.getAttributes();
                wlp.gravity = Gravity.TOP | Gravity.CENTER;
                wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
                window.setAttributes(wlp);
                alertDialog.show();
                order.setRatting(true);
                notifyDataSetChanged();
            });
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @SuppressLint({"NonConstantResourceId", "UseCompatLoadingForDrawables"})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rating_1start:
                start_1.setImageResource(R.drawable.ratingbar_staron_large);
                start_2.setImageResource(R.drawable.ratingbar_staroff_large);
                start_3.setImageResource(R.drawable.ratingbar_staroff_large);
                start_4.setImageResource(R.drawable.ratingbar_staroff_large);
                start_5.setImageResource(R.drawable.ratingbar_staroff_large);
                break;
            case R.id.rating_2start:
                start_1.setImageResource(R.drawable.ratingbar_staron_large);
                start_2.setImageResource(R.drawable.ratingbar_staron_large);
                start_3.setImageResource(R.drawable.ratingbar_staroff_large);
                start_4.setImageResource(R.drawable.ratingbar_staroff_large);
                start_5.setImageResource(R.drawable.ratingbar_staroff_large);
                break;
            case R.id.rating_3start:
                start_1.setImageResource(R.drawable.ratingbar_staron_large);
                start_2.setImageResource(R.drawable.ratingbar_staron_large);
                start_3.setImageResource(R.drawable.ratingbar_staron_large);
                start_4.setImageResource(R.drawable.ratingbar_staroff_large);
                start_5.setImageResource(R.drawable.ratingbar_staroff_large);
                break;
            case R.id.rating_4start:
                start_1.setImageResource(R.drawable.ratingbar_staron_large);
                start_2.setImageResource(R.drawable.ratingbar_staron_large);
                start_3.setImageResource(R.drawable.ratingbar_staron_large);
                start_4.setImageResource(R.drawable.ratingbar_staron_large);
                start_5.setImageResource(R.drawable.ratingbar_staroff_large);
                break;
            case R.id.rating_5start:
                start_1.setImageResource(R.drawable.ratingbar_staron_large);
                start_2.setImageResource(R.drawable.ratingbar_staron_large);
                start_3.setImageResource(R.drawable.ratingbar_staron_large);
                start_4.setImageResource(R.drawable.ratingbar_staron_large);
                start_5.setImageResource(R.drawable.ratingbar_staron_large);
                break;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, time, total;
        RecyclerView rcv;
        AppCompatButton btn_detail, btn_rating, btn_rebuy;
        View line_rating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.ordermanager_orderid);
            time = itemView.findViewById(R.id.ordermanager_ordertime);
            total = itemView.findViewById(R.id.ordermanager_total);
            rcv = itemView.findViewById(R.id.rcv_ordermanager_item);
            btn_detail = itemView.findViewById(R.id.ordermanager_btn_detail);
            btn_rating = itemView.findViewById(R.id.ordermanager_ratenow);
            line_rating = itemView.findViewById(R.id.line_rating);
            btn_rebuy = itemView.findViewById(R.id.ordermanager_rebuy);
        }
    }
}
