package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainRegister extends AppCompatActivity {
//1. Declare imposter views
    private EditText id, fn, sn, em, pw, cpw;
    private Button btn_reg;
    private TextView tv_login_nav;

    //Declare instance of FB auth
    FirebaseAuth fbAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register);
        //initialise our fbAuth
        fbAuth = FirebaseAuth.getInstance();

//2. Link imposters to real XML views
        id = findViewById(R.id.et_studentid_register);
        fn = findViewById(R.id.et_fn_register);
        sn = findViewById(R.id.et_sn_register);
        em = findViewById(R.id.et_em_register);
        pw = findViewById(R.id.et_pw_register);
        cpw = findViewById(R.id.et_cpw_register);
        btn_reg = findViewById(R.id.btn_register_register);

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fbAuth.createUserWithEmailAndPassword(em.getText().toString(), pw.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        fbAuth.signInWithEmailAndPassword(em.getText().toString(), pw.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                User u = new User(fn.getText().toString(), sn.getText().toString(), id.getText().toString());
                                DatabaseReference dbref = FirebaseDatabase.getInstance().getReference("_user_");
                                dbref.child(fbAuth.getUid()).setValue(u);
                                fbAuth.signOut();
                                Toast.makeText(MainRegister.this, "Registration Successful", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        if(e instanceof FirebaseAuthInvalidCredentialsException)
                        Toast.makeText(MainRegister.this, "Email badly formatted", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}
