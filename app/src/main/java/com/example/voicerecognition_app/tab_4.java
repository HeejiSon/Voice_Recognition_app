package com.example.voicerecognition_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.TextView;

import java.util.Locale;

public class tab_4 extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;
    private TextView input_text, s_1, s_2, s_3, s_4, s_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab4);
        setTitle("스무디");

        tts = new TextToSpeech(this, this);
        input_text = findViewById(R.id.category_smoothie);

        // 딸기 스무디
        s_1 = findViewById(R.id.smoothie_1);
        s_1.setOnClickListener( v -> {
            CharSequence text = s_1.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 블루베리 스무디
        s_2 = findViewById(R.id.smoothie_2);
        s_2.setOnClickListener( v -> {
            CharSequence text = s_2.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 망고 스무디
        s_3 = findViewById(R.id.smoothie_3);
        s_3.setOnClickListener( v -> {
            CharSequence text = s_3.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 레몬 스무디
        s_4 = findViewById(R.id.smoothie_4);
        s_4.setOnClickListener( v -> {
            CharSequence text = s_4.getText();
            tts.setPitch((float)0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float)1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 복숭아 스무디
        s_5 = findViewById(R.id.smoothie_5);
        s_5.setOnClickListener( v -> {
            CharSequence text = s_5.getText();
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