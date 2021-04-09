package com.example.ecngv2.View.CateDetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ecngv2.Adapter.RCV_CateDetail_Cate_Adapter;
import com.example.ecngv2.Adapter.RCV_CateDetail_TradeMark_Adapter;
import com.example.ecngv2.Adapter.RCV_HomeHintProduct_Adapter;
import com.example.ecngv2.Adapter.SliderViewHomeAdapter;
import com.example.ecngv2.Adapter.Spinner_Rating_Adapter;
import com.example.ecngv2.Model.Object.Category;
import com.example.ecngv2.Model.Object.Product;
import com.example.ecngv2.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class CateDetailActivity extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    SliderView sliderView;
    Spinner spinner_rating;
    Button btn_back;
    RecyclerView rcv_trademark, rcv_cate, rcv_product;
    List<Integer> banners;
    List<Integer> list_trademark_img;
    List<Category> list_cate;
    List<Integer> list_rating_sort;
    List<String> list_rating;
    TextView btn_sort_common, btn_sort_fav, btn_sort_new, btn_sort_price;
    boolean check_sort_common = false, check_sort_fav = false, check_sort_new = false;
    int sort_price = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catedetail);
        Window window = getWindow();
        @SuppressLint("UseCompatLoadingForDrawables") Drawable background = getDrawable(R.drawable.appbar_background);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(android.R.color.transparent));
//        window.setNavigationBarColor(getColor(android.R.color.transparent));
        window.setBackgroundDrawable(background);

        init();
        intent = getIntent();
