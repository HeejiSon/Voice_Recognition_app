package com.example.voicerecognition_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class category_menu extends AppCompatActivity implements TextToSpeech.OnInitListener{
    private TextToSpeech tts;
    private TextView input_text;
    private String coffee_text, latte_text, ade_text, smoothie_text, tea_text;
    Button coffee_btn, latte_btn, ade_btn, smoothie_btn, tea_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_menu);
        setTitle("카테고리");

        tts = new TextToSpeech(this, this);

        // 원하시는 메뉴의 카테고리를 선택해주세요
        input_text = findViewById(R.id.category);


        //커피 버튼
        //coffee_text = findViewById(R.id.category_coffee);
        coffee_text = "커피 카테고리 입니다.";
        coffee_btn = findViewById(R.id.coffee_btn);
        coffee_btn.setOnClickListener( v -> {
            CharSequence text = coffee_text;
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)0.8); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent1 = new Intent(v.getContext(), menu_tab.class);
                    startActivity(intent1);
                }
            }, 2000);


        });

        //라떼 버튼
        latte_text = "라떼 카테고리 입니다.";
        latte_btn = findViewById(R.id.latte_btn);
        latte_btn.setOnClickListener( v -> {
            CharSequence text = latte_text;
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)0.8); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent2 = new Intent(v.getContext(), menu_tab_2.class);
                    startActivity(intent2);
                }
            }, 2000);
        });

        //에이드 버튼
        ade_text = "에이드 카테고리 입니다.";
        ade_btn = findViewById(R.id.ade_btn);
        ade_btn.setOnClickListener( v -> {
            CharSequence text = ade_text;
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)0.8); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent3 = new Intent(v.getContext(), menu_tab_3.class);
                    startActivity(intent3);
                }
            }, 2000);

        });

        //스무디 버튼
        smoothie_text = "스무디 카테고리 입니다.";
        smoothie_btn = findViewById(R.id.smoothie_btn);
        smoothie_btn.setOnClickListener( v -> {
            CharSequence text = smoothie_text;
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)0.8); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent4 = new Intent(v.getContext(), menu_tab_4.class);
                    startActivity(intent4);
                }
            }, 2000);
        });

        //차 버튼
        tea_text = "차 카테고리 입니다.";
        tea_btn = findViewById(R.id.tea_btn);
        tea_btn.setOnClickListener( v -> {
            CharSequence text = tea_text;
            tts.setPitch((float)0.8); // 음성 톤 높이 지정
            tts.setSpeechRate((float)0.8); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent5 = new Intent(v.getContext(), menu_tab_5.class);
                    startActivity(intent5);
                }
            }, 2000);
        });
    }

    private void speakOut(){
        CharSequence text = input_text.getText();
        tts.setPitch((float)0.6); // 음성 톤 높이 지정
        tts.setSpeechRate((float)1.0); // 음성 속도 지정

        // 첫 번째 매개변수: 음성 출력을 할 텍스트
        // 두 번째 매개변수: 1. TextToSpeech.QUEUE_FLUSH - 진행중인 음성 출력을 끊고 이번 TTS의 음성 출력
        //                 2. TextToSpeech.QUEUE_ADD - 진행중인 음성 출력이 끝난 후에 이번 TTS의 음성 출력
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onInit(int status) { // OnInitListener를 통해서 TTS 초기화
        if(status == TextToSpeech.SUCCESS){
            int result = tts.setLanguage(Locale.KOREA); // TTS언어 한국어로 설정

            if(result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA){
                Log.e("TTS", "This Language is not supported");
            }else{
                speakOut();// onInit에 음성출력할 텍스트를 넣어줌
            }
        }else{
            Log.e("TTS", "Initialization Failed!");
        }
    }
}