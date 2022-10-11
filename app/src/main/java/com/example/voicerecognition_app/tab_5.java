package com.example.voicerecognition_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.TextView;

import java.util.Locale;

public class tab_5 extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;
    private TextView input_text, t_1, t_2, t_3, t_4, t_5, t_6, t_7, t_8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab5);
        setTitle("차");

        tts = new TextToSpeech(this, this);
        input_text = findViewById(R.id.category_tea);

        // 레몬차
        t_1 = findViewById(R.id.tea_1);
        t_1.setOnClickListener( v -> {
            CharSequence text = t_1.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 유자차
        t_2 = findViewById(R.id.tea_2);
        t_2.setOnClickListener( v -> {
            CharSequence text = t_2.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 자몽차
        t_3 = findViewById(R.id.tea_3);
        t_3.setOnClickListener( v -> {
            CharSequence text = t_3.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 생강차
        t_4 = findViewById(R.id.tea_4);
        t_4.setOnClickListener( v -> {
            CharSequence text = t_4.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 얼그레이차
        t_5 = findViewById(R.id.tea_5);
        t_5.setOnClickListener( v -> {
            CharSequence text = t_5.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 캐모마일차
        t_6 = findViewById(R.id.tea_6);
        t_6.setOnClickListener( v -> {
            CharSequence text = t_6.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 페퍼민트차
        t_7 = findViewById(R.id.tea_7);
        t_7.setOnClickListener( v -> {
            CharSequence text = t_7.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 밀크티
        t_8 = findViewById(R.id.tea_8);
        t_8.setOnClickListener( v -> {
            CharSequence text = t_8.getText();
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