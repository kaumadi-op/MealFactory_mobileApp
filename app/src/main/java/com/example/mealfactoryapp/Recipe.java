package com.example.mealfactoryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Recipe extends AppCompatActivity {

    Button order_btn, srilankan, indian, chinese, italian;
    ImageButton home_btn, bag_btn, favorite_btn, profile_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        srilankan = findViewById(R.id.srilankan);
        indian = findViewById(R.id.indian);
        chinese = findViewById(R.id.chinese);
        italian = findViewById(R.id.italian);

        home_btn = findViewById(R.id.home_btn);
        bag_btn = findViewById(R.id.bag_btn);
        favorite_btn = findViewById(R.id.favorite_btn);
        profile_btn = findViewById(R.id.profile_btn);

        order_btn = findViewById(R.id.order_btn);


        srilankan.setOnClickListener(new View.OnClickListener(){

                                         @Override
                                         public void onClick(View v){

                                             Intent Intent = new Intent (Recipe.this,MenuSl.class);
                                             startActivity(Intent);

                                             Log.i("lifecycle", "onClick method invoked");

                                         }
                                     }
        );

        indian.setOnClickListener(new View.OnClickListener(){

                                      @Override
                                      public void onClick(View v){

                                          Intent Intent = new Intent (Recipe.this,MenuSl.class);
                                          startActivity(Intent);

                                          Log.i("lifecycle", "onClick method invoked");

                                      }
                                  }
        );
        chinese.setOnClickListener(new View.OnClickListener(){

                                       @Override
                                       public void onClick(View v){

                                           Intent Intent = new Intent (Recipe.this,MenuSl.class);
                                           startActivity(Intent);

                                           Log.i("lifecycle", "onClick method invoked");

                                       }
                                   }
        );
        italian.setOnClickListener(new View.OnClickListener(){

                                       @Override
                                       public void onClick(View v){

                                           Intent Intent = new Intent (Recipe.this,MenuSl.class);
                                           startActivity(Intent);

                                           Log.i("lifecycle", "onClick method invoked");

                                       }
                                   }
        );

        home_btn.setOnClickListener(new View.OnClickListener(){

                                        @Override
                                        public void onClick(View v){

                                            Intent Intent = new Intent (Recipe.this,MenuSl.class);
                                            startActivity(Intent);

                                            Log.i("lifecycle", "onClick method invoked");

                                        }
                                    }
        );

        bag_btn.setOnClickListener(new View.OnClickListener(){

                                       @Override
                                       public void onClick(View v){

                                           Intent Intent = new Intent (Recipe.this,MenuSl.class);
                                           startActivity(Intent);

                                           Log.i("lifecycle", "onClick method invoked");

                                       }
                                   }
        );

        favorite_btn.setOnClickListener(new View.OnClickListener(){

                                            @Override
                                            public void onClick(View v){

                                                Intent Intent = new Intent (Recipe.this,Favorites.class);
                                                startActivity(Intent);

                                                Log.i("lifecycle", "onClick method invoked");

                                            }
                                        }
        );

        profile_btn.setOnClickListener(new View.OnClickListener(){

                                           @Override
                                           public void onClick(View v){

                                               Intent Intent = new Intent (Recipe.this,MyProfile.class);
                                               startActivity(Intent);

                                               Log.i("lifecycle", "onClick method invoked");

                                           }
                                       }
        );

    }
}