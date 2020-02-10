package com.example.androidtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText name, pass;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.log_btn);
        name = findViewById(R.id.et_name);
        pass = findViewById(R.id.et_pass);

        dbRef = FirebaseDatabase.getInstance().getReference("users");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = dbRef.push().getKey();
                User user = new User(name.getText().toString(), pass.getText().toString());
                dbRef.child(id).setValue(user);
                name.getText().clear();
                pass.getText().clear();
            }
        });
    }
}
