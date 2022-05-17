package com.example.android_comic.plugin.comic_week;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_comic.R;
import com.example.android_comic.plugin.Bean.ComicWeekBean;
import com.example.android_comic.plugin.tab.ComicWeekAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * create by shiroi on 2022/5/17 0017
 */
public class Monday extends Fragment {
    View rootView;
    public static Monday newInstance() {
        return new Monday();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.monday, container, false);
        }
        return rootView;
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//
//        RecyclerView recyclerView = rootView.findViewById(R.id.rv);
//
//        List<ComicWeekBean> data1 = new ArrayList<>();
//        for (int i = 950; i < 2000; i++) {
//            ComicWeekBean bean = new ComicWeekBean();
//            bean.setName("shiroi" + i);
//            data1.add(bean);
//        }
//
//        //第一种
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rootView.getContext());
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//        ComicWeekAdapter comicWeekAdapter = new ComicWeekAdapter(data1,rootView.getContext());
//        recyclerView.setAdapter(comicWeekAdapter);
//        comicWeekAdapter.setOnRecyclerItemClickLister(new ComicWeekAdapter.OnRecyclerItemClickLister() {
//            @Override
//            public void onRecyclerItemClick(int position) {
//                Log.e("事件","onRecycler"+position);
//            }
//        });
//    }
}
