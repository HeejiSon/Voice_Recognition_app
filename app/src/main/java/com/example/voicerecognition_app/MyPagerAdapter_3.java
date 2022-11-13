package com.example.voicerecognition_app;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter_3 extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> itext = new ArrayList<String>();

    public MyPagerAdapter_3(FragmentManager fm){
        super(fm);
        items = new ArrayList<Fragment>();
        items.add(new Fragment_3());
        items.add(new order_Fragment());

        itext.add("에이드");
        itext.add("주문");
    }


    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }


    @Override
    public int getCount() {
        return items.size();
    }


    @Override
    public CharSequence getPageTitle(int position){
        return itext.get(position);
    }
}
