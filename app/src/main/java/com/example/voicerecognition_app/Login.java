package com.example.voicerecognition_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText id, pw;
    TextView sign;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("로그인");

        //로그인 버튼
        login = findViewById(R.id.loginbutton);
        id = findViewById(R.id.editID);
        pw = findViewById(R.id.editPassword);

       // DB 값 받아오기 해야함
        
       login.setOnClickListener( v -> {
           if(id.getText().toString().equals("user")) {
               if (pw.getText().toString().equals("1234")) {
                   Toast.makeText(this, "로그인 성공", Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(this, category_menu.class);
                startActivity(intent1);
               }else {
                   Toast.makeText(this, "아이디 또는 비밀번호가 틀렸습니다.", Toast.LENGTH_LONG).show();
               }
           }else{
               Toast.makeText(this, "아이디 또는 비밀번호가 틀렸습니다.", Toast.LENGTH_LONG).show();
           }
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