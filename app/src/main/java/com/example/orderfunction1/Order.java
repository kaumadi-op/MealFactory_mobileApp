package com.example.orderfunction1;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Order extends AppCompatActivity {

    Button delivery, takeaway;
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

        Order1 = new Order();


        //set onclick listner to save button


        delivery.setOnClickListener(new View.OnClickListener()

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



        );


    }
}
