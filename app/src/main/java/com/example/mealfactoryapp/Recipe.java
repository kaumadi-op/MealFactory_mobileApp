package com.example.mealfactoryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Recipe extends AppCompatActivity {

    EditText item, description, price;
    Button order_btn, view_btn;
    DatabaseReference dbRef, readRef;
    adminRecipe recipe;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        item = findViewById(R.id.item);
        description = findViewById(R.id.description);
        price = findViewById(R.id.price);

        order_btn = findViewById(R.id.order_btn);
        view_btn = findViewById(R.id.view_btn);

        recipe = new adminRecipe();

        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get a reference to our posts
                dbRef = FirebaseDatabase.getInstance().getReference().child("adminRecipe").child("CH1");
                // Attach a listener to read the data
                dbRef.addListenerForSingleValueEvent(new ValueEventListener(){
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChildren()){
                            String Item = dataSnapshot.child("item").getValue().toString();
                            String Description = dataSnapshot.child("description").getValue().toString();
                            String Price = dataSnapshot.child("price").getValue().toString();
                            item.setText(Item);
                            description.setText(Description);
                            price.setText(Price);
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
    }
}