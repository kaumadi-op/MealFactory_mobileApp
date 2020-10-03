package com.example.mealfactoryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyProfile extends AppCompatActivity {

    TextView name, email, mobile;
    EditText editTextTextPersonName, editTextTextEmailAddress,editTextPhone;
    Button show_btn,update_btn, deleteProf_btn;
    ImageButton home_btn, bag_btn, favorite_btn, profile_btn;
    DatabaseReference dbRef, upRef;
    RegisterUser user1;
    ConfirmLogin log1;

    int phone;

    private void clearControls(){
        editTextTextPersonName.setText("");
        editTextTextEmailAddress.setText("");
        editTextPhone.setText("");

    }

    private int getUser(){
        return phone = log1.returnUser();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextPhone = findViewById(R.id.editTextPhone);

        show_btn = findViewById(R.id.show_btn);
        update_btn = findViewById(R.id.update_btn);
        deleteProf_btn = findViewById(R.id.deleteProf_btn);

        home_btn = findViewById(R.id.home_btn);
        bag_btn = findViewById(R.id.bag_btn);
        favorite_btn = findViewById(R.id.favorite_btn);
        profile_btn = findViewById(R.id.profile_btn);

        user1 = new RegisterUser();

        show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getUser();
                // Get a reference to our posts
                dbRef = FirebaseDatabase.getInstance().getReference().child("RegisterUser").child(""+ phone);
                // Attach a listener to read the data
                dbRef.addListenerForSingleValueEvent(new ValueEventListener(){
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChildren()){
                            String Name = dataSnapshot.child("name").getValue().toString();
                            String Email = dataSnapshot.child("email").getValue().toString();
                            String Phone = dataSnapshot.child("phone").getValue().toString();
                            editTextTextPersonName.setText(Name);
                            editTextTextEmailAddress.setText(Email);
                            editTextPhone.setText(Phone);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"No source to Display",Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        update_btn.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              upRef = FirebaseDatabase.getInstance().getReference().child("RegisterUser");
                                              upRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                                  @Override
                                                  public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                      if(dataSnapshot.hasChild("" + phone)){
                                                          try{
                                                              user1.setName(editTextTextPersonName.getText().toString().trim());
                                                              user1.setPhone(Integer.parseInt(editTextPhone.getText().toString().trim()));
                                                              user1.setEmail(editTextTextEmailAddress.getText().toString().trim());

                                                              upRef = FirebaseDatabase.getInstance().getReference().child("RegisterUser").child(""+phone);
                                                              upRef.setValue(user1);

                                                              Toast.makeText(getApplicationContext(), "Data updated successfully", Toast.LENGTH_SHORT).show();


                                                          }
                                                          catch(NumberFormatException e){
                                                              Toast.makeText(getApplicationContext(), "Invalid number format", Toast.LENGTH_SHORT).show();

                                                          }

                                                      }
                                                      else{
                                                          Toast.makeText(getApplicationContext(),"No source to Update",Toast.LENGTH_SHORT).show();
                                                      }
                                                  }

                                                  @Override
                                                  public void onCancelled(@NonNull DatabaseError databaseError) {

                                                  }
                                              });

                                          }
                                      }

        );



    }

}