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


public class Fragment_4 extends Fragment implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;
    private TextView s_1, s_2, s_3, s_4, s_5;

    public Fragment_4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_4, container, false);

        tts = new TextToSpeech(getActivity().getApplicationContext(), this);

        // 딸기스무디
        s_1 = (TextView) view.findViewById(R.id.smoothie_1);
        s_1.setOnClickListener(v -> {
            CharSequence text = s_1.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 블루베리스무디
        s_2 = (TextView) view.findViewById(R.id.smoothie_2);
        s_2.setOnClickListener(v -> {
            CharSequence text = s_2.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 망고스무디
        s_3 = (TextView) view.findViewById(R.id.smoothie_3);
        s_3.setOnClickListener(v -> {
            CharSequence text = s_3.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 레몬스무디
        s_4 = (TextView) view.findViewById(R.id.smoothie_4);
        s_4.setOnClickListener(v -> {
            CharSequence text = s_4.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 복숭아스무디
        s_5 = (TextView) view.findViewById(R.id.smoothie_5);
        s_5.setOnClickListener(v -> {
            CharSequence text = s_5.getText();
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