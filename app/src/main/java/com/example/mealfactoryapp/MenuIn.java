package com.example.mealfactoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuIn extends AppCompatActivity {

    Button srilankan, indian, chinese, italian, order_btn;
    ImageButton home_btn, bag_btn, favorite_btn, profile_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_in);

        srilankan = findViewById(R.id.srilankan);
        indian = findViewById(R.id.indian);
        chinese = findViewById(R.id.chinese);
        italian = findViewById(R.id.italian);
        order_btn = findViewById(R.id.order_btn);

        home_btn = findViewById(R.id.home_btn);
        bag_btn = findViewById(R.id.bag_btn);
        favorite_btn = findViewById(R.id.favorite_btn);
        profile_btn = findViewById(R.id.profile_btn);

        order_btn.setOnClickListener(new View.OnClickListener(){

                                         @Override
                                         public void onClick(View v){

                                             Intent Intent = new Intent (MenuIn.this,MenuIn.class);
                                             startActivity(Intent);

                                             Log.i("lifecycle", "onClick method invoked");

                                         }
                                     }
        );


        srilankan.setOnClickListener(new View.OnClickListener(){

                                         @Override
                                         public void onClick(View v){

                                             Intent Intent = new Intent (MenuIn.this,MenuSl.class);
                                             startActivity(Intent);

                                             Log.i("lifecycle", "onClick method invoked");

                                         }
                                     }
        );

        indian.setOnClickListener(new View.OnClickListener(){

                                      @Override
                                      public void onClick(View v){

                                          Intent Intent = new Intent (MenuIn.this,MenuIn.class);
                                          startActivity(Intent);

                                          Log.i("lifecycle", "onClick method invoked");

                                      }
                                  }
        );
        chinese.setOnClickListener(new View.OnClickListener(){

                                       @Override
                                       public void onClick(View v){

                                           Intent Intent = new Intent (MenuIn.this,MenuCh.class);
                                           startActivity(Intent);

                                           Log.i("lifecycle", "onClick method invoked");

                                       }
                                   }
        );
        italian.setOnClickListener(new View.OnClickListener(){

                                       @Override
                                       public void onClick(View v){

                                           Intent Intent = new Intent (MenuIn.this,MenuIt.class);
                                           startActivity(Intent);

                                           Log.i("lifecycle", "onClick method invoked");

                                       }
                                   }
        );

        home_btn.setOnClickListener(new View.OnClickListener(){

                                        @Override
                                        public void onClick(View v){

                                            Intent Intent = new Intent (MenuIn.this,MenuSl.class);
                                            startActivity(Intent);

                                            Log.i("lifecycle", "onClick method invoked");

                                        }
                                    }
        );

        bag_btn.setOnClickListener(new View.OnClickListener(){

                                       @Override
                                       public void onClick(View v){

                                           Intent Intent = new Intent (MenuIn.this,MenuSl.class);
                                           startActivity(Intent);

                                           Log.i("lifecycle", "onClick method invoked");

                                       }
                                   }
        );

        favorite_btn.setOnClickListener(new View.OnClickListener(){

                                            @Override
                                            public void onClick(View v){

                                                Intent Intent = new Intent (MenuIn.this,Favorites.class);
                                                startActivity(Intent);

                                                Log.i("lifecycle", "onClick method invoked");

                                            }
                                        }
        );

        profile_btn.setOnClickListener(new View.OnClickListener(){

                                           @Override
                                           public void onClick(View v){

                                               Intent Intent = new Intent (MenuIn.this,MyProfile.class);
                                               startActivity(Intent);

                                               Log.i("lifecycle", "onClick method invoked");

                                           }
                                       }
        );

    }
}