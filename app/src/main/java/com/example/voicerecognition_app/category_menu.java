package com.example.voicerecognition_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class category_menu extends AppCompatActivity {

    Button coffee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_menu);
        setTitle("카테고리");

        //로그인 버튼
        coffee = findViewById(R.id.coffee_btn);

        coffee.setOnClickListener( v -> {
            Intent intent1 = new Intent(this, tab_1.class);
            startActivity(intent1);
        });
    }
}