package com.example.voicerecognition_app;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter_4 extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> itext = new ArrayList<String>();

    public MyPagerAdapter_4(FragmentManager fm){
        super(fm);
        items = new ArrayList<Fragment>();
        items.add(new Fragment_4());
        items.add(new order_Fragment());

        itext.add("스무디");
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
