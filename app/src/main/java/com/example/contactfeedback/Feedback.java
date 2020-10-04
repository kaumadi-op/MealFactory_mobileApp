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

public class Feedback extends AppCompatActivity {
    EditText feedbackmsg;
    Button button3;
    DatabaseReference dbRef;
    feedbackcustomer feedbackcustomer1;

    int count = 1;


    //Method to clear all user inputs
    private void clearControls(){
        feedbackmsg.setText("");


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        feedbackmsg = findViewById(R.id.feedbackmsg);



        button3 = findViewById(R.id.button3);


        feedbackcustomer1 = new feedbackcustomer();


        //set onclick listner to save button

        button3.setOnClickListener(new View.OnClickListener(){

                                      @Override
                                      public void onClick(View v) {

                                          dbRef = FirebaseDatabase.getInstance().getReference().child("Feedbackcustomer");
                                          try{
                                              if (TextUtils.isEmpty(feedbackmsg.getText().toString()))
                                                  Toast.makeText(getApplicationContext(), "Please Enter message", Toast.LENGTH_SHORT).show();

                                              else{
                                                  //Take inputs from the user and assigning them to this instance (std) of the student
                                                  feedbackcustomer1.setMessage(feedbackmsg.getText().toString().trim());

                                                  //Insert in to the database
                                                  dbRef.child("Customer" + count).setValue(feedbackcustomer1);
                                                  count++;
                                                  //Feedback to the user via a Toast
                                                  Toast.makeText(getApplicationContext(), "Feedback saved", Toast.LENGTH_SHORT).show();
                                                  clearControls();


                                              }


                                          }

                                          catch(NullPointerException e){

                                              Toast.makeText(getApplicationContext(), "null", Toast.LENGTH_SHORT).show();
                                          }
                                      }
                                  }


        );

    }

}
