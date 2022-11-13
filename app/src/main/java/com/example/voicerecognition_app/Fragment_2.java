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

public class Fragment_2 extends Fragment implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;
    private TextView l_1, l_2, l_3, l_4;

    public Fragment_2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        tts = new TextToSpeech(getActivity().getApplicationContext(), this);

        // 고구마라떼
        l_1 = (TextView) view.findViewById(R.id.latte_1);
        l_1.setOnClickListener(v -> {
            CharSequence text = l_1.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 녹차라떼
        l_2 = (TextView) view.findViewById(R.id.latte_2);
        l_2.setOnClickListener(v -> {
            CharSequence text = l_2.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 오곡라떼
        l_3 = (TextView) view.findViewById(R.id.latte_3);
        l_3.setOnClickListener(v -> {
            CharSequence text = l_3.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 티라미수라떼
        l_4 = (TextView) view.findViewById(R.id.latte_4);
        l_4.setOnClickListener(v -> {
            CharSequence text = l_4.getText();
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