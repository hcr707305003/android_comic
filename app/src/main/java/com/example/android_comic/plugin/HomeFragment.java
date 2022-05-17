package com.example.android_comic.plugin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.android_comic.R;
import com.example.android_comic.plugin.banner.BannerAdapter;
import com.example.android_comic.plugin.banner.BannerPageSnapHelper;
import com.example.android_comic.plugin.banner.BannerSetting;
import com.example.android_comic.plugin.banner.BannerView;
import com.example.android_comic.plugin.banner.ScaleBannerLayoutManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * create by shiroi on 2022/5/16 0016
 */
public class HomeFragment extends Fragment {
    BannerView bannerView;
    BannerAdapter adapter;
    View rootView;

    private List<String> data = new ArrayList<>();
    private List<String> data1 = Arrays.asList("https://www.wanandroid.com/blogimgs/fa822a30-00fc-4e0d-a51a-d704af48205c.jpeg",
            "https://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png",
            "https://www.wanandroid.com/blogimgs/90c6cc12-742e-4c9f-b318-b912f163b8d0.png",
            "https://www.wanandroid.com/blogimgs/90c6cc12-742e-4c9f-b318-b912f163b8d0.png",
            "https://www.wanandroid.com/blogimgs/fa822a30-00fc-4e0d-a51a-d704af48205c.jpeg");

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.home_tab_fragment, container, false);
        }
        initData();
        initDataSource();
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void initData() {
        adapter = new BannerAdapter(data, rootView.getContext());
        bannerView = rootView.findViewById(R.id.banner_view);
        BannerSetting setting = new BannerSetting().setAutoSlideSpeed(0)
                .setCanAutoSlide(true)// 是否自动滑动
                .setCanSlideByTouch(true)// 是否滑动点击
                .setLoop(true)// 是否循环滑动
                .setAutoSlideSpeed(800)// 自动滑动一次的速度
                .setSlideTimeGap(2000);// 自动滑动的时间间隔
        bannerView.setLayoutManager(new ScaleBannerLayoutManager());
        bannerView.setSnapHelper(new BannerPageSnapHelper());
        bannerView.setUp(setting, adapter);
    }

    private void initDataSource() {
        data.clear();
        data.addAll(data1);
        adapter.notifyDataSetChanged();
    }
}
