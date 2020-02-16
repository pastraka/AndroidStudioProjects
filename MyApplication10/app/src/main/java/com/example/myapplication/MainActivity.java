package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    //1. Declare our Java couterpart Views
    EditText fn, sn;
    Button save, navigate;
    DatabaseReference dbref;//Used to reference our FB db.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2. Link our java widgets (Views) to their XML cunterparts
        fn = findViewById(R.id.et_firstname_register);
        sn = findViewById(R.id.et_surname_register);

        save = findViewById(R.id.btn_save_register);

        dbref = FirebaseDatabase.getInstance().getReference("_user_");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //User u = new User(fn.getText().toString(),sn.getText().toString());
               //dbref.child(dbref.push().getKey()).setValue(u);

                Toast.makeText(MainActivity.this, "Reg successfull", Toast.LENGTH_LONG).show();
            }
        });

    }



}
