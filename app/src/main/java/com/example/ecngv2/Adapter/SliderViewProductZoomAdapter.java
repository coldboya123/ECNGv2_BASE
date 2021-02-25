package com.example.ecngv2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.example.ecngv2.R;
import com.example.ecngv2.View.Product.ProductImage;

import java.io.Serializable;
import java.util.List;

public class SliderViewProductZoomAdapter extends com.smarteist.autoimageslider.SliderViewAdapter<SliderViewProductZoomAdapter.SliderAdapterVH> {

    private Context context;
    private List<Integer> mSliderItems;

    public SliderViewProductZoomAdapter(Context context, List<Integer> mSliderItems) {
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
    public SliderViewProductZoomAdapter.SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.image_slider_zoom_layout_item, null);
        return new SliderViewProductZoomAdapter.SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderViewProductZoomAdapter.SliderAdapterVH viewHolder, final int position) {

        int sliderItem = mSliderItems.get(position);

        viewHolder.imageViewBackground.setImage(ImageSource.resource(sliderItem));
//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
//                Intent i = new Intent(context, ProductImage.class);
//                i.putExtra("list", (Serializable) mSliderItems);
//                i.putExtra("position", position);
//                context.startActivity(i);
//            }
//        });
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mSliderItems.size();
    }

    class SliderAdapterVH extends com.smarteist.autoimageslider.SliderViewAdapter.ViewHolder {

        View itemView;
        SubsamplingScaleImageView imageViewBackground;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.product_image_zoom);
            this.itemView = itemView;
        }
    }
}