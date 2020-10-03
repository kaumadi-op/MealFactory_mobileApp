package com.example.foodfactory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Dilivery extends AppCompatActivity {

    EditText Name ,Address,phone,Location;
    Button delete,update,payment;

    String name1,location1,address1,phone1;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dilivery);

        reference = FirebaseDatabase.getInstance().getReference("Delivery");
        //hooks

        Name = findViewById(R.id.dil_name);
        Address = findViewById(R.id.dil_address);
        phone = findViewById(R.id.dil_phone);
        Location = findViewById(R.id.dil_location);
        delete = findViewById(R.id.Delete_btn);
        update = findViewById(R.id.up_btn);
        payment = findViewById(R.id.make_payment);

        showAllUDeliveryData();


    }

    private void showAllUDeliveryData( ) {
        Intent Intent = getIntent();

       name1 = Intent.getStringExtra("name");
       location1 = Intent.getStringExtra("location");
       address1 = Intent.getStringExtra("address");
       phone1 = Intent.getStringExtra("contactNo");


        Name.setText(name1);
        phone.setText(phone1);
        Address.setText(address1);
        Location.setText(location1);
    }
    public void update(){
            if (isNameChanged()||islocationchanged()||isaddresschanged()||isphonechanged()
         ){
                Toast.makeText(this,"Data has been updated",Toast.LENGTH_LONG).show();
            }
            else Toast.makeText(this,"data is same",Toast.LENGTH_LONG).show();
        }


        private boolean isphonechanged() {
        if(!phone1.equals(phone.getEditableText().toString())){
            reference.child(phone1).child("contactNo").setValue(phone.getEditableText().toString());
            return  true;
        }
        else {
            return false;
        }
    }

    private boolean isaddresschanged() {
        if(!address1.equals(Address.getText().toString())){
            reference.child(address1).child("address").setValue(Address.getText().toString());
            return  true;
        }
        else {
            return false;
        }
    }

    private boolean islocationchanged() {
        if(!location1.equals(Location.getText().toString())){
            reference.child(location1).child("location").setValue(Location.getText().toString());
            return  true;
        }
        else {
            return false;
        }

    }

    private boolean isNameChanged() {
        if(!name1.equals(Name.getText().toString())){
            reference.child(name1).child("name").setValue(Name.getText().toString());
            return  true;
        }
        else {
            return false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dilivery.this, Payment.class);
                startActivity(intent);
            }
        });
    }

}
