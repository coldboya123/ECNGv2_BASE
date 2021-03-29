package com.example.ecngv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ecngv2.R;

import java.util.List;

public class SliderViewHomeAdapter extends com.smarteist.autoimageslider.SliderViewAdapter<SliderViewHomeAdapter.SliderAdapterVH> {

    private Context context;
    private List<Integer> mSliderItems;

    public SliderViewHomeAdapter(Context context, List<Integer> mSliderItems) {
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
    public SliderViewHomeAdapter.SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderViewHomeAdapter.SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderViewHomeAdapter.SliderAdapterVH viewHolder, final int position) {

        int sliderItem = mSliderItems.get(position);

        viewHolder.imageViewBackground.setImageResource(sliderItem);
        viewHolder.imageViewBackground.setBackground(context.getDrawable(R.drawable.radius5));
        viewHolder.imageViewBackground.setClipToOutline(true);
        viewHolder.itemView.setOnClickListener(v -> {
//                Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
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
        ImageView imageGifContainer;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
//            imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
            this.itemView = itemView;
        }
    }
}
