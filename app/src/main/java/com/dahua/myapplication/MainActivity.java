package com.dahua.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.youngkaaa.yviewpager.YViewPager;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tab)
    VerticalTabLayout tabLayout;
    @BindView(R.id.view_pager)
    YViewPager viewPager;
    List<String> tabList=new ArrayList<>();
    ArrayList<Fragment> listFragment = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tabList.add("哈哈");
        tabList.add("嘻嘻");
        tabList.add("蒙面哥");
        for (int i = 0; i < tabList.size(); i++) {
            tabLayout.addTab(new QTabView(this).setTitle(
                    new QTabView.TabTitle.Builder().setContent(tabList.get(i)).build()));
        }

        listFragment.clear();
        for (int i = 0; i < tabList.size(); i++) {
            listFragment.add(SportsFragment.getInstance(tabList.get(i)));
        }

        ItemFragmentAdapter  itemFragmentAdapter = new ItemFragmentAdapter(getSupportFragmentManager(), listFragment);
        viewPager.setAdapter(itemFragmentAdapter);
        tabLayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                if (viewPager != null)
                    viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                tabLayout.setTabSelected(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });



    }
    class ItemFragmentAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> list;

        public ItemFragmentAdapter(FragmentManager fm, ArrayList<Fragment> list) {
            super(fm);
            this.list = list;
        }


        @Override
        public Fragment getItem(int i) {
            return list.get(i);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
