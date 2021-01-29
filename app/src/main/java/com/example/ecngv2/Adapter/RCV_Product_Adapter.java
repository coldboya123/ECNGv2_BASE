package com.example.ecngv2.Adapter;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Model.Comment;
import com.example.ecngv2.Model.Product;
import com.example.ecngv2.Model.ProductShop;
import com.example.ecngv2.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class RCV_Product_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;

    public RCV_Product_Adapter(Context context) {
        this.context = context;
    }

    private final int PRODUCTSHOP = 0;
    private final int INFO = 1;
    private final int DESCRIPT = 2;
    private final int VOTE = 3;
    private final int MORE_PRODUCT = 4;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        switch (viewType){
            case PRODUCTSHOP:
                v = LayoutInflater.from(context).inflate(R.layout.rcv_product_shop, parent, false);
                return new ProductShopHolder(v);
            case INFO:
                v = LayoutInflater.from(context).inflate(R.layout.product_info_layout, parent, false);
                return new InfoHolder(v);
            case DESCRIPT:
                v = LayoutInflater.from(context).inflate(R.layout.product_descript_layout, parent, false);
                return new DesHolder(v);
            case VOTE:
                v = LayoutInflater.from(context).inflate(R.layout.product_vote_layout, parent, false);
                return new VoteHolder(v);
            case MORE_PRODUCT:
                v = LayoutInflater.from(context).inflate(R.layout.product_more_layout, parent, false);
                return new MoreHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ProductShopHolder){
            List<ProductShop> productShopList = new ArrayList<>();
            productShopList.add(new ProductShop(R.drawable.laptop1, "Laptop Dell ........", "33.000.000đ", "30.000.000đ"));
            productShopList.add(new ProductShop(R.drawable.laptop2, "Laptop Dell ........", "33.000.000đ", "30.000.000đ"));
            productShopList.add(new ProductShop(R.drawable.laptop3, "Laptop Dell ........", "33.000.000đ", "30.000.000đ"));
            productShopList.add(new ProductShop(R.drawable.laptop4, "Laptop Dell ........", "33.000.000đ", "30.000.000đ"));
            productShopList.add(new ProductShop(R.drawable.laptop5, "Laptop Dell ........", "33.000.000đ", "30.000.000đ"));
            productShopList.add(new ProductShop(R.drawable.laptop1, "Laptop Dell ........", "33.000.000đ", "30.000.000đ"));
            productShopList.add(new ProductShop(R.drawable.laptop2, "Laptop Dell ........", "33.000.000đ", "30.000.000đ"));
            productShopList.add(new ProductShop(R.drawable.laptop3, "Laptop Dell ........", "33.000.000đ", "30.000.000đ"));
            RCV_ProductShop_Adapter rcv_productShop_adapter = new RCV_ProductShop_Adapter(context, productShopList);
            ((ProductShopHolder) holder).rcv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            ((ProductShopHolder) holder).rcv.setAdapter(rcv_productShop_adapter);
        } else if (holder instanceof InfoHolder){
            AtomicBoolean show = new AtomicBoolean(false);
            ((InfoHolder) holder).btn_show.setOnClickListener(view -> {
                if (!show.get()){
                    ((InfoHolder) holder).btn_show.setText("< Ẩn bớt");
                    ((InfoHolder) holder).hiden_info.setVisibility(View.VISIBLE);
                    show.set(true);
                }else {
                    ((InfoHolder) holder).btn_show.setText("Xem tất cả >");
                    ((InfoHolder) holder).hiden_info.setVisibility(View.GONE);
                    show.set(false);
                }
            });
        } else if (holder instanceof DesHolder){
            AtomicBoolean show = new AtomicBoolean(false);
            ((DesHolder) holder).btn_show.setOnClickListener(view -> {
                if (!show.get()){
                    ((DesHolder) holder).btn_show.setText("< Ẩn bớt");
                    ((DesHolder) holder).hiden_des.getLayoutParams().height = FrameLayout.LayoutParams.WRAP_CONTENT;
                    show.set(true);
                }else {
                    int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, context.getResources().getDisplayMetrics());
                    ((DesHolder) holder).btn_show.setText("Xem tất cả >");
                    ((DesHolder) holder).hiden_des.getLayoutParams().height = height;
                    show.set(false);
                }
            });
        } else if (holder instanceof VoteHolder){
            List<Comment> commentList = new ArrayList<>();
            commentList.add(new Comment(R.drawable.category_1, R.drawable.laptop2, R.drawable.laptop3, (float) 5.0, "Bồ Tới", "Tuy hàng mã VN/A luôn trong tình trạng cháy hàng, các Store chỉ bán cho khách cọc với giá 32-33tr. Trên app Tiki báo hết hàng liên tục mình khá bực mình nhưng cứ 1 vài tiếng Tiki lại cập nhật lại tồn kho nên cũng mua được. Đặt 10h30..."));
            commentList.add(new Comment(R.drawable.category_2, R.drawable.laptop2, R.drawable.laptop3, (float) 5.0, "Bồ Long", "Tuy hàng mã VN/A luôn trong tình trạng cháy hàng, các Store chỉ bán cho khách cọc với giá 32-33tr. Trên app Tiki báo hết hàng liên tục mình khá bực mình nhưng cứ 1 vài tiếng Tiki lại cập nhật lại tồn kho nên cũng mua được. Đặt 10h30..."));
            ((VoteHolder) holder).rcv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
            ((VoteHolder) holder).rcv.setAdapter(new RCV_Product_Comment(context, commentList));
        } else if (holder instanceof MoreHolder){
            List<Product> productList = new ArrayList<>();
            loadData(productList);
            ((MoreHolder) holder).rcv.setLayoutManager(new GridLayoutManager(context, 2));
            RCV_Sugg_All_Adapter rcv_sugg_all_adapter = new RCV_Sugg_All_Adapter(context, productList);
            ((MoreHolder) holder).rcv.setAdapter(rcv_sugg_all_adapter);
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                return PRODUCTSHOP;
            case 1:
                return INFO;
            case 2:
                return DESCRIPT;
            case 3:
                return VOTE;
            case 4:
                return MORE_PRODUCT;
        }
        return -1;
    }

    private void loadData(List<Product> list_products){
        list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.category_2, 999, "Laptop DELL inpre...", "999.000.000d", (float) 5));
        list_products.add(new Product(R.drawable.category_1, 999, "Laptop DELL inpre...", "999.000.000d", (float) 5));
        list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.matkinh, 9, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.dongho, 99, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));
        list_products.add(new Product(R.drawable.category_2, 999, "Laptop DELL inpre...", "999.000.000d", (float) 5));
        list_products.add(new Product(R.drawable.category_1, 999, "Laptop DELL inpre...", "999.000.000d", (float) 5));
        list_products.add(new Product(R.drawable.laptop, 999, "Laptop DELL inpre...", "20.000.000d", (float) 4.5));

    }

    public class ProductShopHolder extends RecyclerView.ViewHolder{
        RecyclerView rcv;
        public ProductShopHolder(@NonNull View itemView) {
            super(itemView);
            rcv = itemView.findViewById(R.id.rcv_product_shop);
        }
    }

    public class InfoHolder extends RecyclerView.ViewHolder {
        LinearLayout hiden_info;
        TextView btn_show;
        public InfoHolder(@NonNull View itemView) {
            super(itemView);
            hiden_info = itemView.findViewById(R.id.product_info_hide);
            btn_show = itemView.findViewById(R.id.product_btn_showinfo);
        }
    }

    public class DesHolder extends RecyclerView.ViewHolder {
        LinearLayout hiden_des;
        TextView btn_show;
        public DesHolder(@NonNull View itemView) {
            super(itemView);
            hiden_des = itemView.findViewById(R.id.product_descript);
            btn_show = itemView.findViewById(R.id.product_btn_showdes);
        }
    }
    public class VoteHolder extends RecyclerView.ViewHolder {
        RecyclerView rcv;
        public VoteHolder(@NonNull View itemView) {
            super(itemView);
            rcv = itemView.findViewById(R.id.rcv_product_comment);
        }
    }
    public class MoreHolder extends RecyclerView.ViewHolder {
        RecyclerView rcv;
        public MoreHolder(@NonNull View itemView) {
            super(itemView);
            rcv = itemView.findViewById(R.id.rcv_product_moreproduct);
        }
    }
}
