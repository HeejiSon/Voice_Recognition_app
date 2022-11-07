package com.example.voicerecognition_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class tab_1 extends AppCompatActivity  implements TextToSpeech.OnInitListener {
    //private order_Fragment orderFragment;
    //private static final int PERMISSION = 1;
    //Intent intent;
    private TextToSpeech tts;
    private TextView textView, input_text, c_1, c_2, c_3, c_4, c_5, c_6, c_7, order_tts, order1_tts;
   // SpeechRecognizer mRecognizer;
    //private ViewPager viewPager;
    //private MyPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab1);
        setTitle("커피");


        /*viewPager = (ViewPager) findViewById(R.id.viewpager) ;
        pagerAdapter = new  MyPagerAdapter(getSupportFragmentManager()) ;
        viewPager.setAdapter(pagerAdapter) ;*/

        /*textView = (TextView)findViewById(R.id.sttResult);
        order_tts = findViewById(R.id.order_tts);
        order1_tts = findViewById(R.id.order1_tts);

        intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,getPackageName());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"ko-KR");

        mRecognizer=SpeechRecognizer.createSpeechRecognizer(this);
        mRecognizer.setRecognitionListener(listener);
        mRecognizer.startListening(intent);*/

        tts = new TextToSpeech(this, this);

        // 에스프레소
        c_1 = findViewById(R.id.coffee_1);
        c_1.setOnClickListener(v -> {
            CharSequence text = c_1.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 아메리카노
        c_2 = findViewById(R.id.coffee_2);
        c_2.setOnClickListener(v -> {
            CharSequence text = c_2.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 카페라떼
        c_3 = findViewById(R.id.coffee_3);
        c_3.setOnClickListener(v -> {
            CharSequence text = c_3.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 바닐라라떼
        c_4 = findViewById(R.id.coffee_4);
        c_4.setOnClickListener(v -> {
            CharSequence text = c_4.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 카푸치노
        c_5 = findViewById(R.id.coffee_5);
        c_5.setOnClickListener(v -> {
            CharSequence text = c_5.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 카페모카
        c_6 = findViewById(R.id.coffee_6);
        c_6.setOnClickListener(v -> {
            CharSequence text = c_6.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

        // 비엔나커피
        c_7 = findViewById(R.id.coffee_7);
        c_7.setOnClickListener(v -> {
            CharSequence text = c_7.getText();
            tts.setPitch((float) 0.6); // 음성 톤 높이 지정
            tts.setSpeechRate((float) 1.0); // 음성 속도 지정
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
        });

    }
    /*private void speakOut(){
        CharSequence text = input_text.getText();
        tts.setPitch((float)0.6); // 음성 톤 높이 지정
        tts.setSpeechRate((float)1.0); // 음성 속도 지정
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
    }

    private void speakOut_order(){
        CharSequence text = " ";
        tts.setPitch((float)0.6); // 음성 톤 높이 지정
        tts.setSpeechRate((float)0.9); // 음성 속도 지정
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
    }*/

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onInit(int status) { // OnInitListener를 통해서 TTS 초기화
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



    /*// 음성인식
    private RecognitionListener listener = new RecognitionListener() {
        @Override
        public void onReadyForSpeech(Bundle params) {
            Toast.makeText(getApplicationContext(),"음성인식을 시작합니다.",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onBeginningOfSpeech() {}

        @Override
        public void onRmsChanged(float rmsdB) {}

        @Override
        public void onBufferReceived(byte[] buffer) {}

        @Override
        public void onEndOfSpeech() {}

        @Override
        public void onError(int error) {
            String message;

            switch (error) {
                case SpeechRecognizer.ERROR_AUDIO:
                    message = "오디오 에러";
                    break;
                case SpeechRecognizer.ERROR_CLIENT:
                    message = "클라이언트 에러";
                    break;
                case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                    message = "퍼미션 없음";
                    break;
                case SpeechRecognizer.ERROR_NETWORK:
                    message = "네트워크 에러";
                    break;
                case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                    message = "네트웍 타임아웃";
                    break;
                case SpeechRecognizer.ERROR_NO_MATCH:
                    message = "찾을 수 없음";
                    break;
                case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                    message = "RECOGNIZER가 바쁨";
                    break;
                case SpeechRecognizer.ERROR_SERVER:
                    message = "서버가 이상함";
                    break;
                case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                    message = "말하는 시간초과";
                    break;
                default:
                    message = "알 수 없는 오류임";
                    break;
            }

            Toast.makeText(getApplicationContext(), "에러가 발생하였습니다. : " + message,Toast.LENGTH_SHORT).show();
        }




        @Override
        public void onResults(Bundle results) {
            // 말을 하면 ArrayList에 단어를 넣고 textView에 단어를 이어줍니다.
            ArrayList<String> matches =
                    results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

            for(int i = 0; i < matches.size() ; i++){
                textView.setText(matches.get(i));
            }
            // '주문'이라는 단어을 음성인식을 받으면 주문화면으로 넘어감
            if (matches.contains("주문") || matches.equals("나 주문") || matches.equals("아주 문")) {
                Toast.makeText(getApplicationContext(), "성공 : " , Toast.LENGTH_SHORT).show();
                //CharSequence text = "주문화면으로 이동합니다.";
                tts.setPitch((float) 0.6); // 음성 톤 높이 지정
                tts.setSpeechRate((float) 0.9); // 음성 속도 지정
                tts.speak("주문화면으로 이동합니다.", TextToSpeech.QUEUE_FLUSH, null, "id1");

            }
        }


        @Override
        public void onPartialResults(Bundle partialResults) {}

        @Override
        public void onEvent(int eventType, Bundle params) {}*/



