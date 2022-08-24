package com.example.voicerecognition_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class order_detail extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter arrayAdapter;

    //// 스피너 글자크기 수정해야됨.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter);

        /*ArrayAdapter.createFromResource(this, R.array.count, R.layout.spinner_count
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter;
        }
        spinner.onItemSelectedListener = this;*/

        ArrayAdapter<?> a8Adapter = ArrayAdapter.createFromResource(this, R.array.count, R.layout.spinner_count);

        a8Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        //sp_a8.setAdapter(a8Adapter);


    }
}