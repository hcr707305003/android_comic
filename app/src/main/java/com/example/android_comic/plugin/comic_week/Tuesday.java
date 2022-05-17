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
public class Tuesday extends Fragment {
    View rootView;
    public static Tuesday newInstance() {
        return new Tuesday();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.tuesday, container, false);
        }
        return rootView;
    }
}
