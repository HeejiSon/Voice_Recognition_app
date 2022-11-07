package com.example.voicerecognition_app;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class menu_tab_2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_menu_tab_2);
        setTitle("메뉴 주문");

        ViewPager vp = findViewById(R.id.viewpager);
        MyPagerAdapter_2 adapter = new MyPagerAdapter_2(getSupportFragmentManager()); // 뷰페이지
        vp.setAdapter(adapter);

        // 연동
        TabLayout tab = findViewById(R.id.tab_2);
        tab.setupWithViewPager(vp);
    }


}
