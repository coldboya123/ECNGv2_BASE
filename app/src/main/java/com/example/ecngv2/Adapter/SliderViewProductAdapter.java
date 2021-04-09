package com.example.ecngv2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ecngv2.R;
import com.example.ecngv2.View.Product.ProductImage;

import java.io.Serializable;
import java.util.List;

public class SliderViewProductAdapter extends com.smarteist.autoimageslider.SliderViewAdapter<SliderViewProductAdapter.SliderAdapterVH> {

    private Context context;
    private List<Integer> mSliderItems;

    public SliderViewProductAdapter(Context context, List<Integer> mSliderItems) {
        this.context = context;
        this.mSliderItems = mSliderItems;
    }

    public void renewItems(List<Integer> sliderItems) {
        this.mSliderItems = sliderItems;
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        this.mSliderItems.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(int sliderItem) {
        this.mSliderItems.add(sliderItem);
        notifyDataSetChanged();
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {

        int sliderItem = mSliderItems.get(position);

        viewHolder.imageViewBackground.setImageResource(sliderItem);
        viewHolder.itemView.setOnClickListener(v -> {
            Intent i = new Intent(context, ProductImage.class);
            i.putExtra("list", (Serializable) mSliderItems);
            i.putExtra("position", position);
            context.startActivity(i);
        });
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mSliderItems.size();
    }

    class SliderAdapterVH extends com.smarteist.autoimageslider.SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
//        ImageView imageGifContainer;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
//            imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
            this.itemView = itemView;
        }
    }
}
