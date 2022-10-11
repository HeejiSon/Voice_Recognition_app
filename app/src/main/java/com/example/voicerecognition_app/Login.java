package com.example.voicerecognition_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    TextView sign;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("로그인");

        //로그인 버튼
       login = findViewById(R.id.loginbutton);

       // DB 값 받아오기 해야함
        
       login.setOnClickListener( v -> {
            Intent intent1 = new Intent(this, category_menu.class);
            startActivity(intent1);
        });
       

        //회원가입 버튼
        sign = findViewById(R.id.signin);

        //회원가입 버튼 클릭시, 회원가입 페이지로 이동
        sign.setOnClickListener(v -> {
            Intent intent2 = new Intent(this, Signup.class);
            startActivity(intent2);
        });
    }
}