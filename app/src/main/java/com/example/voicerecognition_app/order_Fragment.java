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


        // ??????????????? 6.0?????? ???????????? ???????????? ????????? ??????
        if (Build.VERSION.SDK_INT >= 23) {
            requestPermissions(new String[]{Manifest.permission.INTERNET, Manifest.permission.RECORD_AUDIO}, PERMISSION);
        }

        textView = (TextView) view.findViewById(R.id.sttResult);
        sttBtn = (ImageButton) view.findViewById(R.id.sttStart);
        sttBtn.setOnClickListener(this);
        contents = (TextView) view.findViewById(R.id.contents);
        contents2 = (TextView) view.findViewById(R.id.contents2);

        // RecognizerIntent ??????
        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        // ????????? ???
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getActivity().getPackageName());
        // ?????? ?????? ???????????? ??????
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR");

        //json ?????? ???????????? ????????????

        //assets????????? ????????? ???????????? ??????
        //???????????????(AssetManager) ????????????
        /*AssetManager assetManager= getContext().getAssets();

        //assets/ test.json ?????? ?????? ?????? InputStream
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

            //????????? json????????? ??????
            //menu.setText(jsonData);

            //json ??????
            //json ?????? ??????
            //JSONObject jsonObject= new JSONObject(jsonData);
           // String name= jsonObject.getString("name");
            //Integer price= jsonObject.getInt("price");

            //menu.setText("???????????? : "+name+"\n"+"?????? : "+price);

            //json ???????????? []??? ???????????? ????????????..
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
        CharSequence text = "????????? ?????? ???????????? ???????????? ????????? ??????, ????????? ??????????????? ?????? ????????? ???????????? ????????? ?????????. ????????? ???????????? ????????? ???????????? ?????? ???????????? ???????????????";
        tts.setPitch((float)0.6); // ?????? ??? ?????? ??????
        tts.setSpeechRate((float)1.0); // ?????? ?????? ??????
        // ??? ?????? ????????????: ?????? ????????? ??? ?????????
        // ??? ?????? ????????????: 1. TextToSpeech.QUEUE_FLUSH - ???????????? ?????? ????????? ?????? ?????? TTS??? ?????? ??????
        //                 2. TextToSpeech.QUEUE_ADD - ???????????? ?????? ????????? ?????? ?????? ?????? TTS??? ?????? ??????
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
    }

    @Override
    public void onDestroy() {
        if(tts!=null){ // ????????? TTS?????? ??????
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.KOREA); // TTS?????? ???????????? ??????

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
                // ????????? ??????
                mRecognizer.setRecognitionListener(listener);
                // ?????? ??????
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
            Toast.makeText(getActivity().getApplicationContext(), "???????????? ??????", Toast.LENGTH_SHORT).show();
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
                    message = "????????? ??????";
                    break;
                case SpeechRecognizer.ERROR_CLIENT:
                    message = "??????????????? ??????";
                    break;
                case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                    message = "????????? ??????";
                    break;
                case SpeechRecognizer.ERROR_NETWORK:
                    message = "???????????? ??????";
                    break;
                case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                    message = "????????? ????????????";
                    break;
                case SpeechRecognizer.ERROR_NO_MATCH:
                    message = "?????? ??? ??????";
                    break;
                case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                    message = "RECOGNIZER??? ??????";
                    break;
                case SpeechRecognizer.ERROR_SERVER:
                    message = "????????? ?????????";
                    break;
                case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                    message = "????????? ????????????";
                    break;
                default:
                    message = "??? ??? ?????? ?????????";
                    break;
            }

            Toast.makeText(getActivity().getApplicationContext(), "????????? ?????????????????????. : " + message, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onResults(Bundle results) {

            // ?????? ?????? ArrayList??? ????????? ?????? textView??? ????????? ????????????.
            ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
            String originText = contents.getText().toString(); // ?????? text
            String resultStr = "";
            String orderStr = "";


            for (int i = 0; i < matches.size(); i++) {
                //textView.setText(matches.get(i));
                resultStr += matches.get(i);
                orderStr += matches.get(i);
            }
            //????????? text??? ?????? ????????? ????????????
            textView.setText(originText + " " + orderStr + " ");

            // ?????? ?????? ??????
            contents.setText(orderStr);

            // ??????????????? ?????? ????????? ?????? ???????????????
            //mRecognizer.startListening(intent);


            if (orderStr.length() < 1) return;
            orderStr = orderStr.replace(" ", "");



            if (resultStr.length() < 1) return;
            resultStr = resultStr.replace(" ", "");

            moveActivityPay(resultStr);
            moveActivityOrder(resultStr, orderStr);


        }


        @Override
        public void onPartialResults(Bundle partialResults) {

        }

        @Override
        public void onEvent(int eventType, Bundle params) {

        }

        public void moveActivityOrder(String orderStr){
            AssetManager assetManager= getContext().getAssets();

            //assets/ test.json ?????? ?????? ?????? InputStream
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

                //????????? json????????? ??????
                //menu.setText(jsonData);

                //json ??????
                //json ?????? ??????
                //JSONObject jsonObject= new JSONObject(jsonData);
                // String name= jsonObject.getString("name");
                //Integer price= jsonObject.getInt("price");

                //menu.setText("???????????? : "+name+"\n"+"?????? : "+price);

                //json ???????????? []??? ???????????? ????????????..
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
                    Toast.makeText(getActivity().getApplicationContext(), "?????? ??????", Toast.LENGTH_SHORT).show();
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
            if (resultStr.contains("????????????") || (resultStr.contains("??????"))||(resultStr.contains("??????"))) {
                Toast.makeText(getActivity().getApplicationContext(), "???????????? ??? ?????????????????? ???????????????.", Toast.LENGTH_SHORT).show();
                CharSequence text = "???????????? ??? ?????????????????? ???????????????.";
                tts.setPitch((float) 0.6); // ?????? ??? ?????? ??????
                tts.setSpeechRate((float) 1.0); // ?????? ?????? ??????
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
                Intent intent1 = new Intent(getActivity(),orderPay.class);
                startActivity(intent1);
            }
        }

        /*
         * ????????????/?????? ????????? ??????????????? ????????? ???????????? ??????????????? ??????
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