//        Toast.makeText(this, intent.getIntExtra("position", -1)+"", Toast.LENGTH_SHORT).show();
        btn_back.setText(intent.getStringExtra("title"));
        btn_back.setOnClickListener(this);

        spinner_rating.setAdapter(new Spinner_Rating_Adapter(this, R.layout.custom_spinner_rating_layout));

        sliderView.setSliderAdapter(new SliderViewHomeAdapter(this, banners));
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.startAutoCycle();

        rcv_trademark.setLayoutManager(new GridLayoutManager(this, 2, RecyclerView.HORIZONTAL, false));
        rcv_trademark.setAdapter(new RCV_CateDetail_TradeMark_Adapter(this, list_trademark_img));

        rcv_cate.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rcv_cate.setAdapter(new RCV_CateDetail_Cate_Adapter(this, list_cate));

        btn_sort_common.setOnClickListener(this);
        btn_sort_fav.setOnClickListener(this);
        btn_sort_new.setOnClickListener(this);
        btn_sort_price.setOnClickListener(this);

        List<Product> productList = new ArrayList<>();
        loadData(productList);
        rcv_product.setLayoutManager(new GridLayoutManager(this, 2));
        rcv_product.setAdapter(new RCV_HomeHintProduct_Adapter(this, productList));
    }

    private void init(){
        btn_back = findViewById(R.id.catedetail_btn_back);

        sliderView = findViewById(R.id.slide_banner);
        banners = new ArrayList<>();
        banners.add(R.drawable.banner_home_3);
        banners.add(R.drawable.banner_home_4);
        banners.add(R.drawable.banner_home_5);
        banners.add(R.drawable.banner_home_6);
        banners.add(R.drawable.banner_home_7);


        spinner_rating = findViewById(R.id.catedetail_sort_rating);
        list_rating_sort = new ArrayList<>();
        list_rating_sort.add(0);
        list_rating_sort.add(1);
        list_rating_sort.add(2);
        list_rating_sort.add(3);
        list_rating_sort.add(4);
        list_rating_sort.add(5);
        list_rating = new ArrayList<>();
        list_rating.add("Đánh giá");
        list_rating.add("4 * trở lên");
        list_rating.add("Đánh ");
        list_rating.add("Đánh giá");
        list_rating.add("Đánh giá");

        rcv_trademark = findViewById(R.id.catedetail_rcv_trademark);
        list_trademark_img = new ArrayList<>();
        list_trademark_img.add(R.drawable.logo_asus);
        list_trademark_img.add(R.drawable.logo_lg);
        list_trademark_img.add(R.drawable.logo_mac);
        list_trademark_img.add(R.drawable.logo_lenovo);
        list_trademark_img.add(R.drawable.logo_samsung);
        list_trademark_img.add(R.drawable.logo_brooks_brothers);
        list_trademark_img.add(R.drawable.logo_calvin_klein);
        list_trademark_img.add(R.drawable.logo_j_crew);
        list_trademark_img.add(R.drawable.logo_h_m);
        list_trademark_img.add(R.drawable.logo_guess);
        list_trademark_img.add(R.drawable.logo_ralph_lauren);

        rcv_cate = findViewById(R.id.catedetail_rcv_cate);
        list_cate = new ArrayList<>();
        list_cate.add(new Category("Smart phone", R.drawable.dienthoai1));
        list_cate.add(new Category("Laptop", R.drawable.laptop4));
        list_cate.add(new Category("Tablet", R.drawable.tablet));
        list_cate.add(new Category("Smart watch", R.drawable.dongho));
        list_cate.add(new Category("Phụ kiện", R.drawable.cate_dongho));
        list_cate.add(new Category("Smart phone", R.drawable.dienthoai1));
        list_cate.add(new Category("Laptop", R.drawable.laptop4));
        list_cate.add(new Category("Tablet", R.drawable.tablet));

        btn_sort_common = findViewById(R.id.catedetail_sort_common);
        btn_sort_fav = findViewById(R.id.catedetail_sort_fav);
        btn_sort_new = findViewById(R.id.catedetail_sort_new);
        btn_sort_price = findViewById(R.id.catedetail_sort_price);

        rcv_product = findViewById(R.id.catedetail_rcv_product);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.catedetail_btn_back:
                finish();
                break;
            case R.id.catedetail_sort_common:
                if (check_sort_common){
                    btn_sort_common.setBackground(getDrawable(R.drawable.background_radius_primary_color5));
                    btn_sort_common.setTextColor(getColor(R.color.white));
                    check_sort_common = !check_sort_common;

                    btn_sort_fav.setBackground(getDrawable(R.drawable.border_primary_color_5));
                    btn_sort_fav.setTextColor(getColor(R.color.primary_color));
                    check_sort_fav = !check_sort_fav;

                    btn_sort_new.setBackground(getDrawable(R.drawable.border_primary_color_5));
                    btn_sort_new.setTextColor(getColor(R.color.primary_color));
                    check_sort_new = !check_sort_new;
                }else {
                    btn_sort_common.setBackground(getDrawable(R.drawable.border_primary_color_5));
                    btn_sort_common.setTextColor(getColor(R.color.primary_color));
                    check_sort_common = !check_sort_common;
                }
                break;
            case R.id.catedetail_sort_fav:
                if (check_sort_fav){
                    btn_sort_fav.setBackground(getDrawable(R.drawable.background_radius_primary_color5));
                    btn_sort_fav.setTextColor(getColor(R.color.white));
                    check_sort_fav = !check_sort_fav;

                    btn_sort_common.setBackground(getDrawable(R.drawable.border_primary_color_5));
                    btn_sort_common.setTextColor(getColor(R.color.primary_color));
                    check_sort_common = !check_sort_common;

                    btn_sort_new.setBackground(getDrawable(R.drawable.border_primary_color_5));
                    btn_sort_new.setTextColor(getColor(R.color.primary_color));
                    check_sort_new = !check_sort_new;
                }else {
                    btn_sort_fav.setBackground(getDrawable(R.drawable.border_primary_color_5));
                    btn_sort_fav.setTextColor(getColor(R.color.primary_color));
                    check_sort_fav = !check_sort_fav;
                }
                break;
            case R.id.catedetail_sort_new:
                if (check_sort_new){
                    btn_sort_new.setBackground(getDrawable(R.drawable.background_radius_primary_color5));
                    btn_sort_new.setTextColor(getColor(R.color.white));
                    check_sort_new = !check_sort_new;

                    btn_sort_common.setBackground(getDrawable(R.drawable.border_primary_color_5));
                    btn_sort_common.setTextColor(getColor(R.color.primary_color));
                    check_sort_common = !check_sort_common;

                    btn_sort_fav.setBackground(getDrawable(R.drawable.border_primary_color_5));
                    btn_sort_fav.setTextColor(getColor(R.color.primary_color));
                    check_sort_fav = !check_sort_fav;
                }else {
                    btn_sort_new.setBackground(getDrawable(R.drawable.border_primary_color_5));
                    btn_sort_new.setTextColor(getColor(R.color.primary_color));
                    check_sort_new = !check_sort_new;
                }
                break;
            case R.id.catedetail_sort_price:
                switch (sort_price){
                    case 0:
                        btn_sort_price.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_up_primary, 0);
                        sort_price++;
                        break;
                    case 1:
                        btn_sort_price.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_down_primary, 0);
                        sort_price-=2;
                        break;
                    case -1:
                        btn_sort_price.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_up_down_primary, 0);
                        sort_price++;
                        break;
                }
                break;
        }
    }

    private void loadData(List<Product> hint_products){
        List<Integer> listImg;
        listImg = new ArrayList<>();
        listImg.add(R.drawable.dongho);
        listImg.add(R.drawable.img_applewatchs6_1);
        listImg.add(R.drawable.img_applewatchs6_2);
        listImg.add(R.drawable.img_applewatchs6_3);
        listImg.add(R.drawable.img_applewatchs6_4);
        listImg.add(R.drawable.img_applewatchs6_5);
        hint_products.add(new Product(R.drawable.dongho, (float)5,999, "Apple Watch S6 40mm viền nhôm dây cao su trắng", 20000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_laptoplenovoideapads340);
        listImg.add(R.drawable.img_laptoplenovoideapads340_1);
        listImg.add(R.drawable.img_laptoplenovoideapads340_2);
        listImg.add(R.drawable.img_laptoplenovoideapads340_3);
        listImg.add(R.drawable.img_laptoplenovoideapads340_4);
        listImg.add(R.drawable.img_laptoplenovoideapads340_5);
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapads340, (float)4.5, 999, "Laptop Lenovo IdeaPad S340 14IIL i3 1005G1/8GB/512GB/Win10 (81VV003VVN)", 13990000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_ipadpro11);
        listImg.add(R.drawable.img_ipadpro11_1);
        listImg.add(R.drawable.img_ipadpro11_2);
        listImg.add(R.drawable.img_ipadpro11_3);
        listImg.add(R.drawable.img_ipadpro11_4);
        hint_products.add(new Product(R.drawable.img_ipadpro11, (float)4.5, 999, "Máy tính bảng iPad Pro 11 inch Wifi Cellular 128GB (2020)", 25190000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_laptoplenovoideapad);
        listImg.add(R.drawable.img_laptoplenovoideapad_1);
        listImg.add(R.drawable.img_laptoplenovoideapad_2);
        listImg.add(R.drawable.img_laptoplenovoideapad_3);
        listImg.add(R.drawable.img_laptoplenovoideapad_4);
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapad, (float)4.5, 99, "Laptop Lenovo IdeaPad Gaming 3 15IMH05 i7 10750H/8GB/512GB/4GB GTX1650/Win10 (81Y40068VN)", 23990000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_tuixachlouisvuitton);
        listImg.add(R.drawable.img_tuixachlouisvuitton_1);
        listImg.add(R.drawable.img_tuixachlouisvuitton_2);
        listImg.add(R.drawable.img_tuixachlouisvuitton_3);
        listImg.add(R.drawable.img_tuixachlouisvuitton_4);
        listImg.add(R.drawable.img_tuixachlouisvuitton_5);
        hint_products.add(new Product(R.drawable.img_tuixachlouisvuitton, (float) 5, 99, "Túi Xách Louis Vuitton Cluny BB Monogram", 55000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_galaxyzfold2);
        listImg.add(R.drawable.img_galaxyzfold2_1);
        listImg.add(R.drawable.img_galaxyzfold2_2);
        listImg.add(R.drawable.img_galaxyzfold2_3);
        listImg.add(R.drawable.img_galaxyzfold2_4);
        listImg.add(R.drawable.img_galaxyzfold2_5);
        listImg.add(R.drawable.img_galaxyzfold2_6);
        listImg.add(R.drawable.img_galaxyzfold2_7);
        hint_products.add(new Product(R.drawable.img_galaxyzfold2, (float) 4.5, 9, "Điện thoại Samsung Galaxy Z Fold2 5G", 50000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_cameragopro9);
        listImg.add(R.drawable.img_cameragopro9_1);
        listImg.add(R.drawable.img_cameragopro9_2);
        listImg.add(R.drawable.img_cameragopro9_3);
        listImg.add(R.drawable.img_cameragopro9_4);
        hint_products.add(new Product(R.drawable.img_cameragopro9, (float) 5, 99, "Camera hành trình Gopro Hero 9", 10590000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_keyboardipad);
        listImg.add(R.drawable.img_keyboardipad_1);
        listImg.add(R.drawable.img_keyboardipad_2);
        listImg.add(R.drawable.img_keyboardipad_3);
        listImg.add(R.drawable.img_keyboardipad_4);
        hint_products.add(new Product(R.drawable.img_keyboardipad, (float) 5, 99, "Bàn phím Magic Keyboard cho iPad Pro 12.9 inch 2020 chính hãng", 9500000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_nuochoaunisexroja);
        listImg.add(R.drawable.img_nuochoaunisexroja_1);
        hint_products.add(new Product(R.drawable.img_nuochoaunisexroja, (float) 5, 99, "Nước Hoa Unisex Roja Dove Parfum De La Nuit No 3 100ml", 25000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_nuochoaunisextomford);
        listImg.add(R.drawable.img_nuochoaunisextomford_1);
        listImg.add(R.drawable.img_nuochoaunisextomford_2);
        hint_products.add(new Product(R.drawable.img_nuochoaunisextomford, (float) 5, 99, "Nước Hoa Unisex Tom Ford Noir De Noir EDP, 100ml", 7429000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.dongho);
        listImg.add(R.drawable.img_applewatchs6_1);
        listImg.add(R.drawable.img_applewatchs6_2);
        listImg.add(R.drawable.img_applewatchs6_3);
        listImg.add(R.drawable.img_applewatchs6_4);
        listImg.add(R.drawable.img_applewatchs6_5);
        hint_products.add(new Product(R.drawable.dongho, (float)5,999, "Apple Watch S6 40mm viền nhôm dây cao su trắng", 20000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_laptoplenovoideapads340);
        listImg.add(R.drawable.img_laptoplenovoideapads340_1);
        listImg.add(R.drawable.img_laptoplenovoideapads340_2);
        listImg.add(R.drawable.img_laptoplenovoideapads340_3);
        listImg.add(R.drawable.img_laptoplenovoideapads340_4);
        listImg.add(R.drawable.img_laptoplenovoideapads340_5);
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapads340, (float)4.5, 999, "Laptop Lenovo IdeaPad S340 14IIL i3 1005G1/8GB/512GB/Win10 (81VV003VVN)", 13990000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_ipadpro11);
        listImg.add(R.drawable.img_ipadpro11_1);
        listImg.add(R.drawable.img_ipadpro11_2);
        listImg.add(R.drawable.img_ipadpro11_3);
        listImg.add(R.drawable.img_ipadpro11_4);
        hint_products.add(new Product(R.drawable.img_ipadpro11, (float)4.5, 999, "Máy tính bảng iPad Pro 11 inch Wifi Cellular 128GB (2020)", 25190000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_laptoplenovoideapad);
        listImg.add(R.drawable.img_laptoplenovoideapad_1);
        listImg.add(R.drawable.img_laptoplenovoideapad_2);
        listImg.add(R.drawable.img_laptoplenovoideapad_3);
        listImg.add(R.drawable.img_laptoplenovoideapad_4);
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapad, (float)4.5, 99, "Laptop Lenovo IdeaPad Gaming 3 15IMH05 i7 10750H/8GB/512GB/4GB GTX1650/Win10 (81Y40068VN)", 23990000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_tuixachlouisvuitton);
        listImg.add(R.drawable.img_tuixachlouisvuitton_1);
        listImg.add(R.drawable.img_tuixachlouisvuitton_2);
        listImg.add(R.drawable.img_tuixachlouisvuitton_3);
        listImg.add(R.drawable.img_tuixachlouisvuitton_4);
        listImg.add(R.drawable.img_tuixachlouisvuitton_5);
        hint_products.add(new Product(R.drawable.img_tuixachlouisvuitton, (float) 5, 99, "Túi Xách Louis Vuitton Cluny BB Monogram", 55000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_galaxyzfold2);
        listImg.add(R.drawable.img_galaxyzfold2_1);
        listImg.add(R.drawable.img_galaxyzfold2_2);
        listImg.add(R.drawable.img_galaxyzfold2_3);
        listImg.add(R.drawable.img_galaxyzfold2_4);
        listImg.add(R.drawable.img_galaxyzfold2_5);
        listImg.add(R.drawable.img_galaxyzfold2_6);
        listImg.add(R.drawable.img_galaxyzfold2_7);
        hint_products.add(new Product(R.drawable.img_galaxyzfold2, (float) 4.5, 9, "Điện thoại Samsung Galaxy Z Fold2 5G", 50000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_cameragopro9);
        listImg.add(R.drawable.img_cameragopro9_1);
        listImg.add(R.drawable.img_cameragopro9_2);
        listImg.add(R.drawable.img_cameragopro9_3);
        listImg.add(R.drawable.img_cameragopro9_4);
        hint_products.add(new Product(R.drawable.img_cameragopro9, (float) 5, 99, "Camera hành trình Gopro Hero 9", 10590000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_keyboardipad);
        listImg.add(R.drawable.img_keyboardipad_1);
        listImg.add(R.drawable.img_keyboardipad_2);
        listImg.add(R.drawable.img_keyboardipad_3);
        listImg.add(R.drawable.img_keyboardipad_4);
        hint_products.add(new Product(R.drawable.img_keyboardipad, (float) 5, 99, "Bàn phím Magic Keyboard cho iPad Pro 12.9 inch 2020 chính hãng", 9500000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_nuochoaunisexroja);
        listImg.add(R.drawable.img_nuochoaunisexroja_1);
        hint_products.add(new Product(R.drawable.img_nuochoaunisexroja, (float) 5, 99, "Nước Hoa Unisex Roja Dove Parfum De La Nuit No 3 100ml", 25000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_nuochoaunisextomford);
        listImg.add(R.drawable.img_nuochoaunisextomford_1);
        listImg.add(R.drawable.img_nuochoaunisextomford_2);
        hint_products.add(new Product(R.drawable.img_nuochoaunisextomford, (float) 5, 99, "Nước Hoa Unisex Tom Ford Noir De Noir EDP, 100ml", 7429000, listImg));
        listImg = new ArrayList<>();
        listImg.add(R.drawable.dongho);
        listImg.add(R.drawable.img_applewatchs6_1);
        listImg.add(R.drawable.img_applewatchs6_2);
        listImg.add(R.drawable.img_applewatchs6_3);
        listImg.add(R.drawable.img_applewatchs6_4);
        listImg.add(R.drawable.img_applewatchs6_5);
        hint_products.add(new Product(R.drawable.dongho, (float)5,999, "Apple Watch S6 40mm viền nhôm dây cao su trắng", 20000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_laptoplenovoideapads340);
        listImg.add(R.drawable.img_laptoplenovoideapads340_1);
        listImg.add(R.drawable.img_laptoplenovoideapads340_2);
        listImg.add(R.drawable.img_laptoplenovoideapads340_3);
        listImg.add(R.drawable.img_laptoplenovoideapads340_4);
        listImg.add(R.drawable.img_laptoplenovoideapads340_5);
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapads340, (float)4.5, 999, "Laptop Lenovo IdeaPad S340 14IIL i3 1005G1/8GB/512GB/Win10 (81VV003VVN)", 13990000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_ipadpro11);
        listImg.add(R.drawable.img_ipadpro11_1);
        listImg.add(R.drawable.img_ipadpro11_2);
        listImg.add(R.drawable.img_ipadpro11_3);
        listImg.add(R.drawable.img_ipadpro11_4);
        hint_products.add(new Product(R.drawable.img_ipadpro11, (float)4.5, 999, "Máy tính bảng iPad Pro 11 inch Wifi Cellular 128GB (2020)", 25190000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_laptoplenovoideapad);
        listImg.add(R.drawable.img_laptoplenovoideapad_1);
        listImg.add(R.drawable.img_laptoplenovoideapad_2);
        listImg.add(R.drawable.img_laptoplenovoideapad_3);
        listImg.add(R.drawable.img_laptoplenovoideapad_4);
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapad, (float)4.5, 99, "Laptop Lenovo IdeaPad Gaming 3 15IMH05 i7 10750H/8GB/512GB/4GB GTX1650/Win10 (81Y40068VN)", 23990000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_tuixachlouisvuitton);
        listImg.add(R.drawable.img_tuixachlouisvuitton_1);
        listImg.add(R.drawable.img_tuixachlouisvuitton_2);
        listImg.add(R.drawable.img_tuixachlouisvuitton_3);
        listImg.add(R.drawable.img_tuixachlouisvuitton_4);
        listImg.add(R.drawable.img_tuixachlouisvuitton_5);
        hint_products.add(new Product(R.drawable.img_tuixachlouisvuitton, (float) 5, 99, "Túi Xách Louis Vuitton Cluny BB Monogram", 55000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_galaxyzfold2);
        listImg.add(R.drawable.img_galaxyzfold2_1);
        listImg.add(R.drawable.img_galaxyzfold2_2);
        listImg.add(R.drawable.img_galaxyzfold2_3);
        listImg.add(R.drawable.img_galaxyzfold2_4);
        listImg.add(R.drawable.img_galaxyzfold2_5);
        listImg.add(R.drawable.img_galaxyzfold2_6);
        listImg.add(R.drawable.img_galaxyzfold2_7);
        hint_products.add(new Product(R.drawable.img_galaxyzfold2, (float) 4.5, 9, "Điện thoại Samsung Galaxy Z Fold2 5G", 50000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_cameragopro9);
        listImg.add(R.drawable.img_cameragopro9_1);
        listImg.add(R.drawable.img_cameragopro9_2);
        listImg.add(R.drawable.img_cameragopro9_3);
        listImg.add(R.drawable.img_cameragopro9_4);
        hint_products.add(new Product(R.drawable.img_cameragopro9, (float) 5, 99, "Camera hành trình Gopro Hero 9", 10590000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_keyboardipad);
        listImg.add(R.drawable.img_keyboardipad_1);
        listImg.add(R.drawable.img_keyboardipad_2);
        listImg.add(R.drawable.img_keyboardipad_3);
        listImg.add(R.drawable.img_keyboardipad_4);
        hint_products.add(new Product(R.drawable.img_keyboardipad, (float) 5, 99, "Bàn phím Magic Keyboard cho iPad Pro 12.9 inch 2020 chính hãng", 9500000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_nuochoaunisexroja);
        listImg.add(R.drawable.img_nuochoaunisexroja_1);
        hint_products.add(new Product(R.drawable.img_nuochoaunisexroja, (float) 5, 99, "Nước Hoa Unisex Roja Dove Parfum De La Nuit No 3 100ml", 25000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_nuochoaunisextomford);
        listImg.add(R.drawable.img_nuochoaunisextomford_1);
        listImg.add(R.drawable.img_nuochoaunisextomford_2);
        hint_products.add(new Product(R.drawable.img_nuochoaunisextomford, (float) 5, 99, "Nước Hoa Unisex Tom Ford Noir De Noir EDP, 100ml", 7429000, listImg));
        listImg = new ArrayList<>();
        listImg.add(R.drawable.dongho);
        listImg.add(R.drawable.img_applewatchs6_1);
        listImg.add(R.drawable.img_applewatchs6_2);
        listImg.add(R.drawable.img_applewatchs6_3);
        listImg.add(R.drawable.img_applewatchs6_4);
        listImg.add(R.drawable.img_applewatchs6_5);
        hint_products.add(new Product(R.drawable.dongho, (float)5,999, "Apple Watch S6 40mm viền nhôm dây cao su trắng", 20000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_laptoplenovoideapads340);
        listImg.add(R.drawable.img_laptoplenovoideapads340_1);
        listImg.add(R.drawable.img_laptoplenovoideapads340_2);
        listImg.add(R.drawable.img_laptoplenovoideapads340_3);
        listImg.add(R.drawable.img_laptoplenovoideapads340_4);
        listImg.add(R.drawable.img_laptoplenovoideapads340_5);
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapads340, (float)4.5, 999, "Laptop Lenovo IdeaPad S340 14IIL i3 1005G1/8GB/512GB/Win10 (81VV003VVN)", 13990000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_ipadpro11);
        listImg.add(R.drawable.img_ipadpro11_1);
        listImg.add(R.drawable.img_ipadpro11_2);
        listImg.add(R.drawable.img_ipadpro11_3);
        listImg.add(R.drawable.img_ipadpro11_4);
        hint_products.add(new Product(R.drawable.img_ipadpro11, (float)4.5, 999, "Máy tính bảng iPad Pro 11 inch Wifi Cellular 128GB (2020)", 25190000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_laptoplenovoideapad);
        listImg.add(R.drawable.img_laptoplenovoideapad_1);
        listImg.add(R.drawable.img_laptoplenovoideapad_2);
        listImg.add(R.drawable.img_laptoplenovoideapad_3);
        listImg.add(R.drawable.img_laptoplenovoideapad_4);
        hint_products.add(new Product(R.drawable.img_laptoplenovoideapad, (float)4.5, 99, "Laptop Lenovo IdeaPad Gaming 3 15IMH05 i7 10750H/8GB/512GB/4GB GTX1650/Win10 (81Y40068VN)", 23990000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_tuixachlouisvuitton);
        listImg.add(R.drawable.img_tuixachlouisvuitton_1);
        listImg.add(R.drawable.img_tuixachlouisvuitton_2);
        listImg.add(R.drawable.img_tuixachlouisvuitton_3);
        listImg.add(R.drawable.img_tuixachlouisvuitton_4);
        listImg.add(R.drawable.img_tuixachlouisvuitton_5);
        hint_products.add(new Product(R.drawable.img_tuixachlouisvuitton, (float) 5, 99, "Túi Xách Louis Vuitton Cluny BB Monogram", 55000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_galaxyzfold2);
        listImg.add(R.drawable.img_galaxyzfold2_1);
        listImg.add(R.drawable.img_galaxyzfold2_2);
        listImg.add(R.drawable.img_galaxyzfold2_3);
        listImg.add(R.drawable.img_galaxyzfold2_4);
        listImg.add(R.drawable.img_galaxyzfold2_5);
        listImg.add(R.drawable.img_galaxyzfold2_6);
        listImg.add(R.drawable.img_galaxyzfold2_7);
        hint_products.add(new Product(R.drawable.img_galaxyzfold2, (float) 4.5, 9, "Điện thoại Samsung Galaxy Z Fold2 5G", 50000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_cameragopro9);
        listImg.add(R.drawable.img_cameragopro9_1);
        listImg.add(R.drawable.img_cameragopro9_2);
        listImg.add(R.drawable.img_cameragopro9_3);
        listImg.add(R.drawable.img_cameragopro9_4);
        hint_products.add(new Product(R.drawable.img_cameragopro9, (float) 5, 99, "Camera hành trình Gopro Hero 9", 10590000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_keyboardipad);
        listImg.add(R.drawable.img_keyboardipad_1);
        listImg.add(R.drawable.img_keyboardipad_2);
        listImg.add(R.drawable.img_keyboardipad_3);
        listImg.add(R.drawable.img_keyboardipad_4);
        hint_products.add(new Product(R.drawable.img_keyboardipad, (float) 5, 99, "Bàn phím Magic Keyboard cho iPad Pro 12.9 inch 2020 chính hãng", 9500000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_nuochoaunisexroja);
        listImg.add(R.drawable.img_nuochoaunisexroja_1);
        hint_products.add(new Product(R.drawable.img_nuochoaunisexroja, (float) 5, 99, "Nước Hoa Unisex Roja Dove Parfum De La Nuit No 3 100ml", 25000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_nuochoaunisextomford);
        listImg.add(R.drawable.img_nuochoaunisextomford_1);
        listImg.add(R.drawable.img_nuochoaunisextomford_2);
        hint_products.add(new Product(R.drawable.img_nuochoaunisextomford, (float) 5, 99, "Nước Hoa Unisex Tom Ford Noir De Noir EDP, 100ml", 7429000, listImg));
    }
}