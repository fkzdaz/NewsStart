package com.example.fkz2.newsstart.activity;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fkz2.newsstart.R;
import com.example.fkz2.newsstart.fragment.Tab_Fragment_1;
import com.example.fkz2.newsstart.fragment.Tab_Fragment_2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String TAG = getClass().getSimpleName();
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<Fragment> fragmentsList;//fragment容器
    private List<String> titleList;//标签容器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();//加载
    }

    private void load() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        fragmentsList = new ArrayList<>();
        titleList = new ArrayList<>();

        fragmentsList.add(new Tab_Fragment_1());
        fragmentsList.add(new Tab_Fragment_2());//将fragment添加到fragmentList的list容器里
        for (int i = 0; i < 3; i++) {
            fragmentsList.add(new Tab_Fragment_1());
        }
        titleList.add("新闻");
        titleList.add("笑话");
        titleList.add("段子");
        titleList.add("视频");
        titleList.add("图片");

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);//tab的模式如果标签多的话用MODE_SCROLLABLE  少的话用MODE_FIXED
        //tabLayout.setBackgroundColor(Color.BLUE);

        FragViewAdapter adapter = new FragViewAdapter(getSupportFragmentManager(), fragmentsList, titleList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(adapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getText().equals("新闻")) {
                    Toast.makeText(getApplicationContext(), "滑动或点击了新闻", Toast.LENGTH_SHORT).show();
                }
                if (tab.getPosition() == 1) {
                    Toast.makeText(getApplicationContext(), "滑动或点击了笑话", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.isSelected()) {
                    Toast.makeText(getApplicationContext(), "切换了Pager", Toast.LENGTH_SHORT).show();
                }
                Log.i(TAG, "tab.getTag()" + tab.getTag());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    /**
     * 创建适配器，主要是为了fragmet与标题进行匹配的 继承FragmentPagerAdapter
     */
    class FragViewAdapter extends FragmentPagerAdapter {
        List<Fragment> fragmentList_;
        List<String> titleList_;

        public FragViewAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titleList) {
            super(fm);
            fragmentList_ = fragmentList;
            titleList_ = titleList;
        }

        @Override//fragment匹配
        public Fragment getItem(int position) {
            Log.i(TAG, "getItem  " + fragmentList_.get(position));
            return fragmentList_.get(position);
        }

        @Override//获取fragment的数量
        public int getCount() {
            return titleList_.size();
        }

        @Override//对标题进行匹配
        public CharSequence getPageTitle(int position) {
            Log.i(TAG, "getPageTitle  " + titleList_.get(position));
            return titleList_.get(position);
        }

        @Override//销毁 不知道这样做行不行
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
            fragmentList_.get(position).onDestroy();
        }
    }
}
