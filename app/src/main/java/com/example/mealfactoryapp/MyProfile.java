package com.example.mealfactoryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyProfile extends AppCompatActivity {

    EditText editTextTextPersonName, editTextTextEmailAddress,editTextPhone;
    Button show_btn,update_btn, deleteProf_btn;
    ImageButton home_btn, bag_btn, favorite_btn, profile_btn;
    DatabaseReference dbRef, upRef, delRef;
    RegisterUser user1;
    Register user;
    ConfirmLogin log1;

    Integer phone;

    public Integer getUser(){
        phone = user.returnUser();
        return phone;
    }

    private void clearControls(){
        editTextTextPersonName.setText("");
        editTextTextEmailAddress.setText("");
        editTextPhone.setText("");

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

                //phone = getUser();
                // Get a reference to our posts
                dbRef = FirebaseDatabase.getInstance().getReference().child("RegisterUser").child("777654322");
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
                                                      if(dataSnapshot.hasChild("777654322")){
                                                          try{
                                                              user1.setName(editTextTextPersonName.getText().toString().trim());
                                                              user1.setPhone(Integer.parseInt(editTextPhone.getText().toString().trim()));
                                                              user1.setEmail(editTextTextEmailAddress.getText().toString().trim());

                                                              upRef = FirebaseDatabase.getInstance().getReference().child("RegisterUser").child("777654322");
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

        deleteProf_btn.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              delRef = FirebaseDatabase.getInstance().getReference().child("RegisterUser");
                                              delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                                  @Override
                                                  public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                      if(dataSnapshot.hasChild("777654322")){
                                                          try{
                                                              delRef = FirebaseDatabase.getInstance().getReference().child("RegisterUser").child("777654322");
                                                              delRef.removeValue();
                                                              clearControls();

                                                              Toast.makeText(getApplicationContext(), "Account deleted", Toast.LENGTH_SHORT).show();

                                                              Intent Intent = new Intent(MyProfile.this,MainActivity.class);
                                                              startActivity(Intent);
                                                          }
                                                          catch(NullPointerException e){
                                                              Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_SHORT).show();
                                                          }
                                                      }
                                                      else{
                                                          Toast.makeText(getApplicationContext(),"No source to Delete",Toast.LENGTH_SHORT).show();
                                                      }
                                                  }
                                                  @Override
                                                  public void onCancelled(@NonNull DatabaseError databaseError) {
                                                  }
                                              });

                                          }
                                      }

        );

        home_btn.setOnClickListener(new View.OnClickListener(){

                                        @Override
                                        public void onClick(View v){

                                            Intent Intent = new Intent (MyProfile.this,MenuSl.class);
                                            startActivity(Intent);

                                            Log.i("lifecycle", "onClick method invoked");

                                        }
                                    }
        );

        bag_btn.setOnClickListener(new View.OnClickListener(){

                                       @Override
                                       public void onClick(View v){

                                           Intent Intent = new Intent (MyProfile.this,MenuSl.class);
                                           startActivity(Intent);

                                           Log.i("lifecycle", "onClick method invoked");

                                       }
                                   }
        );

        favorite_btn.setOnClickListener(new View.OnClickListener(){

                                            @Override
                                            public void onClick(View v){

                                                Intent Intent = new Intent (MyProfile.this,Favorites.class);
                                                startActivity(Intent);

                                                Log.i("lifecycle", "onClick method invoked");

                                            }
                                        }
        );

        profile_btn.setOnClickListener(new View.OnClickListener(){

                                           @Override
                                           public void onClick(View v){

                                               Intent Intent = new Intent (MyProfile.this,MyProfile.class);
                                               startActivity(Intent);

                                               Log.i("lifecycle", "onClick method invoked");

                                           }
                                       }
        );

    }

}