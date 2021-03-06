package com.example.ecngv2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Object.UserAddress;
import com.example.ecngv2.R;
import com.example.ecngv2.View.User.SettingAccount.Address.EditUserAddressActivity;

import java.io.Serializable;
import java.util.List;

public class RCV_UserAddress_Adapter extends RecyclerView.Adapter<RCV_UserAddress_Adapter.ViewHolder> {

    Context context;
    List<UserAddress> list;
    ListPopupWindow listPopupWindow;
    Intent intent;
    int pos_default;

    public RCV_UserAddress_Adapter(Context context, List<UserAddress> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rcv_user_address, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserAddress userAddress = list.get(position);
        holder.txtName.setText(userAddress.getName());
        holder.txtPhone.setText(userAddress.getPhone());
        holder.txtAddress.setText(userAddress.getAddress());

        if (userAddress.is_default()) {
            pos_default = position;
            holder.txtDefault.setVisibility(View.VISIBLE);
            holder.btnMore.setOnClickListener(view -> {
                listPopupWindow = new ListPopupWindow(context);
                listPopupWindow.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, new String[]{"Chỉnh sửa"}));
                listPopupWindow.setAnchorView(holder.btnMore);
                listPopupWindow.setWidth(300);
                listPopupWindow.setModal(true);
                listPopupWindow.setOnItemClickListener((adapterView, view1, i, l) -> {
                    intent = new Intent(context, EditUserAddressActivity.class);
                    putIntent(intent, userAddress);
                    context.startActivity(intent);
                    listPopupWindow.dismiss();
                });
                listPopupWindow.show();
            });
        } else {
            holder.txtDefault.setVisibility(View.GONE);
            holder.btnMore.setOnClickListener(view -> {
                listPopupWindow = new ListPopupWindow(context);
                listPopupWindow.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, new String[]{"Đặt mặc định", "Chỉnh sửa", "Xóa"}));
                listPopupWindow.setAnchorView(holder.btnMore);
                listPopupWindow.setWidth(ListPopupWindow.WRAP_CONTENT);
                listPopupWindow.setOnItemClickListener((adapterView, view1, i, l) -> {
                    switch (i) {
                        case 0:
                            list.get(pos_default).set_default(false);
                            list.get(position).set_default(true);
                            pos_default = position;
                            notifyDataSetChanged();
                            break;
                        case 1:
                            intent = new Intent(context, EditUserAddressActivity.class);
                            putIntent(intent, userAddress);
                            context.startActivity(intent);
                            break;
                        case 2:
                            list.remove(i);
                            notifyDataSetChanged();
                    }
                    listPopupWindow.dismiss();
                });
                listPopupWindow.show();
            });

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private void putIntent(Intent i, UserAddress userAddress){
        i.putExtra("name", userAddress.getName());
        i.putExtra("phone", userAddress.getPhone());
        i.putExtra("address", userAddress.getAddress());
        i.putExtra("default", userAddress.is_default());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtPhone, txtAddress, txtDefault;
        ImageButton btnMore;
        ConstraintLayout block;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.user_address_name);
            txtPhone = itemView.findViewById(R.id.user_address_phone);
            txtAddress = itemView.findViewById(R.id.user_address_address);
            txtDefault = itemView.findViewById(R.id.user_address_default);
            btnMore = itemView.findViewById(R.id.user_address_btn_more);
            block = itemView.findViewById(R.id.user_address_block);
        }
    }
}
