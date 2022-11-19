package com.example.voicerecognition_app;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import com.google.android.material.tabs.TabLayout;

public class menu_tab_3 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_menu_tab_3);
        setTitle("주문");

        ViewPager vp = findViewById(R.id.viewpager);
        MyPagerAdapter_3 adapter = new MyPagerAdapter_3(getSupportFragmentManager()); // 뷰페이지
        vp.setAdapter(adapter);

        // 연동
        TabLayout tab = findViewById(R.id.tab_3);
        tab.setupWithViewPager(vp);
    }
}


