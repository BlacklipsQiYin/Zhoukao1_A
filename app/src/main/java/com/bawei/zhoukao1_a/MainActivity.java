package com.bawei.zhoukao1_a;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> pageList;
    private List<Fragment> fList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);


        pageList = new ArrayList<String>();

        pageList.add("推荐");
        pageList.add("热点");
        pageList.add("国际");
        pageList.add("时尚");
        pageList.add("科技");
        pageList.add("汽车");
        pageList.add("交通");
        pageList.add("娱乐");
        pageList.add("军事");
        pageList.add("生活");


        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        tabLayout.addTab(tabLayout.newTab().setText(pageList.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(pageList.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(pageList.get(2)));
        tabLayout.addTab(tabLayout.newTab().setText(pageList.get(3)));
        tabLayout.addTab(tabLayout.newTab().setText(pageList.get(4)));
        tabLayout.addTab(tabLayout.newTab().setText(pageList.get(5)));
        tabLayout.addTab(tabLayout.newTab().setText(pageList.get(6)));
        tabLayout.addTab(tabLayout.newTab().setText(pageList.get(7)));
        tabLayout.addTab(tabLayout.newTab().setText(pageList.get(8)));
        tabLayout.addTab(tabLayout.newTab().setText(pageList.get(9)));

        tabLayout.setTabTextColors(Color.BLACK, Color.RED);


        fList = new ArrayList<Fragment>();
        fList.add(new Fragment1());
        fList.add(new Fragment2());


        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Bundle b = new Bundle();
                b.putString("page", pageList.get(position));

                return fList.get(position);
            }

            @Override
            public int getCount() {
                return fList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return pageList.get(position);
            }


        });

        //TabLayout加载viewpager
        tabLayout.setupWithViewPager(viewPager);



    }
}
