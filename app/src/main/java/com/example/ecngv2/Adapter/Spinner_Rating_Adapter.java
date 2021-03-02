package com.example.ecngv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.ecngv2.R;

public class Spinner_Rating_Adapter extends BaseAdapter {
    Context context;
    int res;

    public Spinner_Rating_Adapter(Context context, int res) {
        this.context = context;
        this.res = res;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(res, parent, false);
        TextView txt = convertView.findViewById(R.id.rating_spinner_txt);
        RatingBar ratingBar = convertView.findViewById(R.id.rating_spinner_rating);

        if (position == 0){
            txt.setText("Đánh giá");
            txt.setCompoundDrawables(null, null, null, null);
            ratingBar.setVisibility(View.GONE);
        }else {
//            txt.setText("+");
            ratingBar.setRating(6 - position);
        }
        return convertView;
    }
}
