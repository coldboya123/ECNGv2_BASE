package com.example.ecngv2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

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
        listView = v.findViewById(R.id.fav_listview);
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<20; i++){
            list.add(i);
        }
        Adapter adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter((ListAdapter) adapter);
        return v;
    }
}