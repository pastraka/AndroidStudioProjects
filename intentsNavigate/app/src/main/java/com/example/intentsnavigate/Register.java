package com.example.intentsnavigate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    public static String MSG2SEND = "messageFromEditText";
    public static String MSG2SEND2 = "typedMessage";
    Button btn;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //connecting our classes with the widgets
        btn = findViewById(R.id.btn);
        editText = findViewById(R.id.editText);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nav();
            }
        });
    }

    private void nav() {
        //Tels our app that we are intend to do something. It can be use to open another
        //activity on oup app.
        Intent i = new Intent(this, Activity2.class);
        i.putExtra(MSG2SEND, editText.getText().toString());
        i.putExtra(MSG2SEND2, editText.getText().toString());
        startActivity(i);
    }
}
