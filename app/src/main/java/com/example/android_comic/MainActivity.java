package com.example.android_comic;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.android_comic.plugin.NewComicFragment;
import com.example.android_comic.plugin.PalgantongFragment;
import com.example.android_comic.plugin.ProjectFragment;
import com.example.android_comic.plugin.tab.FragmentPagerAdapter;
import com.example.android_comic.plugin.HomeFragment;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager2 viewPager;
    LinearLayout home,newComic,palgantong,project;
    TextView text_home,text_newComic,text_palgantong,text_project,text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initPager();
        initTabView();
    }

    private void initTabView() {
        home = findViewById(R.id.home);
        home.setOnClickListener(this);
        newComic = findViewById(R.id.newComic);
        newComic.setOnClickListener(this);
        palgantong = findViewById(R.id.palgantong);
        palgantong.setOnClickListener(this);
        project = findViewById(R.id.project);
        project.setOnClickListener(this);

        text_home = findViewById(R.id.text_home);
        text_newComic = findViewById(R.id.text_newComic);
        text_palgantong = findViewById(R.id.text_palgantong);
        text_project = findViewById(R.id.text_project);

        text_home.setTextColor(Color.parseColor("#ff5e9cff"));
        text = text_home;
    }

    private void initPager() {
        viewPager = findViewById(R.id.id_viewpager);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance());
        fragments.add(NewComicFragment.newInstance());
        fragments.add(PalgantongFragment.newInstance());
        fragments.add(ProjectFragment.newInstance());
        FragmentPagerAdapter pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        viewPager.setAdapter(pagerAdapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void changeTab(int position) {
        text.setTextColor(Color.GRAY);
        switch (position) {
            case R.id.home:
                viewPager.setCurrentItem(0);
            case 0:
                text_home.setTextColor(Color.parseColor("#ff5e9cff"));
                text = text_home;
                break;
            case R.id.newComic:
                viewPager.setCurrentItem(1);
            case 1:
                text_newComic.setTextColor(Color.parseColor("#ff5e9cff"));
                text = text_newComic;
                break;
            case R.id.palgantong:
                viewPager.setCurrentItem(2);
            case 2:
                text_palgantong.setTextColor(Color.parseColor("#ff5e9cff"));
                text = text_palgantong;
                break;
            case R.id.project:
                viewPager.setCurrentItem(3);
            case 3:
                text_project.setTextColor(Color.parseColor("#ff5e9cff"));
                text = text_project;
                break;
        }
    }

    @Override
    public void onClick(View view) {
        changeTab(view.getId());
    }
}