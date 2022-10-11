package com.example.voicerecognition_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.TextView;

import java.util.Locale;

public class tab_2 extends AppCompatActivity implements TextToSpeech.OnInitListener{
    private TextToSpeech tts;
    private TextView input_text, l_1, l_2, l_3, l_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab2);
        setTitle("라떼");

        tts = new TextToSpeech(this, this);
        input_text = findViewById(R.id.category_latte);

        // 고구마라떼
        l_1 = findViewById(R.id.latte_1);
        l_1.setOnClickListener( v -> {
            CharSequence text = l_1.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 녹차라떼
        l_2 = findViewById(R.id.latte_2);
        l_2.setOnClickListener( v -> {
            CharSequence text = l_2.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 오곡라떼
        l_3 = findViewById(R.id.latte_3);
        l_3.setOnClickListener( v -> {
            CharSequence text = l_3.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 티라미수라떼
        l_4 = findViewById(R.id.latte_4);
        l_4.setOnClickListener( v -> {
            CharSequence text = l_4.getText();
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