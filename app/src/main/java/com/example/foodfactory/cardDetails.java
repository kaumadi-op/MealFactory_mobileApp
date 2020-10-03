package com.example.foodfactory;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cardDetails extends AppCompatActivity {

    EditText Cardno,name,exdate,cvv,phone;
    Button buy;
    AlertDialog.Builder alertBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carddetails);

        buy = findViewById(R.id.sub_card);
        name=findViewById(R.id.namecard);
        exdate=findViewById(R.id.expirdate);
        Cardno=findViewById(R.id.cardno);
        cvv=findViewById(R.id.cvv1);
        phone=findViewById(R.id.telephone);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    alertBuilder = new AlertDialog.Builder(cardDetails.this);
                    alertBuilder.setTitle("Confirm before purchase");
                    alertBuilder.setMessage("Card number: " + Cardno.getText().toString()+ "\n" +
                            "Card expiry date: " + exdate.getText().toString() + "\n" +
                            "Card CVV: " + cvv.getText().toString() + "\n" +
                            "Name : " + name.getText().toString() + "\n" +
                            "Phone number: " + phone.getText().toString());
                    alertBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Toast.makeText(cardDetails.this, "Thank you for purchase", Toast.LENGTH_LONG).show();
                        }
                    });
                    alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog alertDialog = alertBuilder.create();
                    alertDialog.show();


            }
        });
    }
}


