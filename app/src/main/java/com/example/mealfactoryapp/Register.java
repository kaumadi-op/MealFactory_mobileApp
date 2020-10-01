package com.example.mealfactoryapp;

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

public class Register extends AppCompatActivity {

    EditText name1, mobile1;
    Button back_btn, next_btn2;
    DatabaseReference dbRef;
    User user1;

    private void clearControls(){
        name1.setText("");
        mobile1.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name1 = findViewById(R.id.name1);
        mobile1 = findViewById(R.id.mobile1);

        back_btn = findViewById(R.id.back_btn);
        next_btn2 = findViewById(R.id.next_btn2);

        user1 = new User();

        //set onclick listener to save button
        next_btn2.setOnClickListener(new View.OnClickListener(){

                                        @Override
                                        public void onClick(View v) {

                                            dbRef = FirebaseDatabase.getInstance().getReference().child("User");
                                            try{
                                                if (TextUtils.isEmpty(name1.getText().toString()))
                                                    Toast.makeText(getApplicationContext(), "Insert the Name", Toast.LENGTH_SHORT).show();

                                                else{
                                                    //Take inputs from the user and assigning them to this instance (user1) of the User
                                                    user1.setName(name1.getText().toString().trim());
                                                    user1.setPhone(Integer.parseInt(mobile1.getText().toString().trim()));

                                                    //Insert in to the database
                                                    dbRef.push().setValue(user1);

                                                    //Feedback to the user via a Toast
                                                    Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
                                                    clearControls();

                                                }

                                                Intent Intent = new Intent (Register.this,MenuSl.class);
                                                startActivity(Intent);


                                            }

                                            catch(NumberFormatException e){

                                                Toast.makeText(getApplicationContext(), "Invalid number format", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }


        );


    }
}