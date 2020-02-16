package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    EditText em, pw;
    Button get;
    int index = 0;
    ArrayList<User> list = new ArrayList<>();//To store User objects
    DatabaseReference dbref;//If you want to retrive all records without descrimination
    //If you want to use a where clause Query object
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        em = findViewById(R.id.et_email);
        pw = findViewById(R.id.et_pw);
        get = findViewById(R.id.btn_login);
        dbref = FirebaseDatabase.getInstance().getReference("_user_");
        dbref.addListenerForSingleValueEvent(listener);

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                em.setText(list.get(index).getFn());
                pw.setText(list.get(index).getSn());
            }
        });

    }

    ValueEventListener listener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for(DataSnapshot dss: dataSnapshot.getChildren())
            {
                User u = dss.getValue(User.class);
                list.add(u);
            }
            em.setText(list.get(0).getFn());
            pw.setText(list.get(0).getSn());
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
}
