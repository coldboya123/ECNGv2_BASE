package com.example.ecngv2.View.Favorite;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.example.ecngv2.R;
import com.example.ecngv2.customListview;

import java.util.ArrayList;
import java.util.List;


public class FavoriteFragment extends Fragment {

    public FavoriteFragment() {
        // Required empty public constructor
    }
    customListview listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_favorite, container, false);
        SubsamplingScaleImageView img = v.findViewById(R.id.fav_image);
        img.setImage(ImageSource.resource(R.drawable.dienthoai1));
        return v;
    }
}