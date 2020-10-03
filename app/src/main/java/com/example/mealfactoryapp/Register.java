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

    EditText name1, mobile1, email1;
    Button back_btn, next_btn2;
    DatabaseReference dbRef;
    RegisterUser user1;

    int phone;

    private void clearControls(){
        name1.setText("");
        mobile1.setText("");
        email1.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name1 = findViewById(R.id.name1);
        mobile1 = findViewById(R.id.mobile1);
        email1 = findViewById(R.id.email1);

        back_btn = findViewById(R.id.back_btn);
        next_btn2 = findViewById(R.id.next_btn2);

        user1 = new RegisterUser();

        //set onclick listener to next button
        next_btn2.setOnClickListener(new View.OnClickListener(){

                                        @Override
                                        public void onClick(View v) {

                                            dbRef = FirebaseDatabase.getInstance().getReference().child("RegisterUser");
                                            try{
                                                if (TextUtils.isEmpty(name1.getText().toString()))
                                                    Toast.makeText(getApplicationContext(), "Insert the Name", Toast.LENGTH_SHORT).show();
                                                else if (TextUtils.isEmpty(email1.getText().toString()))
                                                    Toast.makeText(getApplicationContext(), "Insert the Email", Toast.LENGTH_SHORT).show();

                                                else{
                                                    //Take inputs from the user and assigning them to this instance (user1) of the RegisterUser
                                                    user1.setName(name1.getText().toString().trim());
                                                    user1.setPhone(Integer.parseInt(mobile1.getText().toString().trim()));
                                                    user1.setEmail(email1.getText().toString().trim());

                                                    //Insert in to the database
                                                    phone = user1.getPhone();

                                                    dbRef.child("" + phone).setValue(user1);



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

        //set onclick listner to back button
        back_btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {

                                            Intent Intent = new Intent(Register.this,MainActivity.class);
                                            startActivity(Intent);
                                        }
                                    }
        );


    }
}