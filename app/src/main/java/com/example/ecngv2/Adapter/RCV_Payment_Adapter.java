package com.example.ecngv2.Adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Adapter.Handle.HandleRCVPaymentAdapter;
import com.example.ecngv2.Model.Object.ProductCart;
import com.example.ecngv2.Model.Object.ProductPayment;
import com.example.ecngv2.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class RCV_Payment_Adapter extends RecyclerView.Adapter<RCV_Payment_Adapter.Holder> {

    Context context;
    List<ProductPayment> list;
    HandleRCVPaymentAdapter handle;

    BottomSheetDialog shipping_dialog;
    Button btn_hide_shipping_dialog;
    ConstraintLayout radio_shipping_block1, radio_shipping_block2, radio_shipping_block3;
    RadioButton radio_shipping_1, radio_shipping_2, radio_shipping_3, radio_shipping_checked;
    ColorStateList colorStateList;
    TextView shippingName1, shippingName2, shippingName3, shippingPrice1, shippingPrice2, shippingPrice3, shippingTime1, shippingTime2, shippingTime3;
    String shippingName = "";
    String shippingPrice = "";
    String shippingTime = "";

    public RCV_Payment_Adapter(Context context, List<ProductPayment> list, HandleRCVPaymentAdapter handle) {
        this.context = context;
        this.list = list;
        this.handle = handle;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rcv_payment, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ProductPayment payment = list.get(position);
        holder.shop.setText(payment.getShop());
        int subtotal = payment.getShipping();
        int shipping_Price = 0;
        for (int i=0; i<payment.getList().size(); i++){
            subtotal += (payment.getList().get(i).getPrice() * payment.getList().get(i).getNum());
        }
        subtotal += shipping_Price;
        holder.subtotal.setText(String.format("%,d", subtotal)+" đ");
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        holder.recyclerView.setAdapter(new RCV_Payment_Item_Adapter(context, payment.getList()));
        holder.change_shipping.setOnClickListener(view -> {
            init();
            shipping_dialog.show();
            btn_hide_shipping_dialog.setOnClickListener(view1 -> {
                shipping_dialog.hide();
                holder.shipping_name.setText(shippingName);
                holder.shipping_price.setText(shippingPrice);
                holder.shipping_time.setText(shippingTime);
                holder.shipping_item.setVisibility(View.VISIBLE);
                notifyDataSetChanged();
                handle.updateTotal();
            });
            radio_shipping_block1.setOnClickListener(view1 -> {
                radio_shipping_checked.setChecked(false);
                radio_shipping_1.setChecked(true);
                radio_shipping_checked = radio_shipping_1;
                shippingName = shippingName1.getText().toString();
                shippingPrice = shippingPrice1.getText().toString();
                shippingTime = shippingTime1.getText().toString();
                payment.setShipping(32000);
            });
            radio_shipping_block2.setOnClickListener(view1 -> {
                radio_shipping_checked.setChecked(false);
                radio_shipping_2.setChecked(true);
                radio_shipping_checked = radio_shipping_2;
                shippingName = shippingName2.getText().toString();
                shippingPrice = shippingPrice2.getText().toString();
                shippingTime = shippingTime2.getText().toString();
                payment.setShipping(38000);
            });
            radio_shipping_block3.setOnClickListener(view1 -> {
                radio_shipping_checked.setChecked(false);
                radio_shipping_3.setChecked(true);
                radio_shipping_checked = radio_shipping_3;
                shippingName = shippingName3.getText().toString();
                shippingPrice = shippingPrice3.getText().toString();
                shippingTime = shippingTime3.getText().toString();
                payment.setShipping(52000);
            });
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private void setShippingPrice(int temp, int price){
        temp = price;
    }

    private void init(){
        shipping_dialog = new BottomSheetDialog(context);
        shipping_dialog.setContentView(R.layout.dialog_choose_shipping);
        btn_hide_shipping_dialog = shipping_dialog.findViewById(R.id.dialog_chooseshipping_hide);
        shippingName1 = shipping_dialog.findViewById(R.id.radius_shipping_name1);
        shippingName2 = shipping_dialog.findViewById(R.id.radius_shipping_name2);
        shippingName3 = shipping_dialog.findViewById(R.id.radius_shipping_name3);
        shippingPrice1 = shipping_dialog.findViewById(R.id.radius_shipping_price1);
        shippingPrice2 = shipping_dialog.findViewById(R.id.radius_shipping_price2);
        shippingPrice3 = shipping_dialog.findViewById(R.id.radius_shipping_price3);
        shippingTime1 = shipping_dialog.findViewById(R.id.radius_shipping_time1);
        shippingTime2 = shipping_dialog.findViewById(R.id.radius_shipping_time2);
        shippingTime3 = shipping_dialog.findViewById(R.id.radius_shipping_time3);
        radio_shipping_1 = shipping_dialog.findViewById(R.id.radio_btn_shipping1);
        radio_shipping_2 = shipping_dialog.findViewById(R.id.radio_btn_shipping2);
        radio_shipping_3 = shipping_dialog.findViewById(R.id.radio_btn_shipping3);
        radio_shipping_checked = radio_shipping_1;
//        radio_shipping_checked.setChecked(true);
        radio_shipping_block1 = shipping_dialog.findViewById(R.id.radio_shipping_block1);
        radio_shipping_block2 = shipping_dialog.findViewById(R.id.radio_shipping_block2);
        radio_shipping_block3 = shipping_dialog.findViewById(R.id.radio_shipping_block3);
        colorStateList = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_checked},
                        new int[]{android.R.attr.state_checked}
                },
                new int[]{

                        context.getColor(R.color.dark)
                        , context.getColor(R.color.primary_color),
                }
        );
        radio_shipping_1.setButtonTintList(colorStateList);
        radio_shipping_2.setButtonTintList(colorStateList);
        radio_shipping_3.setButtonTintList(colorStateList);
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView shop, subtotal, shipping_name, shipping_price, shipping_time;
        ConstraintLayout change_shipping, shipping_item;
        RecyclerView recyclerView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            shop = itemView.findViewById(R.id.payment_shop);
            subtotal = itemView.findViewById(R.id.payment_subtotal);
            recyclerView = itemView.findViewById(R.id.rcv_payment_product);
            change_shipping = itemView.findViewById(R.id.payment_shipping_block);
            shipping_item = itemView.findViewById(R.id.payment_shipping_item_block);
            shipping_name = itemView.findViewById(R.id.payment_shipping_name);
            shipping_price = itemView.findViewById(R.id.payment_shipping_price);
            shipping_time = itemView.findViewById(R.id.payment_shipping_time);
        }
    }
}
