package com.example.mealfactoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button login_btn, register_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_btn = findViewById(R.id.login_btn);
        register_btn = findViewById(R.id.register_btn);

        Log.i( "lifecycle", "onCreate method invoked");

        login_btn.setOnClickListener(new View.OnClickListener(){

                                        @Override
                                        public void onClick(View v){

                                            Intent Intent = new Intent (MainActivity.this,ConfirmLogin.class);
                                            startActivity(Intent);

                                            Log.i("lifecycle", "onClick method invoked");

                                        }
                                    }
        );

        register_btn.setOnClickListener(new View.OnClickListener(){

                                         @Override
                                         public void onClick(View v){

                                             Intent Intent = new Intent (MainActivity.this,Register.class);
                                             startActivity(Intent);

                                             Log.i("lifecycle", "onClick method invoked");

                                         }
                                     }
        );




    }



}