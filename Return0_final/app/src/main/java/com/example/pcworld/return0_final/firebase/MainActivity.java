package com.example.pcworld.return0_final.firebase;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pcworld.return0_final.ListmainActivity;
import com.example.pcworld.return0_final.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    EditText emailEditText, passwordEditText;
    Button login, newUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailEditText = (EditText) findViewById(R.id.editText_email0);
        passwordEditText = (EditText) findViewById(R.id.editText_password0);
        login = (Button) findViewById(R.id.button_login);
        newUser = (Button) findViewById(R.id.button_newUser);
        newUser.setOnClickListener(this);
       login.setOnClickListener(this);
    }
    private void setUserInfoToServer(String email, String password) {
        if(email.equals("")||password.equals("")){
            Toast.makeText(MainActivity.this, "Please Enter You EMail And Password", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_login:
                String email=emailEditText.getText().toString();
                String password=passwordEditText.getText().toString();
                setUserInfoToServer(email,password);
                /////firebase
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"User Is Exist",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this,ListmainActivity.class));
                        }else {
                            Toast.makeText(MainActivity.this, " Invalid Email Or Password ", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

                break;
            case R.id.button_newUser:

                Intent intent=new Intent(this,CreateNewUser.class);
                startActivity(intent);
                //startActivity(new Intent(this,CreateNewUser.class));

                break;
        }
    }

}
