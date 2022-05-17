package com.example.android_comic.plugin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android_comic.R;

/**
 * create by shiroi on 2022/5/16 0016
 */
public class NewComicFragment extends Fragment {

    View rootView;

    public static NewComicFragment newInstance() {
        return new NewComicFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.new_comic_tab_fragment, container, false);
        }
        return rootView;
    }
}
