package com.hfad.mymessenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    //    this method will get called when the button is clicked
    public void onSendMessage(View view) {
        EditText messageView = findViewById(R.id.message);
//        get the text from the editable text field with an ID of message
        String messageText = messageView.getText().toString();
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
//        add the text to the intent, give in it a name "message".
        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageText);
//        start Activity ReceiveMessageActivity
        startActivity(intent);
    }
}
