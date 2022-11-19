package com.example.voicerecognition_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> itext = new ArrayList<String>();

    public MyPagerAdapter(FragmentManager fm){
        super(fm);
        items = new ArrayList<Fragment>();
        items.add(new Fragment_1());
        items.add(new order_Fragment());

        itext.add("커피");
        itext.add("메뉴주문");

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
