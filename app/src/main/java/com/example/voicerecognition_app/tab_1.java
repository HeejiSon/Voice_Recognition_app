package com.example.voicerecognition_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.TextView;

import java.util.Locale;

public class tab_1 extends AppCompatActivity implements TextToSpeech.OnInitListener{
    private TextToSpeech tts;
    private TextView input_text, c_1, c_2, c_3, c_4, c_5, c_6, c_7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab1);
        setTitle("커피");

        tts = new TextToSpeech(this, this);
        input_text = findViewById(R.id.category_coffee);

        // 에스프레소
        c_1 = findViewById(R.id.coffee_1);
        c_1.setOnClickListener( v -> {
            CharSequence text = c_1.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 아메리카노
        c_2 = findViewById(R.id.coffee_2);
        c_2.setOnClickListener( v -> {
            CharSequence text = c_2.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 카페라떼
        c_3 = findViewById(R.id.coffee_3);
        c_3.setOnClickListener( v -> {
            CharSequence text = c_3.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 바닐라라떼
        c_4 = findViewById(R.id.coffee_4);
        c_4.setOnClickListener( v -> {
            CharSequence text = c_4.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 카푸치노
        c_5 = findViewById(R.id.coffee_5);
        c_5.setOnClickListener( v -> {
            CharSequence text = c_5.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 카페모카
        c_6 = findViewById(R.id.coffee_6);
        c_6.setOnClickListener( v -> {
            CharSequence text = c_6.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 비엔나커피
        c_7 = findViewById(R.id.coffee_7);
        c_7.setOnClickListener( v -> {
            CharSequence text = c_7.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

    }
    private void speakOut(){
        CharSequence text = input_text.getText();
        tts.setPitch((float)0.6); // 음성 톤 높이 지정
        tts.setSpeechRate((float)1.0); // 음성 속도 지정
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