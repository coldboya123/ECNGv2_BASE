package com.example.ecngv2.View.Help;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecngv2.Adapter.RCV_HomeNewProduct_Adapter;
import com.example.ecngv2.Adapter.RCV_Home_Adapter;
import com.example.ecngv2.Adapter.RCV_Home_Category_Adapter;
import com.example.ecngv2.Adapter.SliderViewHomeAdapter;
import com.example.ecngv2.Model.Object.Category;
import com.example.ecngv2.Model.Object.Product;
import com.example.ecngv2.Presenter.User.UserPresenter;
import com.example.ecngv2.R;
import com.example.ecngv2.View.Address.UserAddressActivity;
import com.example.ecngv2.View.Favorite.FavoriteActivity;
import com.example.ecngv2.View.Login.LoginActivity;
import com.example.ecngv2.View.MainActivity.MainActivity;
import com.example.ecngv2.View.OrderManager.OrderManagerActivity;
import com.example.ecngv2.View.RecentlyViewed.RecentlyViewedActivity;
import com.example.ecngv2.View.Register.RegisterActivity;
import com.example.ecngv2.View.User.IUserView;
import com.example.ecngv2.View.UserProfile.UserProfileActivity;
import com.example.ecngv2.View.Voucher.VoucherActivity;
import com.example.ecngv2.View.Wallet.WalletActivity;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class testActivity extends AppCompatActivity  {
    SwipeRefreshLayout refreshLayout;
    SliderView sliderView;
    List<Integer> list, banners, listImg;
    List<Category> categoryList;
    SearchView searchView;
    ImageView banner;
    List<Product> productList;
    RecyclerView recycler_category, recycler_home, rcv_newproduct;
    androidx.appcompat.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Window window = getWindow();
        @SuppressLint("UseCompatLoadingForDrawables") Drawable background = getDrawable(R.drawable.appbar_background);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(android.R.color.transparent));
