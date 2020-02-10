package com.hfad.mymessenger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ReceiveMessageActivity extends AppCompatActivity {

//    we create an intent
    public static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
    }
}
