package com.ronkenolylevy.myfirstkaziapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UsersActivity extends AppCompatActivity {
    ListView mlistpeople;
    ArrayList<person> people;
    CustomAdapter adapter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        mlistpeople = findViewById(R.id.list_people);
        people = new ArrayList<>();
        adapter = new CustomAdapter(this,people);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading");
        dialog.setMessage("Please wait..");

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("people");
        //show the dialog and start loading data
        dialog.show();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                people.clear();
                for (DataSnapshot snap: snapshot.getChildren()){
                    person person = snap.getValue(person.class);
                    people.add(person);
                }
                dialog.dismiss();
                adapter.notifyDataSetChanged();
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mlistpeople.setAdapter(adapter);


    }
}