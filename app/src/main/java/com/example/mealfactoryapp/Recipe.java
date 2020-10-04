package com.example.mealfactoryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Recipe extends AppCompatActivity {

    Button order_btn, srilankan, indian, chinese, italian;
    ImageButton home_btn, bag_btn, favorite_btn, profile_btn;
    EditText itemCode, unitPrice, qty;
    TextView recipeTitle;
    RecipeDetails recipeDetail;

    String itemCode_,unitPrice_, recipeTitle_;
    Integer qty_;

    MenuSl sl;
    MenuIn in;
    MenuCh ch;
    MenuIt it;

    int recipe;

    private void getRecipe(){

        recipe = sl.returnRecipe();
        recipe = in.returnRecipe();
        recipe = ch.returnRecipe();
        recipe = it.returnRecipe();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        recipeTitle = findViewById(R.id.recipeTitle);
        itemCode = findViewById(R.id.itemCode);
        unitPrice = findViewById(R.id.unitPrice);
        qty = findViewById(R.id.qty);

        srilankan = findViewById(R.id.srilankan);
        indian = findViewById(R.id.indian);
        chinese = findViewById(R.id.chinese);
        italian = findViewById(R.id.italian);

        home_btn = findViewById(R.id.home_btn);
        bag_btn = findViewById(R.id.bag_btn);
        favorite_btn = findViewById(R.id.favorite_btn);
        profile_btn = findViewById(R.id.profile_btn);

        order_btn = findViewById(R.id.order_btn);

        /*getRecipe();

        if (recipe == 1 ){

            recipeDetail.setQty(Integer.parseInt(qty.getText().toString().trim()));
            qty_ = recipeDetail.getQty();
            recipeDetail.setItemCode("SL001");
            recipeDetail.setRecipeTitle("Rice & Curry Egg");
            recipeDetail.setUnitPrice("Rs.180.00");

        }
        if (recipe == 1 ){

            recipeDetail.setQty(Integer.parseInt(qty.getText().toString().trim()));
            qty_ = recipeDetail.getQty();
            recipeDetail.setItemCode("SL001");
            recipeDetail.setRecipeTitle("Rice & Curry Egg");
            recipeDetail.setUnitPrice("Rs.180.00");

        }
        else if (recipe == 2 ){

            recipeDetail.setQty(Integer.parseInt(qty.getText().toString().trim()));
            qty_ = recipeDetail.getQty();
            recipeDetail.setItemCode("SL002");
            recipeDetail.setRecipeTitle("Rice & Curry Chicken");
            recipeDetail.setUnitPrice("Rs.250.00");

        }*/



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