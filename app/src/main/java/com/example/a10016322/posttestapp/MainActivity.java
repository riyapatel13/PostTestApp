package com.example.a10016322.posttestapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RelativeLayout layout;
    TextView name;
    RadioGroup radioGroup;
    RadioButton toastButton, colorButton, capitalButton;
    Button run, launch;
    static final int NUMBER_CODE = 12345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (RelativeLayout)(findViewById(R.id.layout_id));
        name = (TextView)(findViewById(R.id.name_id));
        radioGroup = (RadioGroup) (findViewById(R.id.radioGroup));
        toastButton = (RadioButton)(findViewById(R.id.radioButton2));
        colorButton = (RadioButton)(findViewById(R.id.radioButton));
        capitalButton = (RadioButton)(findViewById(R.id.radioButton3));
        run = (Button)(findViewById(R.id.run_id));
        launch = (Button) (findViewById(R.id.launchApp_id));

        /*radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButton3)
                    name.setText("RIYA PATEL");
            }
        });*/

        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toastButton.isChecked())
                {
                    Toast message = Toast.makeText(MainActivity.this, "Toast selected", Toast.LENGTH_SHORT);
                    message.show();
                }
                if(capitalButton.isChecked())
                {
                    name.setText("RIYA PATEL");
                }
                if(colorButton.isChecked())
                {
                    int x = (int)(Math.random()*3)+1;
                    if (x==1)
                        layout.setBackgroundColor(Color.MAGENTA);
                    else if (x==2)
                        layout.setBackgroundColor(Color.CYAN);
                    else
                        layout.setBackgroundColor(Color.LTGRAY);
                }
            }
        });

        launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toastButton.isChecked())
                {
                    Intent openApp = new Intent (MainActivity.this, OtherApp.class);
                    openApp.putExtra("TEST", "The Toast button has been selected.");
                    startActivityForResult(openApp, NUMBER_CODE);
                }
                if (capitalButton.isChecked())
                {
                    Intent openApp = new Intent (MainActivity.this, OtherApp.class);
                    openApp.putExtra("TEST", "The uppercase button has been selected.");
                    startActivityForResult(openApp, NUMBER_CODE);
                }
                if (colorButton.isChecked())
                {
                    Intent openApp = new Intent (MainActivity.this, OtherApp.class);
                    openApp.putExtra("TEST", "The color change button has been selected.");
                    startActivityForResult(openApp, NUMBER_CODE);
                }
            }
        });

    }
}
