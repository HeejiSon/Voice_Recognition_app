package com.example.voicerecognition_app;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;


public class order_Fragment extends Fragment implements View.OnClickListener, TextToSpeech.OnInitListener{
    private TextToSpeech tts;
    Intent intent, intent2;
    SpeechRecognizer mRecognizer;
    ImageButton sttBtn;
    TextView textView, contents, contents2, menu;
    final int PERMISSION = 1;
    orderPay orderPay;
    Fragment fragment1;
    /*
    private static final String plz = "";

    private String mParam1;

    public void onAttach(@Nullable Context context){
        super.onAttach(context);
        this.context = context;

    }

    public static order_Fragment newInstance(String param1) {
        order_Fragment fragment = new order_Fragment();
        Bundle args = new Bundle();
        args.putString(plz, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(plz);
            getArguments().getString();
        }
    }*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_order, container, false);

        tts = new TextToSpeech(getActivity().getApplicationContext(), this);

        menu = (TextView) view.findViewById(R.id.menu);


        // 안드로이드 6.0버전 이상인지 체크해서 퍼미션 체크
        if (Build.VERSION.SDK_INT >= 23) {
            requestPermissions(new String[]{Manifest.permission.INTERNET, Manifest.permission.RECORD_AUDIO}, PERMISSION);
        }

        textView = (TextView) view.findViewById(R.id.sttResult);
        sttBtn = (ImageButton) view.findViewById(R.id.sttStart);
        sttBtn.setOnClickListener(this);
        contents = (TextView) view.findViewById(R.id.contents);
        contents2 = (TextView) view.findViewById(R.id.contents2);

        // RecognizerIntent 생성
        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        // 여분의 키
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getActivity().getPackageName());
        // 인식 언어 한국어로 설정
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR");

        //json 파일 읽어와서 분석하기

        //assets폴더의 파일을 가져오기 위해
        //창고관리자(AssetManager) 얻어오기
        /*AssetManager assetManager= getContext().getAssets();

        //assets/ test.json 파일 읽기 위한 InputStream
        try {
            InputStream is= assetManager.open("jsons/test.json");
            InputStreamReader isr= new InputStreamReader(is);
            BufferedReader reader= new BufferedReader(isr);

            StringBuffer buffer= new StringBuffer();
            String line= reader.readLine();
            while (line!=null){
                buffer.append(line+"\n");
                line=reader.readLine();
            }

            String jsonData= buffer.toString();

            //읽어온 json문자열 확인
            //menu.setText(jsonData);

            //json 분석
            //json 객체 생성
            //JSONObject jsonObject= new JSONObject(jsonData);
           // String name= jsonObject.getString("name");
            //Integer price= jsonObject.getInt("price");

            //menu.setText("메뉴이름 : "+name+"\n"+"가격 : "+price);

            //json 데이터가 []로 시작하는 배열일때..
            JSONArray jsonArray= new JSONArray(jsonData);



            for(int i=0; i<jsonArray.length();i++){
                JSONObject jo=jsonArray.getJSONObject(i);

                name= jo.getString("name");
                price= jo.getInt("price");
                //JSONObject flag=jo.getJSONObject("flag");
                //int aa= flag.getInt("aa");
                //int bb= flag.getInt("bb");

                s += name+" : "+price+"\n";
            }
            menu.setText(s);

        } catch (IOException e) {e.printStackTrace();} catch (JSONException e) {e.printStackTrace(); }*/

        return view;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void speakOut(){
        CharSequence text = "화면에 있는 메뉴들을 터치해서 메뉴를 듣고, 화면을 오른쪽으로 넘겨 화면을 터치하고 주문을 하세요. 주문이 끝났으면 화면을 터치하고 주문 완료라고 말해주세요";
        tts.setPitch((float)0.6); // 음성 톤 높이 지정
        tts.setSpeechRate((float)1.0); // 음성 속도 지정
        // 첫 번째 매개변수: 음성 출력을 할 텍스트
        // 두 번째 매개변수: 1. TextToSpeech.QUEUE_FLUSH - 진행중인 음성 출력을 끊고 이번 TTS의 음성 출력
        //                 2. TextToSpeech.QUEUE_ADD - 진행중인 음성 출력이 끝난 후에 이번 TTS의 음성 출력
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
    }

