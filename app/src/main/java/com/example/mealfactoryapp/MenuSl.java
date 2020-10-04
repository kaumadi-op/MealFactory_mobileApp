package com.example.mealfactoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuSl extends AppCompatActivity {

    Button srilankan, indian, chinese, italian, order_btn, order_btn2;
    ImageButton home_btn, bag_btn, favorite_btn, profile_btn;

    int recipe;

    public int returnRecipe(){
        return recipe;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_sl);

        srilankan = findViewById(R.id.srilankan);
        indian = findViewById(R.id.indian);
        chinese = findViewById(R.id.chinese);
        italian = findViewById(R.id.italian);
        order_btn = findViewById(R.id.order_btn);
        order_btn2 = findViewById(R.id.order_btn);

        home_btn = findViewById(R.id.home_btn);
        bag_btn = findViewById(R.id.bag_btn);
        favorite_btn = findViewById(R.id.favorite_btn);
        profile_btn = findViewById(R.id.profile_btn);

        order_btn.setOnClickListener(new View.OnClickListener(){

                                         @Override
                                         public void onClick(View v){

                                             recipe = 1;
                                             returnRecipe();

                                             Intent Intent = new Intent (MenuSl.this,MenuSl.class);
                                             startActivity(Intent);

                                             Log.i("lifecycle", "onClick method invoked");

                                         }
                                     }
        );

        order_btn2.setOnClickListener(new View.OnClickListener(){

                                         @Override
                                         public void onClick(View v){

                                             recipe = 2;
                                             returnRecipe();

                                             Intent Intent = new Intent (MenuSl.this,Recipe.class);
                                             startActivity(Intent);

                                             Log.i("lifecycle", "onClick method invoked");

                                         }
                                     }
        );




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

                                               Intent Intent = new Intent (MenuSl.this,MenuIn.class);
                                               startActivity(Intent);

                                               Log.i("lifecycle", "onClick method invoked");

                                           }
                                       }
        );
        chinese.setOnClickListener(new View.OnClickListener(){

                                           @Override
                                           public void onClick(View v){

                                               Intent Intent = new Intent (MenuSl.this,MenuCh.class);
                                               startActivity(Intent);

                                               Log.i("lifecycle", "onClick method invoked");

                                           }
                                       }
        );
        italian.setOnClickListener(new View.OnClickListener(){

                                           @Override
                                           public void onClick(View v){

                                               Intent Intent = new Intent (MenuSl.this,MenuIt.class);
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