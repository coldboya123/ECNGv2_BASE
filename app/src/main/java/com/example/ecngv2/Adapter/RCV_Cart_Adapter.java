package com.example.ecngv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Adapter.Handle.HandleRCVCartItemAdapter;
import com.example.ecngv2.Adapter.Handle.HandleRCVCartAdapter;
import com.example.ecngv2.Model.Object.ProductCart;
import com.example.ecngv2.R;
import com.google.android.material.checkbox.MaterialCheckBox;

import java.util.List;

public class RCV_Cart_Adapter extends RecyclerView.Adapter<RCV_Cart_Adapter.Holder> implements HandleRCVCartItemAdapter {

    Context context;
    List<ProductCart> list;
    RecyclerView recyclerView;
    HandleRCVCartAdapter handle;

    public RCV_Cart_Adapter(Context context, List<ProductCart> list, HandleRCVCartAdapter handle) {
        this.context = context;
        this.list = list;
        this.handle = handle;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rcv_cart, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ProductCart cart = list.get(position);
        holder.shop.setText(cart.getShop());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        holder.recyclerView.setAdapter(new RCV_Cart_Item_Adapter(context, cart.getList(), this));
        holder.check.setOnCheckedChangeListener((compoundButton, b) -> {
            for (int i=0; i<cart.getList().size(); i++){
                cart.getList().get(i).setCheck(b);
            }
            notifyDataSetChanged();
            handle.UpdateTotalPrice(getTotalPrice());
        });
        recyclerView = holder.recyclerView;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void removeItem() {
        for (int i=0; i<list.size(); i++){
            if (list.get(i).getList().size()==0){
                list.remove(i);
                notifyDataSetChanged();
            }
        }
    }

    @Override
    public void updateTotalPrice() {
        handle.UpdateTotalPrice(getTotalPrice());

    }

    public int getTotalPrice(){
        int total = 0;
        for (int i=0; i<list.size(); i++){
            for (int j=0; j<list.get(i).getList().size(); j++){
                if (list.get(i).getList().get(j).isCheck()){
                    total += (list.get(i).getList().get(j).getPrice() * list.get(i).getList().get(j).getNum());
                }
            }
        }
        return total;
    }

    public class Holder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView shop;
        ConstraintLayout block;
        MaterialCheckBox check;

        public Holder(@NonNull View itemView) {
            super(itemView);
            shop = itemView.findViewById(R.id.cart_shop);
            recyclerView = itemView.findViewById(R.id.rcv_cart);
            block = itemView.findViewById(R.id.cart_block);
            check = itemView.findViewById(R.id.cart_check);
        }
    }
}
