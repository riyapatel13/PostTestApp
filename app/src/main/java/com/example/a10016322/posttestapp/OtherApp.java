package com.example.a10016322.posttestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OtherApp extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_app);

        textView = (TextView)(findViewById(R.id.result_id));

        textView.setText(getIntent().getStringExtra("TEST"));

    }
}
