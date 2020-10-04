package com.example.mealfactoryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Order extends AppCompatActivity {

    Button delivery, takeaway,feedback,contactus;
    DatabaseReference dbRef;
    Order Order1;

    //Method to clear all user inputs
    private void clearControls(){


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        delivery = findViewById(R.id.delivery);
        takeaway = findViewById(R.id.takeaway);
        feedback = findViewById(R.id.feedback);
        contactus = findViewById(R.id.contactus);

        Order1 = new Order();


        //set onclick listner to save button
        takeaway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Order.this, Takeaway.class);
                startActivity(intent);
            }
        });

        delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Order.this, EnterDelivery.class);
                startActivity(intent);
            }
        });

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Order.this, Feedback.class);
                startActivity(intent);
            }
        });

        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Order.this, Contactus.class);
                startActivity(intent);
            }
        });


        /*delivery.setOnClickListener(new View.OnClickListener()

                                    {

                                        @Override
                                        public void onClick(View v) {

                                            dbRef = FirebaseDatabase.getInstance().getReference().child("Order");



                                        }



                                    }



        );

        takeaway.setOnClickListener(new View.OnClickListener()

                                    {

                                        @Override
                                        public void onClick(View v) {

                                            dbRef = FirebaseDatabase.getInstance().getReference().child("Order");



                                        }



                                    }




        );*/

    }
}
