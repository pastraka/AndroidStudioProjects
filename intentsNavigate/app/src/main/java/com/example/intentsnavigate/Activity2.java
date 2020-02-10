package com.example.intentsnavigate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        textView = findViewById(R.id.textView);

        Intent i = getIntent();
        String msg = i.getStringExtra(Register.MSG2SEND);
        String msg2 = i.getStringExtra(Register.MSG2SEND2);
        textView.setText(msg);
        textView.setText(msg2);
    }
}
