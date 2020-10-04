package com.example.mealfactoryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Dilivery extends AppCompatActivity {

    EditText Name;
    EditText Address;
    EditText phone1;
    EditText Location;
    Button delete, update, payment,show;

    String _name, _location, _address, _phone;
    Delivery Delivery= new Delivery();
    DatabaseReference reference;

    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dilivery);

        phone=getIntent().getStringExtra("contactNo");

        reference = FirebaseDatabase.getInstance().getReference().child("Delivery");

        //hooks

        Name = findViewById(R.id.dil_name);
        Address = findViewById(R.id.dil_address);
        phone1 = findViewById(R.id.dil_phone);
        Location = findViewById(R.id.dil_location);
        delete = findViewById(R.id.Delete_btn);
        update = findViewById(R.id.up_btn);
        payment = findViewById(R.id.make_payment);
        show = findViewById(R.id.show_btn);
       showAllData();

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference().child("Delivery").child(phone);
                reference.addListenerForSingleValueEvent(new ValueEventListener(){

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChildren()){
                            try{
                                Name.setText(dataSnapshot.child("name").getValue().toString());
                                phone1.setText(dataSnapshot.child("contactNo").getValue().toString());
                                Address.setText(dataSnapshot.child("address").getValue().toString());
                                Location.setText(dataSnapshot.child("location").getValue().toString());

                            }
                            catch (NumberFormatException e){
                                Toast.makeText(getApplicationContext(),"Invalid",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"No source to display",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference("Delivery");
                reference.addListenerForSingleValueEvent(new ValueEventListener(){

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(phone)){
                            try{
                                Delivery.setName(Name.getText().toString().trim());
                                Delivery.setContactNo(phone1.getText().toString().trim());
                                Delivery.setLocation(Location.getText().toString().trim());
                                Delivery.setAddress(Address.getText().toString().trim());

                                reference=FirebaseDatabase.getInstance().getReference().child("Delivery").child(phone);
                                reference.setValue(Delivery);

                                Toast.makeText(getApplicationContext(),"Your changes saved successfully",Toast.LENGTH_SHORT).show();

                            }
                            catch (NumberFormatException e){
                                Toast.makeText(getApplicationContext(),"Invalid",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"No source to Update",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference().child("Delivery");
                reference.addListenerForSingleValueEvent(new ValueEventListener(){

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(phone)){
                            try{
                                reference=FirebaseDatabase.getInstance().getReference().child("Delivery").child(phone);
                                reference.removeValue();

                                Toast.makeText(getApplicationContext(),"delete successfully",Toast.LENGTH_SHORT).show();

                            }
                            catch (NumberFormatException e){
                                Toast.makeText(getApplicationContext(),"Invalid",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"No source to delete",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
    }
    private void showAllData() {
        Intent Intent = getIntent();

        _name = Intent.getStringExtra("name");
        _address = Intent.getStringExtra("address");
        _location = Intent.getStringExtra("location");
        _phone = Intent.getStringExtra("contactNo");


        Name.setText(_name);
        phone1.setText(_phone);
        Address.setText(_address);
        Location.setText(_location);

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
