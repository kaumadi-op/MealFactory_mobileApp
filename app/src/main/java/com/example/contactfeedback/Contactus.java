package com.example.contactfeedback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Contactus extends AppCompatActivity {
    EditText editTextTextPersonName, editTextTextEmailAddress2, editTextTextPersonName2;
    Button button;
    DatabaseReference dbRef;
    User user1;
    Button btnView;

    String name;

    //Method to clear all user inputs
    private void clearControls(){
        editTextTextPersonName.setText("");
        editTextTextEmailAddress2.setText("");
        editTextTextPersonName2.setText("");


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextEmailAddress2 = findViewById(R.id.editTextTextEmailAddress2);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);

        btnView = findViewById(R.id.buttonView);


        button = findViewById(R.id.button);


        user1 = new User();


        //set onclick listner to save button

        button.setOnClickListener(new View.OnClickListener(){

                                      @Override
                                      public void onClick(View v) {

                                          dbRef = FirebaseDatabase.getInstance().getReference().child("User");
                                          try{
                                              if (TextUtils.isEmpty(editTextTextPersonName.getText().toString()))
                                                  Toast.makeText(getApplicationContext(), "Please Enter Name", Toast.LENGTH_SHORT).show();
                                              else if (TextUtils.isEmpty(editTextTextEmailAddress2.getText().toString()))
                                                  Toast.makeText(getApplicationContext(), "Please Enter Email", Toast.LENGTH_SHORT).show();
                                              else if (TextUtils.isEmpty(editTextTextPersonName2.getText().toString()))
                                                  Toast.makeText(getApplicationContext(), "Please Enter Message", Toast.LENGTH_SHORT).show();
                                              else{
                                                  //Take inputs from the user and assigning them to this instance (std) of the student
                                                  user1.setName(editTextTextPersonName.getText().toString().trim());
                                                  user1.setEmail(editTextTextEmailAddress2.getText().toString().trim());
                                                  user1.setMessage(editTextTextPersonName2.getText().toString().trim());

                                                  //Insert in to the database
                                                  name = user1.getName();
                                                  dbRef.child("" + name).setValue(user1);

                                                  //Feedback to the user via a Toast
                                                  Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();

                                                  clearControls();

                                              }

                                          }
                                          catch(NullPointerException e){

                                              Toast.makeText(getApplicationContext(), "null", Toast.LENGTH_SHORT).show();
                                          }
                                      }
                                  }


        );
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Contactus.this,retrivecontactus.class);
                intent.putExtra("Name",user1.getName());
                startActivity(intent);
            }
        });

    }

}


