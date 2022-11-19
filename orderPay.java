package com.example.voicerecognition_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;

public class orderPay extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;
    Intent intent, intent1;
    SpeechRecognizer mRecognizer;
    final int PERMISSION = 1;
    TextView pay_1, pay_2, pay_3, pay_4, total_q, total_price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_pay);
        setTitle("주문확인 및 결제");

        tts = new TextToSpeech(this, this);
        pay_1 = (TextView) findViewById(R.id.pay_1);
        pay_2 = (TextView) findViewById(R.id.pay_2);
        pay_3 = (TextView) findViewById(R.id.pay_3);
        pay_4 = (TextView) findViewById(R.id.pay_4);
        total_q = (TextView) findViewById(R.id.total_q) ;
        total_price = (TextView) findViewById(R.id.total_price);

        movedata();

        if (Build.VERSION.SDK_INT >= 23) {
            requestPermissions(new String[]{Manifest.permission.INTERNET, Manifest.permission.RECORD_AUDIO}, PERMISSION);
        }
        // RecognizerIntent 생성
        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        // 여분의 키
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, this.getPackageName());
        // 인식 언어 한국어로 설정
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR");

    }

    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                //손가락을 화면에서 뗄 때 할 일
                mRecognizer=SpeechRecognizer.createSpeechRecognizer(this);
                mRecognizer.setRecognitionListener(listener);
                mRecognizer.startListening(intent);
                break;
            default:
                break;
        }
        return true;
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000) {
            if (resultCode == RESULT_OK) {
                String resultMsg = data.getStringExtra("ResultMsg");
                Toast.makeText(this, "RESULT_OK : " + resultMsg, Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                String resultMsg = data.getStringExtra("ResultMsg");
                Toast.makeText(this, "RESULT_CANCELED : " + resultMsg, Toast.LENGTH_SHORT).show();
            } else {

            }
        }
    }*/

    private void movedata(){
        intent1 = getIntent();
        Bundle bundle = intent1.getExtras();
        String menu1 = bundle.getString("menu1");
        Integer count1 = bundle.getInt("count1");
        String menu2 = bundle.getString("menu2");
        Integer count2 = bundle.getInt("count2");

        /*String menu1 = intent1.getStringExtra("name");

        String count1 = intent1.getStringExtra("price");

        pay_1.setText(menu1);
        pay_2.setText(count1 + " 잔");

        String menu2 = intent1.getStringExtra("name2");
        String count2 = intent1.getStringExtra("price");*/

        pay_1.setText(menu1);
        pay_2.setText(count1 + " 잔");
        pay_3.setText(menu2);
        pay_4.setText(count2 + " 잔");

        Integer total_qu = count1 + count2;

        total_q.setText("총 수량 : " + total_qu + " 잔");




    }

    String view = "주문확인 및 결제화면 입니다.";
    String order = "아메리카노 2잔, 바닐라라떼 1잔 총 3잔으로 8500원입니다.";
    //String order = pay_1.getText() + " " +  pay_2.getText() + "잔 으로 원입니다.";
    String pay = "결제하시려면 화면을 터치하고 결제라고 말해주세요";


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onInit(int status) { // OnInitListener를 통해서 TTS 초기화
        if(status == TextToSpeech.SUCCESS){
            int result = tts.setLanguage(Locale.KOREA); // TTS언어 한국어로 설정


            if(result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA){
                Log.e("TTS", "This Language is not supported");
            }else{
                tts.setPitch((float)0.6); // 음성 톤 높이 지정
                tts.setSpeechRate((float)1.0); // 음성 속도 지정
                tts.speak(view + " " + order+ " " + pay, TextToSpeech.QUEUE_ADD, null);
                // speakOut();
                // PayOut();
            }
        }else{
            Log.e("TTS", "Initialization Failed!");
        }
    }
    @Override
    public void onDestroy() {
        if(tts!=null){ // 사용한 TTS객체 제거
            tts.stop();
            tts.shutdown();
        }
        if (mRecognizer != null) {
            mRecognizer.destroy();
            mRecognizer.cancel();
            mRecognizer = null;
        }
        super.onDestroy();
    }
    private RecognitionListener listener = new RecognitionListener() {
        @Override
        public void onReadyForSpeech(Bundle params) {
            Toast.makeText(getApplicationContext().getApplicationContext(), "음성인식 시작", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onBeginningOfSpeech() {
        }

        @Override
        public void onRmsChanged(float rmsdB) {
        }

        @Override
        public void onBufferReceived(byte[] buffer) {
        }

        @Override
        public void onEndOfSpeech() {
        }

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

            Toast.makeText(getApplicationContext().getApplicationContext(), "에러가 발생하였습니다. : " + message, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onResults(Bundle results) {

            // 말을 하면 ArrayList에 단어를 넣고 textView에 단어를 이어준다.
            ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
            String resultStr = "";

            for (int i = 0; i < matches.size(); i++) {
                resultStr += matches.get(i);
            }
            //mRecognizer.startListening(intent);

            if (resultStr.length() < 1) return;
            resultStr = resultStr.replace(" ", "");

            moveActivityPay(resultStr);

        }

        @Override
        public void onPartialResults(Bundle partialResults) {

        }

        @Override
        public void onEvent(int eventType, Bundle params) {

        }


        public void moveActivityPay(String resultStr) {
            if (resultStr.contains("결제")) {
                Toast.makeText(getApplicationContext().getApplicationContext(), "결제가 완료되었습니다.", Toast.LENGTH_SHORT).show();
                CharSequence text = "결제가 완료 되었습니다.감사합니다.";
                tts.setPitch((float) 0.6); // 음성 톤 높이 지정
                tts.setSpeechRate((float) 1.0); // 음성 속도 지정
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
                //Intent intent1 = new Intent(getActivity(),orderPay.class);
                //startActivity(intent1);
            }
            else{
                CharSequence text = "다시 한번 말씀해주세요.";
                tts.setPitch((float) 0.6); // 음성 톤 높이 지정
                tts.setSpeechRate((float) 1.0); // 음성 속도 지정
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
            }
        }

    };
}