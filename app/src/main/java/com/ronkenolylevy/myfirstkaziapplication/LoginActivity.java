package com.ronkenolylevy.myfirstkaziapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText mbtnemail,mbtnpassword;
    Button mbtnlogin;
    TextView mbtnsignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mbtnemail = findViewById(R.id.edt_email);
        mbtnpassword = findViewById(R.id.edt_pass);
        mbtnlogin = findViewById(R.id.btn_login);
        mbtnsignup = findViewById(R.id.edt_signup);

        mbtnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mbtnemail.getText().toString().trim();
                String password = mbtnpassword.getText().toString().trim();
                if (email.isEmpty()){
                    mbtnemail.setError("please fill this field");
                    return;
                }else  if (password.isEmpty()){
                    mbtnpassword.setError("please fill this field");
                    return;
                }
                startActivity(new Intent(LoginActivity.this,LandingActivity.class));
            }
        });
        mbtnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));

            }
        });

    }
}

