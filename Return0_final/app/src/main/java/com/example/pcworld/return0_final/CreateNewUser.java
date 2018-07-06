package com.example.pcworld.return0_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateNewUser extends AppCompatActivity implements View.OnClickListener {
    EditText emailedittext, passwordedittext, confpassedittext;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_user);
        emailedittext = (EditText) findViewById(R.id.editText_email);
        passwordedittext = (EditText) findViewById(R.id.editText_password1);
        confpassedittext = (EditText) findViewById(R.id.editText_password2);
       register = (Button) findViewById(R.id.button_register);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_register:
                String email = emailedittext.getText().toString();
                String password1 = passwordedittext.getText().toString();
                String password2 = confpassedittext.getText().toString();
                setUserInfoToServer(email, password1, password2);
                break;
//            case R.id.about_button:
//                Intent intent = new Intent(getBaseContext(), AboutappActivity.class);
//                startActivity(intent);
//
//                break;


        }
    }

    private void setUserInfoToServer(String email, String password1, String password2) {
        if (email.equals("") || password1.equals("") || password2.equals("")) {
            Toast.makeText(this, "Please Enter You EMail ,Password And Confirm Password ", Toast.LENGTH_SHORT).show();
        } else if (!password1.equals(password2)) {

            Toast.makeText(this, "Two Password are Not Equal", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, " Welcome ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getBaseContext(), freg1.class);
            startActivity(intent);
        }
    }


}
