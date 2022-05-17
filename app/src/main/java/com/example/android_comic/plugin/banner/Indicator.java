package com.example.android_comic.plugin.banner;

/**
 * create by shiroi on 2022/5/15 0015
 */
public interface Indicator {
    void onViewSelected(int position);
    void onScrolled(int dx,Float ratio);
}