//        window.setNavigationBarColor(getColor(android.R.color.transparent));
        window.setBackgroundDrawable(background);
        init();

        refreshLayout.setOnRefreshListener(() -> refreshLayout.setRefreshing(false));

        //set Onclick for toolbar
        toolbar.setOnMenuItemClickListener(menuItem -> {
            switch (menuItem.getItemId()) {
//                    case R.id.shopping_cart:
//                        context.startActivity(new Intent(this, CartActivity.class));
//                        return true;
//                    case R.id.notification:
//                        context.startActivity(new Intent(this, CartActivity.class));
            }
            return false;
        });

        //Custom SearchView
        LinearLayout linearLayout1 = (LinearLayout) searchView.getChildAt(0);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout1.getChildAt(2);
        LinearLayout linearLayout3 = (LinearLayout) linearLayout2.getChildAt(1);
        AutoCompleteTextView autoComplete = (AutoCompleteTextView) linearLayout3.getChildAt(0);
        autoComplete.setTextSize(15);
        searchView.setOnClickListener(v1 -> {
            searchView.setIconified(false);
        });

        //effect background radius
        banner.setClipToOutline(true);

        //Set Adapter for RecyclerView New Product
        rcv_newproduct.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rcv_newproduct.setAdapter(new RCV_HomeNewProduct_Adapter(this, productList));

        //Set Adapter for SliderView
        sliderView.setSliderAdapter(new SliderViewHomeAdapter(this, banners));
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.startAutoCycle();

        //Set Adapter for RecyclerView Category
        categoryList.add(new Category("Bất Động Sản", R.drawable.cate_batdongsan));
        categoryList.add(new Category("Công Nghệ", R.drawable.cate_congnghe));
        categoryList.add(new Category("Đồng Hồ", R.drawable.cate_dongho));
        categoryList.add(new Category("Gia Dụng", R.drawable.cate_giadung));
        categoryList.add(new Category("Làm Đẹp", R.drawable.cate_lamdep));
        categoryList.add(new Category("Mỹ Phẩm", R.drawable.cate_mypham));
        categoryList.add(new Category("Thời Trang", R.drawable.cate_thoitrang));
        categoryList.add(new Category("Thực Phẩm", R.drawable.cate_thucpham));
        categoryList.add(new Category("Thú Cưng", R.drawable.cate_thucung));
        categoryList.add(new Category("Trang Sức", R.drawable.cate_trangsuc));
        recycler_category.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recycler_category.setAdapter(new RCV_Home_Category_Adapter(this, categoryList));

        //Set Adapter for RecyclerView Home
        RCV_Home_Adapter rcv_home_adapter = new RCV_Home_Adapter(this);
        recycler_home.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recycler_home.setAdapter(rcv_home_adapter);

    }
    private void init() {
        refreshLayout = findViewById(R.id.refresh_home);

        searchView = findViewById(R.id.searchbar);

        recycler_home = findViewById(R.id.recycler_home);
        sliderView = findViewById(R.id.slide_banner);
        toolbar = findViewById(R.id.toolbar);
        list = new ArrayList<>();
        recycler_category = findViewById(R.id.recycler_category);
        categoryList = new ArrayList<>();
        banner = findViewById(R.id.banner);

        banners = new ArrayList<>();
        banners.add(R.drawable.banner_home_5);
        banners.add(R.drawable.banner_home_6);
        banners.add(R.drawable.banner_home_3);
        banners.add(R.drawable.banner_home_4);
        banners.add(R.drawable.banner_home_5);
        banners.add(R.drawable.banner_home_6);

        rcv_newproduct = findViewById(R.id.rcv_newproduct);
        productList = new ArrayList<>();
        listImg = new ArrayList<>();
        listImg.add(R.drawable.dongho);
        listImg.add(R.drawable.img_applewatchs6_1);
        listImg.add(R.drawable.img_applewatchs6_2);
        listImg.add(R.drawable.img_applewatchs6_3);
        listImg.add(R.drawable.img_applewatchs6_4);
        listImg.add(R.drawable.img_applewatchs6_5);
        productList.add(new Product(R.drawable.dongho, (float)5,999, "Apple Watch S6 40mm viền nhôm dây cao su trắng", 20000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_laptoplenovoideapads340);
        listImg.add(R.drawable.img_laptoplenovoideapads340_1);
        listImg.add(R.drawable.img_laptoplenovoideapads340_2);
        listImg.add(R.drawable.img_laptoplenovoideapads340_3);
        listImg.add(R.drawable.img_laptoplenovoideapads340_4);
        listImg.add(R.drawable.img_laptoplenovoideapads340_5);
        productList.add(new Product(R.drawable.img_laptoplenovoideapads340, (float)4.5, 999, "Laptop Lenovo IdeaPad S340 14IIL i3 1005G1/8GB/512GB/Win10 (81VV003VVN)", 13990000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_ipadpro11);
        listImg.add(R.drawable.img_ipadpro11_1);
        listImg.add(R.drawable.img_ipadpro11_2);
        listImg.add(R.drawable.img_ipadpro11_3);
        listImg.add(R.drawable.img_ipadpro11_4);
        productList.add(new Product(R.drawable.img_ipadpro11, (float)4.5, 999, "Máy tính bảng iPad Pro 11 inch Wifi Cellular 128GB (2020)", 25190000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_laptoplenovoideapad);
        listImg.add(R.drawable.img_laptoplenovoideapad_1);
        listImg.add(R.drawable.img_laptoplenovoideapad_2);
        listImg.add(R.drawable.img_laptoplenovoideapad_3);
        listImg.add(R.drawable.img_laptoplenovoideapad_4);
        productList.add(new Product(R.drawable.img_laptoplenovoideapad, (float)4.5, 99, "Laptop Lenovo IdeaPad Gaming 3 15IMH05 i7 10750H/8GB/512GB/4GB GTX1650/Win10 (81Y40068VN)", 23990000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_tuixachlouisvuitton);
        listImg.add(R.drawable.img_tuixachlouisvuitton_1);
        listImg.add(R.drawable.img_tuixachlouisvuitton_2);
        listImg.add(R.drawable.img_tuixachlouisvuitton_3);
        listImg.add(R.drawable.img_tuixachlouisvuitton_4);
        listImg.add(R.drawable.img_tuixachlouisvuitton_5);
        productList.add(new Product(R.drawable.img_tuixachlouisvuitton, (float) 5, 99, "Túi Xách Louis Vuitton Cluny BB Monogram", 55000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_galaxyzfold2);
        listImg.add(R.drawable.img_galaxyzfold2_1);
        listImg.add(R.drawable.img_galaxyzfold2_2);
        listImg.add(R.drawable.img_galaxyzfold2_3);
        listImg.add(R.drawable.img_galaxyzfold2_4);
        listImg.add(R.drawable.img_galaxyzfold2_5);
        listImg.add(R.drawable.img_galaxyzfold2_6);
        listImg.add(R.drawable.img_galaxyzfold2_7);
        productList.add(new Product(R.drawable.img_galaxyzfold2, (float) 4.5, 9, "Điện thoại Samsung Galaxy Z Fold2 5G", 50000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_cameragopro9);
        listImg.add(R.drawable.img_cameragopro9_1);
        listImg.add(R.drawable.img_cameragopro9_2);
        listImg.add(R.drawable.img_cameragopro9_3);
        listImg.add(R.drawable.img_cameragopro9_4);
        productList.add(new Product(R.drawable.img_cameragopro9, (float) 5, 99, "Camera hành trình Gopro Hero 9", 10590000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_keyboardipad);
        listImg.add(R.drawable.img_keyboardipad_1);
        listImg.add(R.drawable.img_keyboardipad_2);
        listImg.add(R.drawable.img_keyboardipad_3);
        listImg.add(R.drawable.img_keyboardipad_4);
        productList.add(new Product(R.drawable.img_keyboardipad, (float) 5, 99, "Bàn phím Magic Keyboard cho iPad Pro 12.9 inch 2020 chính hãng", 9500000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_nuochoaunisexroja);
        listImg.add(R.drawable.img_nuochoaunisexroja_1);
        productList.add(new Product(R.drawable.img_nuochoaunisexroja, (float) 5, 99, "Nước Hoa Unisex Roja Dove Parfum De La Nuit No 3 100ml", 25000000, listImg));

        listImg = new ArrayList<>();
        listImg.add(R.drawable.img_nuochoaunisextomford);
        listImg.add(R.drawable.img_nuochoaunisextomford_1);
        listImg.add(R.drawable.img_nuochoaunisextomford_2);
        productList.add(new Product(R.drawable.img_nuochoaunisextomford, (float) 5, 99, "Nước Hoa Unisex Tom Ford Noir De Noir EDP, 100ml", 7429000, listImg));

    }
}