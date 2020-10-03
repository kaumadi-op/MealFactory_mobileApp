package com.example.mealfactoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;

public class MenuSl extends AppCompatActivity {

    Button srilankan, indian, chinese, italian;
    ImageButton home_btn, bag_btn, favorite_btn, profile_btn;


    private void getRecipe(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_sl);

        srilankan = findViewById(R.id.srilankan);
        indian = findViewById(R.id.indian);
        chinese = findViewById(R.id.chinese);
        italian = findViewById(R.id.italian);

        home_btn = findViewById(R.id.home_btn);
        bag_btn = findViewById(R.id.bag_btn);
        favorite_btn = findViewById(R.id.favorite_btn);
        profile_btn = findViewById(R.id.profile_btn);

        srilankan.setOnClickListener(new View.OnClickListener(){

                                           @Override
                                           public void onClick(View v){

                                               Intent Intent = new Intent (MenuSl.this,MenuSl.class);
                                               startActivity(Intent);

                                               Log.i("lifecycle", "onClick method invoked");

                                           }
                                       }
        );

        indian.setOnClickListener(new View.OnClickListener(){

                                           @Override
                                           public void onClick(View v){

                                               Intent Intent = new Intent (MenuSl.this,MenuSl.class);
                                               startActivity(Intent);

                                               Log.i("lifecycle", "onClick method invoked");

                                           }
                                       }
        );
        chinese.setOnClickListener(new View.OnClickListener(){

                                           @Override
                                           public void onClick(View v){

                                               Intent Intent = new Intent (MenuSl.this,MenuSl.class);
                                               startActivity(Intent);

                                               Log.i("lifecycle", "onClick method invoked");

                                           }
                                       }
        );
        italian.setOnClickListener(new View.OnClickListener(){

                                           @Override
                                           public void onClick(View v){

                                               Intent Intent = new Intent (MenuSl.this,MenuSl.class);
                                               startActivity(Intent);

                                               Log.i("lifecycle", "onClick method invoked");

                                           }
                                       }
        );

        home_btn.setOnClickListener(new View.OnClickListener(){

                                           @Override
                                           public void onClick(View v){

                                               Intent Intent = new Intent (MenuSl.this,MenuSl.class);
                                               startActivity(Intent);

                                               Log.i("lifecycle", "onClick method invoked");

                                           }
                                       }
        );

        bag_btn.setOnClickListener(new View.OnClickListener(){

                                           @Override
                                           public void onClick(View v){

                                               Intent Intent = new Intent (MenuSl.this,MenuSl.class);
                                               startActivity(Intent);

                                               Log.i("lifecycle", "onClick method invoked");

                                           }
                                       }
        );

        favorite_btn.setOnClickListener(new View.OnClickListener(){

                                           @Override
                                           public void onClick(View v){

                                               Intent Intent = new Intent (MenuSl.this,Favorites.class);
                                               startActivity(Intent);

                                               Log.i("lifecycle", "onClick method invoked");

                                           }
                                       }
        );

        profile_btn.setOnClickListener(new View.OnClickListener(){

                                         @Override
                                         public void onClick(View v){

                                             Intent Intent = new Intent (MenuSl.this,MyProfile.class);
                                             startActivity(Intent);

                                             Log.i("lifecycle", "onClick method invoked");

                                         }
                                     }
        );

    }
}