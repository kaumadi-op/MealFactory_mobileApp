package com.example.mealfactoryapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class EnterDelivery extends AppCompatActivity {
    EditText Name, Contact, Add, Loc;

    Button Sub, Next;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_delivery_details);

        //Hooks
        Name = findViewById(R.id.Name);
        Contact = findViewById(R.id.Phone);
        Add = findViewById(R.id.Address);
        Loc = findViewById(R.id.Location);
        Sub = findViewById(R.id.subbtn);
        Next = findViewById(R.id.nxtbtn);

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String enteredname = Name.getEditableText().toString().trim();
                final String enteredphone = Contact.getEditableText().toString().trim();
                final String enteredaddress = Add.getEditableText().toString().trim();
                final String enterdedlocation = Loc.getEditableText().toString().trim();

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Delivery");
                Query checkDelivery = reference.orderByChild("name").equalTo(enteredname);
                checkDelivery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        Name.setError(null);

                        if (dataSnapshot.exists()) {
                            String nameFromDB = dataSnapshot.child(enteredname).child("name").getValue(String.class);
                            String addressFromDB = dataSnapshot.child(enteredaddress).child("address").getValue(String.class);
                            String locationFromDB = dataSnapshot.child(enterdedlocation).child("location").getValue(String.class);
                            String phoneNoFromDB = dataSnapshot.child(enteredphone).child("contactNo").getValue(String.class);
                            Intent Intent = new Intent(getApplicationContext(), Dilivery.class);
                            Intent.putExtra("name", nameFromDB);
                            Intent.putExtra("address", addressFromDB);
                            Intent.putExtra("location", locationFromDB);
                            Intent.putExtra("contactNo", phoneNoFromDB);
                            startActivity(Intent);
                        } else {
                            Name.setError("no such delivery");
                            Name.requestFocus();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });

            }

        });
    }
    private Boolean validatePhoneNo(){

        String ContactNo = Contact.getEditableText().toString();
        String MobilePattern = "[0-9]{10}";

        if (ContactNo.isEmpty()) {
            Contact.setError("Field cannot be empty");
            return false;
        }else if(!ContactNo.matches(MobilePattern)){
            Contact.setError("please enter valid phone number");
            return false;
        }
        else {
            Contact.setError(null);
            return true;
        }
    }

     public void Submit(View view) {
         reference = FirebaseDatabase.getInstance().getReference().child("Delivery");
         try {
             if (!validatePhoneNo()) {
                 return;
             } else {
                 if (TextUtils.isEmpty(Name.getText().toString()))
                     Toast.makeText(getApplicationContext(), "Please enter a Name", Toast.LENGTH_SHORT).show();
                 else if (TextUtils.isEmpty(Add.getText().toString()))
                     Toast.makeText(getApplicationContext(), "Please enter Your address", Toast.LENGTH_SHORT).show();
                 else if (TextUtils.isEmpty(Loc.getText().toString()))
                     Toast.makeText(getApplicationContext(), "Please enter Your Location", Toast.LENGTH_SHORT).show();
                 else if (TextUtils.isEmpty(Contact.getText().toString()))
                     Toast.makeText(getApplicationContext(), "Please enter an Phone number", Toast.LENGTH_SHORT).show();
                 else {
                     String name = Name.getEditableText().toString();
                     String ContactNo = Contact.getEditableText().toString();
                     String Address = Add.getEditableText().toString();
                     String Location = Loc.getEditableText().toString();

                     Delivery delivery = new Delivery(name, Address, Location, ContactNo);

                     reference.child(ContactNo).setValue(delivery);
                     Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                 }
             }
         } catch (NumberFormatException e) {
             Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_SHORT).show();
         }

     }
}





