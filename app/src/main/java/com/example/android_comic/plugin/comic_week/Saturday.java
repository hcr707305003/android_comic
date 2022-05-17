package com.example.android_comic.plugin.comic_week;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android_comic.R;

/**
 * create by shiroi on 2022/5/17 0017
 */
public class Saturday extends Fragment {
    View rootView;
    public static Saturday newInstance() {
        return new Saturday();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.saturday, container, false);
        }
        return rootView;
    }
}