    @Override
    public void onDestroy() {
        if(tts!=null){ // 사용한 TTS객체 제거
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.KOREA); // TTS언어 한국어로 설정

            if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA) {
                Log.e("TTS", "This Language is not supported");
            } else {
                speakOut();
            }
        } else {
            Log.e("TTS", "Initialization Failed!");
        }
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sttStart:
                //mRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
                mRecognizer = SpeechRecognizer.createSpeechRecognizer(getContext());
                // 리스너 설정
                mRecognizer.setRecognitionListener(listener);
                // 듣기 시작
                mRecognizer.startListening(intent);
                Log.d("onclick", "btnNum ");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }

    }

    private RecognitionListener listener = new RecognitionListener() {
        @Override
        public void onReadyForSpeech(Bundle params) {
            Toast.makeText(getActivity().getApplicationContext(), "음성인식 시작", Toast.LENGTH_SHORT).show();
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

            Toast.makeText(getActivity().getApplicationContext(), "에러가 발생하였습니다. : " + message, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onResults(Bundle results) {

            // 말을 하면 ArrayList에 단어를 넣고 textView에 단어를 이어준다.
            ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
            String originText = contents.getText().toString(); // 기존 text
            String resultStr = "";
            String orderStr = "";


            for (int i = 0; i < matches.size(); i++) {
                //textView.setText(matches.get(i));
                resultStr += matches.get(i);
                orderStr += matches.get(i);
            }
            //기존의 text에 인식 결과를 이어붙임
            textView.setText(originText + " " + orderStr + " ");

            // 현재 음성 주문
            contents.setText(orderStr);

            // 녹음버튼을 누를 때까지 계속 녹음해야됨
            //mRecognizer.startListening(intent);


            if (orderStr.length() < 1) return;
            orderStr = orderStr.replace(" ", "");



            if (resultStr.length() < 1) return;
            resultStr = resultStr.replace(" ", "");

            moveActivityPay(resultStr);
            moveActivityOrder(orderStr);


        }


        @Override
        public void onPartialResults(Bundle partialResults) {

        }

        @Override
        public void onEvent(int eventType, Bundle params) {

        }

        public void moveActivityOrder(String orderStr){
            AssetManager assetManager= getContext().getAssets();

            //assets/ test.json 파일 읽기 위한 InputStream
            try {
                InputStream is= assetManager.open("jsons/test.json");
                InputStreamReader isr= new InputStreamReader(is);
                BufferedReader reader= new BufferedReader(isr);

                StringBuffer buffer= new StringBuffer();
                String line= reader.readLine();
                while (line!=null){
                    buffer.append(line+"\n");
                    line=reader.readLine();
                }

                String jsonData= buffer.toString();

                //읽어온 json문자열 확인
                //menu.setText(jsonData);

                //json 분석
                //json 객체 생성
                //JSONObject jsonObject= new JSONObject(jsonData);
                // String name= jsonObject.getString("name");
                //Integer price= jsonObject.getInt("price");

                //menu.setText("메뉴이름 : "+name+"\n"+"가격 : "+price);

                //json 데이터가 []로 시작하는 배열일때..
                JSONArray jsonArray= new JSONArray(jsonData);

                String s="";
                String name = "";
                Integer price = 0;

                for(int i=0; i<jsonArray.length();i++){
                    JSONObject jo=jsonArray.getJSONObject(i);

                    name = jo.getString("name");
                    price= jo.getInt("price");

                    //JSONObject nameObject = new JSONObject(name);

                    //Iterator j = nameObject.keys();

                    //s += name+" : "+price+"\n";
                    s += name+ "\n";
                }
                menu.setText(s);

                if (s.contains(orderStr)) {
                    Toast.makeText(getActivity().getApplicationContext(), "메뉴 있음", Toast.LENGTH_SHORT).show();
                    //String menu = "";
                    //menu = orderStr;
                    //intent2 = new Intent(getActivity(),orderPay.class);
                    //intent2.putExtra("name", orderStr);
                    //Bundle bundle = new Bundle();
                    //bundle.putString("name", contents.getText().toString());
                    //Fragment fragment1 = new Fragment();
                    //fragment1.setArguments(bundle);
                    Intent intent1 = new Intent(getContext(),orderPay.class);

                    //intent1.putExtra("name", contents.getText().toString());

                    intent1.putExtra("name", orderStr);
                    //intent1.putExtra("name2", orderStr);


                    //onActivityResult(intent1, 102, bundle);


                    //getParentFragment().setArguments(bundle);

                    //intent1.putExtra("name", orderStr);
                    startActivityForResult(intent1, 102);
                }
                else {

                }


            } catch (IOException e) {e.printStackTrace();} catch (JSONException e) {e.printStackTrace(); }


        }

        /*public String removeStringNumber(String orderStr) {
            return orderStr.replaceAll("[^0-9]", "");
        }*/

        public void moveActivityPay(String resultStr) {
            if (resultStr.contains("주문완료") || (resultStr.contains("완료"))||(resultStr.contains("주문"))) {
                Toast.makeText(getActivity().getApplicationContext(), "주문확인 및 결제화면으로 이동합니다.", Toast.LENGTH_SHORT).show();
                CharSequence text = "주문확인 및 결제화면으로 이동합니다.";
                tts.setPitch((float) 0.6); // 음성 톤 높이 지정
                tts.setSpeechRate((float) 1.0); // 음성 속도 지정
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
                Intent intent1 = new Intent(getActivity(),orderPay.class);
                startActivity(intent1);
            }
        }

        /*
         * 음성인식/출력 객체가 남아있다면 실행을 중지하고 메모리에서 제거
         */
        //@Override
        public void onDestroy() {
            if (mRecognizer != null) {
                mRecognizer.destroy();
                mRecognizer.cancel();
                mRecognizer = null;
            }
        }
    };


}


