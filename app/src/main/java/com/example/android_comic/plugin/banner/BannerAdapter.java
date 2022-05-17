package com.example.android_comic.plugin.banner;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android_comic.R;

import java.util.List;
import java.util.Random;

/**
 * create by shiroi on 2022/5/15 0015
 */
public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder>{
    private List<String> data;

    private Context context;

    private Random random = new Random();

    private float itemWidth = 0.88f;
    private float ratio = 0.5f;  // 宽高比

    private DisplayMetrics displayMetrics;

    public BannerAdapter(List<String> data, Context context) {
        super();
        this.data = data;
        this.context = context;
        displayMetrics = context.getResources().getDisplayMetrics();
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_banner_item, parent, false);
        final BannerViewHolder holder = new BannerViewHolder(view);

        //点击banner图片跳转
        holder.bannerImage.setOnClickListener(v -> {
            Log.e("test",data.get(holder.getAdapterPosition()));
            Toast.makeText(context, "onclick21212 :" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final BannerViewHolder holder, final int position) {
        ViewGroup.LayoutParams layoutParams = holder.bannerImage.getLayoutParams();
        layoutParams.width = (int) (displayMetrics.widthPixels * itemWidth);
        Glide.with(context)
                .load(data.get(position))
                .into(holder.bannerImage);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView bannerImage;

        public BannerViewHolder(View itemView) {
            super(itemView);
            bannerImage = itemView.findViewById(R.id.banner_image);
        }

    }

    public float getItemWidth() {
        return itemWidth;
    }

    public void setItemWidth(float itemWidth) {
        this.itemWidth = itemWidth;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }
}
