package com.example.voicerecognition_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class category_menu extends AppCompatActivity {

    Button coffee, latte, ade, smoothie, tea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_menu);
        setTitle("카테고리");

        //커피 버튼
        coffee = findViewById(R.id.coffee_btn);

        coffee.setOnClickListener( v -> {
            Intent intent1 = new Intent(this, tab_1.class);
            startActivity(intent1);
        });

        //라떼 버튼
        latte = findViewById(R.id.latte_btn);

        latte.setOnClickListener( v -> {
            Intent intent2 = new Intent(this, tab_2.class);
            startActivity(intent2);
        });

        //에이드 버튼
        ade = findViewById(R.id.ade_btn);

        ade.setOnClickListener( v -> {
            Intent intent3 = new Intent(this, tab_3.class);
            startActivity(intent3);
        });

        //스무디 버튼
        smoothie = findViewById(R.id.smoothie_btn);

        smoothie.setOnClickListener( v -> {
            Intent intent4 = new Intent(this, tab_4.class);
            startActivity(intent4);
        });

        //차 버튼
        tea = findViewById(R.id.tea_btn);

        tea.setOnClickListener( v -> {
            Intent intent5 = new Intent(this, tab_5.class);
            startActivity(intent5);
        });
    }
}