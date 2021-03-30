package com.example.ecngv2.View.Favorite;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecngv2.Adapter.RCV_FavProduct_Adapter;
import com.example.ecngv2.Model.Object.FavProduct;
import com.example.ecngv2.R;

import java.util.ArrayList;
import java.util.List;

public class FavProductFragment extends Fragment {

    public FavProductFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    List<FavProduct> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fav_product, container, false);
        init(v);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(new RCV_FavProduct_Adapter(getContext(), list));
        return v;
    }

    private void init(View v) {
        recyclerView = v.findViewById(R.id.rcv);

        list = new ArrayList<>();
        list.add(new FavProduct(R.drawable.laptop1, "Jack gộp audio và mic 3.5mm | Jack gộpJack go audio và mic3 tai nghe 3.5 (Trắng)", 20000000, "apple_long_butterfly", R.drawable.avatar_user));
        list.add(new FavProduct(R.drawable.laptop2, "Jack gộp audio và mic 3.5mm | Jack gộpJack go audio và mic3 tai nghe 3.5 (Trắng)", 20000000, "apple_long_butterfly", R.drawable.avatar_user));
        list.add(new FavProduct(R.drawable.laptop3, "Jack gộp audio và mic 3.5mm | Jack gộpJack go audio và mic3 tai nghe 3.5 (Trắng)", 20000000, "apple_long_butterfly", R.drawable.avatar_user));
        list.add(new FavProduct(R.drawable.laptop4, "Jack gộp audio và mic 3.5mm | Jack gộpJack go audio và mic3 tai nghe 3.5 (Trắng)", 20000000, "apple_long_butterfly", R.drawable.avatar_user));
        list.add(new FavProduct(R.drawable.laptop5, "Jack gộp audio và mic 3.5mm | Jack gộpJack go audio và mic3 tai nghe 3.5 (Trắng)", 20000000, "apple_long_butterfly", R.drawable.avatar_user));
        list.add(new FavProduct(R.drawable.laptop6, "Jack gộp audio và mic 3.5mm | Jack gộpJack go audio và mic3 tai nghe 3.5 (Trắng)", 20000000, "apple_long_butterfly", R.drawable.avatar_user));

    }
}