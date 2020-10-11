package com.example.mealfactoryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ConfirmLogin extends AppCompatActivity {


    EditText mobile_enter;
    Button next_btn, back_btn;
    DatabaseReference readRef;
    RegisterUser user;

    int phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_login);


        mobile_enter = findViewById(R.id.mobile_enter);
        next_btn = findViewById(R.id.next_btn);
        back_btn = findViewById(R.id.back_btn);

        user = new RegisterUser();

        //set onclick listner to next button
        next_btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {

                                            phone = user.getPhone();
                                            final String ph = Integer.toString(phone);

                                            readRef = FirebaseDatabase.getInstance().getReference().child("RegisterUser");
                                            // Attach a listener to read the data
                                            readRef.addListenerForSingleValueEvent(new ValueEventListener(){

                                                @Override
                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                    if(dataSnapshot.hasChild(Integer.toString(phone)) ){
                                                        readRef = FirebaseDatabase.getInstance().getReference().child("RegisterUser").child(Integer.toString(phone));

                                                        Intent Intent = new Intent(ConfirmLogin.this,MenuSl.class);
                                                        startActivity(Intent);

                                                        Toast.makeText(getApplicationContext(), "Login success!!", Toast.LENGTH_SHORT).show();
                                                    }
                                                    else{
                                                        Toast.makeText(getApplicationContext(),"Invalid login",Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                                @Override
                                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                                }
                                            });
                                        }
                                    }
        );

        //set onclick listner to back button
        back_btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {

                                            Intent Intent = new Intent(ConfirmLogin.this,MainActivity.class);
                                            startActivity(Intent);
                                        }
                                    }
        );

    }
}