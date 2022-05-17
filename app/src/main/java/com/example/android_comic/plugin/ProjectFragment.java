package com.example.android_comic.plugin;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.example.android_comic.R;
import com.example.android_comic.plugin.comic_week.Friday;
import com.example.android_comic.plugin.comic_week.Monday;
import com.example.android_comic.plugin.comic_week.Saturday;
import com.example.android_comic.plugin.comic_week.Sunday;
import com.example.android_comic.plugin.comic_week.Thursday;
import com.example.android_comic.plugin.comic_week.Tuesday;
import com.example.android_comic.plugin.comic_week.Wednesday;
import com.example.android_comic.plugin.tab.FragmentPagerAdapter;
import java.util.ArrayList;
import butterknife.ButterKnife;

/**
 * create by shiroi on 2022/5/16 0016
 */
public class ProjectFragment extends Fragment implements View.OnClickListener {

    View rootView;
    ViewPager2 comicWeekViewPager;
    LinearLayout monday,tuesday,wednesday,thursday,friday,saturday,sunday;
    TextView monday_text,tuesday_text,wednesday_text,thursday_text,friday_text,saturday_text,sunday_text,day_text;

    public static ProjectFragment newInstance() {
        return new ProjectFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.project_tab_fragment, container, false);
        }
        ButterKnife.bind(rootView);
        initPager();
        initTabView();
        return rootView;
    }

    @Override
    public void onClick(View view) {
        changeTab(view.getId());
    }

    private void initTabView() {
        monday = rootView.findViewById(R.id.monday);
        monday.setOnClickListener(this);
        tuesday = rootView.findViewById(R.id.tuesday);
        tuesday.setOnClickListener(this);
        wednesday = rootView.findViewById(R.id.wednesday);
        wednesday.setOnClickListener(this);
        thursday = rootView.findViewById(R.id.thursday);
        thursday.setOnClickListener(this);
        friday = rootView.findViewById(R.id.friday);
        friday.setOnClickListener(this);
        saturday = rootView.findViewById(R.id.saturday);
        saturday.setOnClickListener(this);
        sunday = rootView.findViewById(R.id.sunday);
        sunday.setOnClickListener(this);

        monday_text = rootView.findViewById(R.id.monday_text);
        tuesday_text = rootView.findViewById(R.id.tuesday_text);
        wednesday_text = rootView.findViewById(R.id.wednesday_text);
        thursday_text = rootView.findViewById(R.id.thursday_text);
        friday_text = rootView.findViewById(R.id.friday_text);
        saturday_text = rootView.findViewById(R.id.saturday_text);
        sunday_text = rootView.findViewById(R.id.sunday_text);


        monday_text.setTextColor(Color.parseColor("#ff5e9cff"));
        day_text = monday_text;
    }

    private void initPager() {
        comicWeekViewPager = rootView.findViewById(R.id.comic_view_viewpager);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(Monday.newInstance());
        fragments.add(Tuesday.newInstance());
        fragments.add(Wednesday.newInstance());
        fragments.add(Thursday.newInstance());
        fragments.add(Friday.newInstance());
        fragments.add(Saturday.newInstance());
        fragments.add(Sunday.newInstance());
        FragmentPagerAdapter pagerAdapter = new FragmentPagerAdapter(getFragmentManager(),getLifecycle(),fragments);
        comicWeekViewPager.setAdapter(pagerAdapter);
        comicWeekViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
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
        day_text.setTextColor(Color.GRAY);
        switch (position) {
            case R.id.monday:
                comicWeekViewPager.setCurrentItem(0);
            case 0:
                monday_text.setTextColor(Color.parseColor("#ff5e9cff"));
                day_text = monday_text;
                break;
            case R.id.tuesday:
                comicWeekViewPager.setCurrentItem(1);
            case 1:
                tuesday_text.setTextColor(Color.parseColor("#ff5e9cff"));
                day_text = tuesday_text;
                break;
            case R.id.wednesday:
                comicWeekViewPager.setCurrentItem(2);
            case 2:
                wednesday_text.setTextColor(Color.parseColor("#ff5e9cff"));
                day_text = wednesday_text;
                break;
            case R.id.thursday:
                comicWeekViewPager.setCurrentItem(3);
            case 3:
                thursday_text.setTextColor(Color.parseColor("#ff5e9cff"));
                day_text = thursday_text;
                break;
            case R.id.friday:
                comicWeekViewPager.setCurrentItem(4);
            case 4:
                friday_text.setTextColor(Color.parseColor("#ff5e9cff"));
                day_text = friday_text;
                break;
            case R.id.saturday:
                comicWeekViewPager.setCurrentItem(5);
            case 5:
                saturday_text.setTextColor(Color.parseColor("#ff5e9cff"));
                day_text = saturday_text;
                break;
            case R.id.sunday:
                comicWeekViewPager.setCurrentItem(6);
            case 6:
                sunday_text.setTextColor(Color.parseColor("#ff5e9cff"));
                day_text = sunday_text;
                break;
        }
    }
}
