package com.ronkenolylevy.myfirstkaziapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    EditText medtname,medtemail,medtpass,medtconpass,medtgender,medtage;
    Button mbtnregister;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_a_ctivity);
        medtname = findViewById(R.id.edt_name);
        medtemail = findViewById(R.id.edt_email);
        medtpass = findViewById(R.id.edt_pass);
        medtconpass = findViewById(R.id.edt_con_pass);
        medtgender = findViewById(R.id.edt_gender);
        medtage = findViewById(R.id.edt_age);
        mbtnregister = findViewById(R.id.btn_reg);

        dialog = new ProgressDialog(this);
        dialog.setTitle("saving");
        dialog.setMessage("please wait...");

        mbtnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = medtname.getText().toString().trim();
                String email = medtemail.getText().toString().trim();
                String password = medtpass.getText().toString().trim();
                String conpassword = medtconpass.getText().toString().trim();
                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    String time = String.valueOf( System.currentTimeMillis());
                    //connect to the database
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("people/"+time);
                    person person = new person(name,email,password,time);
                    dialog.show();
                    ref.setValue(person).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            dialog.dismiss();
                            if (task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "Person saved successfully", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(RegisterActivity.this, "registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });
    }
}