package com.example.mealfactoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminInsertMenuActivity extends AppCompatActivity {

    EditText insertItem, insertItemCode, insertDescription, insertPrice;
    Button save_btn, imageUploadButton;
    DatabaseReference dbRef;
    adminRecipe recipe;

    private void clearControls(){
        insertItem.setText("");
        insertItemCode.setText("");
        insertDescription.setText("");
        insertPrice.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_insert_menu);

        insertItem = findViewById(R.id.insertItem);
        insertItemCode = findViewById(R.id.insertItemCode);
        insertDescription = findViewById(R.id.insertDescription);
        insertPrice = findViewById(R.id.insertPrice);

        save_btn = findViewById(R.id.save_btn);

        recipe = new adminRecipe();

        //set onclick listner to save button

        save_btn.setOnClickListener(new View.OnClickListener(){

                                       @Override
                                       public void onClick(View v) {

                                           dbRef = FirebaseDatabase.getInstance().getReference().child("adminRecipe");
                                           try{
                                               if (TextUtils.isEmpty(insertItem.getText().toString()))
                                                   Toast.makeText(getApplicationContext(), "Insert Item Name", Toast.LENGTH_SHORT).show();
                                               else if (TextUtils.isEmpty(insertItemCode.getText().toString()))
                                                   Toast.makeText(getApplicationContext(), "Insert Item Code", Toast.LENGTH_SHORT).show();
                                               else if (TextUtils.isEmpty(insertDescription.getText().toString()))
                                                   Toast.makeText(getApplicationContext(), "Insert Description", Toast.LENGTH_SHORT).show();
                                               else if (TextUtils.isEmpty(insertPrice.getText().toString()))
                                                   Toast.makeText(getApplicationContext(), "Insert Price", Toast.LENGTH_SHORT).show();
                                               else{
                                                   //Take inputs from the user and assigning them to this instance (recipe) of the adminRecipe
                                                   recipe.setName(insertItem.getText().toString().trim());
                                                   recipe.setCode(insertItemCode.getText().toString().trim());
                                                   recipe.setDescription(insertDescription.getText().toString().trim());
                                                   recipe.setPrice(insertPrice.getText().toString().trim());

                                                   //Insert in to the database
                                                   dbRef.push().setValue(recipe);

                                                   //Feedback to the user via a Toast
                                                   Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
                                                   clearControls();


                                               }


                                           }

                                           catch(NullPointerException e){

                                               Toast.makeText(getApplicationContext(), "Null", Toast.LENGTH_SHORT).show();
                                           }
                                       }
                                   }


        );

    }


}
