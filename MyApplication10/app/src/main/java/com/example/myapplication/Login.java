package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    EditText id, em, pw;
    Button btn_login;
    FirebaseAuth fbAuth; //Used to sign in to FB
    Query dbref; //Used to read record from FB db
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        id = findViewById(R.id.et_id);
        em = findViewById(R.id.et_email);
        pw =findViewById(R.id.et_pw);
        btn_login = findViewById(R.id.btn_login);

        fbAuth = FirebaseAuth.getInstance();//Initialise our FB auth instance

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fbAuth.signInWithEmailAndPassword(em.getText().toString(), pw.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                        ValueEventListener listener = new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                for(DataSnapshot dss: dataSnapshot.getChildren())
                                {
                                    Session.LiveSession.user = dss.getValue(User.class);
                                }
                                if(Session.LiveSession.user != null)
                                {
                                    Toast.makeText(Login.this, Session.LiveSession.user.getFn() + " " +Session.LiveSession.user.getSn(), Toast.LENGTH_LONG).show();
                                    //Go to dashboard
                                }
                                else
                                {
                                    Toast.makeText(Login.this, "Sign in failed", Toast.LENGTH_LONG).show();
                                    fbAuth.signOut();
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        };
                        dbref = FirebaseDatabase.getInstance().getReference("_user_").orderByChild("id").equalTo(id.getText().toString());
                        dbref.addListenerForSingleValueEvent(listener);
                    }
                });
            }
        });


    }
}
