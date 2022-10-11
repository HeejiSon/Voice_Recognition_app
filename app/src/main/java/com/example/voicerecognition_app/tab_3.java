package com.example.voicerecognition_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.TextView;

import java.util.Locale;

public class tab_3 extends AppCompatActivity implements TextToSpeech.OnInitListener{
    private TextToSpeech tts;
    private TextView input_text, a_1, a_2, a_3, a_4, a_5, a_6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab3);
        setTitle("에이드");

        tts = new TextToSpeech(this, this);
        input_text = findViewById(R.id.category_ade);

        // 자몽에이드
        a_1 = findViewById(R.id.ade_1);
        a_1.setOnClickListener( v -> {
            CharSequence text = a_1.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 레몬에이드
        a_2 = findViewById(R.id.ade_2);
        a_2.setOnClickListener( v -> {
            CharSequence text = a_2.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 블루레몬에이드
        a_3 = findViewById(R.id.ade_3);
        a_3.setOnClickListener( v -> {
            CharSequence text = a_3.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 청포도에이드
        a_4 = findViewById(R.id.ade_4);
        a_4.setOnClickListener( v -> {
            CharSequence text = a_4.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 유자에이드
        a_5 = findViewById(R.id.ade_5);
        a_5.setOnClickListener( v -> {
            CharSequence text = a_5.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 체리콕
        a_6 = findViewById(R.id.ade_6);
        a_6.setOnClickListener( v -> {
            CharSequence text = a_6.getText();
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