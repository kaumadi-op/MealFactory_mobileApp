package com.example.foodfactory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompatExtras;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText Name1, Contact1, Address1, Location1;
    Button Sub_btn, Next;


    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hooks
        Name1 = findViewById(R.id.name1);
        //Contact1 = findViewById(R.id.exdate);
        Address1 = findViewById(R.id.cardno);
        //Location1 = findViewById(R.id.code);
        //Sub_btn = findViewById(R.id.pay);
        //Next = findViewById(R.id.Make_pay);


        //save data in firebase
        Sub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Delivery");

                String name = Name1.getEditableText().toString();
                String ContactNo = Contact1.getEditableText().toString();
                String Address = Address1.getEditableText().toString();
                String Location = Location1.getEditableText().toString();

                Delivery delivery = new Delivery(name, Address, Location, ContactNo);

                reference.child(ContactNo).setValue(delivery);
            }

        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Dilivery.class);
                startActivity(intent);
            }
        });
    }

}
