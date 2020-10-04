package com.example.orderfunction1;

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

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    EditText editTextTextPersonName, editTextTextPersonName2, editTextTextPersonName3;
    Button submitbtn, Viewbtn;
    DatabaseReference dbRef;
    user user1;


    String id;

    //Method to clear all user inputs
    private void clearControls(){
        editTextTextPersonName.setText("");
        editTextTextPersonName2.setText("");
        editTextTextPersonName3.setText("");


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.takeaway);



        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName2= findViewById(R.id.editTextTextPersonName2);
        editTextTextPersonName3 = findViewById(R.id.editTextTextPersonName3);





        submitbtn = findViewById(R.id.submitbtn);
                Viewbtn = findViewById(R.id.Viewbtn);

        user1 = new user();


        //set onclick listner to save button


                submitbtn.setOnClickListener(new View.OnClickListener()
                {

                                       @Override
                                       public void onClick(View v) {

                                           dbRef = FirebaseDatabase.getInstance().getReference().child("user");
                                            try{
                                               if (TextUtils.isEmpty(editTextTextPersonName.getText().toString()))
                                                   Toast.makeText(getApplicationContext(), "Please enter name", Toast.LENGTH_SHORT).show();
                                               else if (TextUtils.isEmpty(editTextTextPersonName2.getText().toString()))
                                                   Toast.makeText(getApplicationContext(), "Please enter ID", Toast.LENGTH_SHORT).show();
                                               else if (TextUtils.isEmpty(editTextTextPersonName3.getText().toString()))
                                                   Toast.makeText(getApplicationContext(), "Please enter Phone", Toast.LENGTH_SHORT).show();
                                               else{
                                                   //Take inputs from the user and assigning them to this instance (std) of the student
                                                   user1.setName(editTextTextPersonName.getText().toString().trim());
                                                   user1.setID((editTextTextPersonName2.getText().toString().trim()));
                                                   user1.setPhone(editTextTextPersonName3.getText().toString().trim());

                                                   //Insert in to the database
                                                   id = user1.getID();
                                                   dbRef.child(id).setValue(user1);

                                                   //Feedback to the user via a Toast
                                                   Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
                                                   // clearControls();


                                               }


                                           }
                                            catch(Exception e){
                                               Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();
                                           }
                                       }
                                   }


        );
        Viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,history.class);
                intent.putExtra("id",user1.getName());
                startActivity(intent);
            }
        });

    }
}


