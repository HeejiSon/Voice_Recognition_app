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


public class Fragment_3 extends Fragment implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;
    private TextView a_1, a_2, a_3, a_4, a_5, a_6;

    public Fragment_3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);

        tts = new TextToSpeech(getActivity().getApplicationContext(), this);

        // 자몽에이드
        a_1 = (TextView) view.findViewById(R.id.ade_1);
        a_1.setOnClickListener(v -> {
            CharSequence text = a_1.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 레몬에이드
        a_2 = (TextView) view.findViewById(R.id.ade_2);
        a_2.setOnClickListener(v -> {
            CharSequence text = a_2.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 블루레몬에이드
        a_3 = (TextView) view.findViewById(R.id.ade_3);
        a_3.setOnClickListener(v -> {
            CharSequence text = a_3.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 청포도에이드
        a_4 = (TextView) view.findViewById(R.id.ade_4);
        a_4.setOnClickListener(v -> {
            CharSequence text = a_4.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 유자에이드
        a_5 = (TextView) view.findViewById(R.id.ade_5);
        a_5.setOnClickListener(v -> {
            CharSequence text = a_5.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 체리콕
        a_6 = (TextView) view.findViewById(R.id.ade_6);
        a_6.setOnClickListener(v -> {
            CharSequence text = a_6.getText();
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