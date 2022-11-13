package com.example.voicerecognition_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;


public class Fragment_1 extends Fragment implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;
    private TextView c_1, c_2, c_3, c_4, c_5, c_6, c_7;

    public Fragment_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_1, container, false);

        tts = new TextToSpeech(getActivity().getApplicationContext(), this);

        // 에스프레소
        c_1 = (TextView) view.findViewById(R.id.coffee_1);
        c_1.setOnClickListener(v -> {
            CharSequence text = c_1.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 아메리카노
        c_2 = (TextView) view.findViewById(R.id.coffee_2);
        c_2.setOnClickListener(v -> {
            CharSequence text = c_2.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 카페라떼
        c_3 = (TextView) view.findViewById(R.id.coffee_3);
        c_3.setOnClickListener(v -> {
            CharSequence text = c_3.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 바닐라라떼
        c_4 = (TextView) view.findViewById(R.id.coffee_4);
        c_4.setOnClickListener(v -> {
            CharSequence text = c_4.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 카푸치노
        c_5 = (TextView) view.findViewById(R.id.coffee_5);
        c_5.setOnClickListener(v -> {
            CharSequence text = c_5.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 카페모카
        c_6 = (TextView) view.findViewById(R.id.coffee_6);
        c_6.setOnClickListener(v -> {
            CharSequence text = c_6.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 비엔나커피
        c_7 = (TextView) view.findViewById(R.id.coffee_7);
        c_7.setOnClickListener(v -> {
            CharSequence text = c_7.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });
        return view;
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.KOREA); // TTS언어 한국어로 설정

            if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA) {
                Log.e("TTS", "This Language is not supported");
            } else {
            }
        } else {
            Log.e("TTS", "Initialization Failed!");
        }
    }
}