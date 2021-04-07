package com.example.ecngv2.View.Address;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecngv2.Adapter.RCV_AddressChooseCity_Adapter;
import com.example.ecngv2.Adapter.RCV_AddressChooseDistrict_Adapter;
import com.example.ecngv2.Adapter.RCV_AddressChooseWard_Adapter;
import com.example.ecngv2.Model.Object.City;
import com.example.ecngv2.Model.Object.District;
import com.example.ecngv2.Model.Object.Ward;
import com.example.ecngv2.Model.User.Address.ModelAddress;
import com.example.ecngv2.R;
import com.example.ecngv2.View.MainActivity.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class AddUserAddressActivity extends AppCompatActivity implements View.OnClickListener, IAddUserAddress {

    Button btn_back;
    List<City> listCity = new ArrayList<>();
    ModelAddress modelAddress = new ModelAddress();
    List<District> listDistrict = new ArrayList<>();
    List<Ward> listWard = new ArrayList<>();
    AutoCompleteTextView txtCity;
    AppCompatButton btn_save;
    AlertDialog dialog;
    SearchView searchView;
    RecyclerView recyclerView;
    TextView titleCity, titleDistrict, titleWard;
    String address = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_address);

        Window window = getWindow();
        @SuppressLint("UseCompatLoadingForDrawables") Drawable background = getDrawable(R.drawable.appbar_background);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(android.R.color.transparent));
//        window.setNavigationBarColor(getColor(android.R.color.transparent));
        window.setBackgroundDrawable(background);

        init();

        List<String> arrCity = new ArrayList<>();
        listCity = modelAddress.getCity("https://vapi.vnappmob.com/api/province/");
        for (int i = 0; i < listCity.size(); i++) {
            arrCity.add(listCity.get(i).getName());
        }

        txtCity.setRawInputType(InputType.TYPE_NULL);
        txtCity.setFocusable(true);
        txtCity.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        btn_save.setOnClickListener(this);
    }

    private void init() {
        btn_back = findViewById(R.id.user_address_add_btn_back);
        txtCity = findViewById(R.id.user_address_edit_txtcity);
        btn_save = findViewById(R.id.user_address_edit_btn_save);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_address_add_btn_back:
            case R.id.user_address_edit_btn_save:
                finish();
                break;
            case R.id.user_address_edit_txtcity:
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
                View layoutView = getLayoutInflater().inflate(R.layout.dialog_choose_address, null);
                dialogBuilder.setView(layoutView);
                dialog = dialogBuilder.create();
                searchView = layoutView.findViewById(R.id.search);
                recyclerView = layoutView.findViewById(R.id.rcv);
                titleCity = layoutView.findViewById(R.id.city);
                titleDistrict = layoutView.findViewById(R.id.district);
                titleWard = layoutView.findViewById(R.id.ward);

                recyclerView.getLayoutParams().height = MainActivity.DEVICE_HEIGHT_PX / 2;
                LinearLayout linearLayout1 = (LinearLayout) searchView.getChildAt(0);
                LinearLayout linearLayout2 = (LinearLayout) linearLayout1.getChildAt(2);
                LinearLayout linearLayout3 = (LinearLayout) linearLayout2.getChildAt(1);
                AutoCompleteTextView autoComplete = (AutoCompleteTextView) linearLayout3.getChildAt(0);
                autoComplete.setTextSize(15);
                searchView.setOnClickListener(v1 -> {
                    searchView.setIconified(false);
                });
                listCity = modelAddress.getCity("https://vapi.vnappmob.com/api/province/");
                recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
                RCV_AddressChooseCity_Adapter adapter = new RCV_AddressChooseCity_Adapter(this, listCity, this);
                recyclerView.setAdapter(adapter);

                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        newText = newText.toLowerCase();
                        List<City> newCityList = new ArrayList<>();
                        for (City city : listCity) {
                            String checkcity = city.getName().toLowerCase();
                            if (checkcity.contains(newText)) {
                                newCityList.add(city);
                            }
                        }
                        adapter.setFilter(newCityList);
                        return true;
                    }
                });
                dialog.show();
                break;
        }
    }

    @Override
    public void OnSelectedCity(City city) {
        address = "";
        address += city.getName() + ", ";
        titleCity.setText(city.getName() + " > ");
        titleDistrict.setVisibility(View.VISIBLE);
        listDistrict = modelAddress.getDistrict("https://vapi.vnappmob.com/api/province/district/" + city.getId());
        RCV_AddressChooseDistrict_Adapter adapter = new RCV_AddressChooseDistrict_Adapter(this, listDistrict, this);
        recyclerView.setAdapter(adapter);
        searchView.setQuery("", false);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                List<District> newDistrictList = new ArrayList<>();
                for (District district : listDistrict) {
                    String checkDistrict = district.getName().toLowerCase();
                    if (checkDistrict.contains(newText)) {
                        newDistrictList.add(district);
                    }
                }
                adapter.setFilter(newDistrictList);
                return true;
            }
        });
    }

    @Override
    public void OnSelectedDistrict(District district) {
        address += district.getName() + ", ";
        titleDistrict.setText(district.getName() + " > ");
        titleWard.setVisibility(View.VISIBLE);
        listWard = modelAddress.getWard("https://vapi.vnappmob.com/api/province/ward/" + district.getId());
        RCV_AddressChooseWard_Adapter adapter = new RCV_AddressChooseWard_Adapter(this, listWard, this);
        recyclerView.setAdapter(adapter);
        searchView.setQuery("", false);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                List<Ward> newWardList = new ArrayList<>();
                for (Ward ward : listWard) {
                    String checkWard = ward.getName().toLowerCase();
                    if (checkWard.contains(newText)) {
                        newWardList.add(ward);
                    }
                }
                adapter.setFilter(newWardList);
                return true;
            }
        });
    }

    @Override
    public void OnSelectedWard(Ward ward) {
        address += ward.getName();
        titleDistrict.setText(ward.getName());
        dialog.hide();
        txtCity.setText(address, false);
    }
}