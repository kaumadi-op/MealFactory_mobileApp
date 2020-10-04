package com.example.contactfeedback;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class retrivecontactus extends AppCompatActivity {

    EditText name,email,message;
    Button btnDelete, btnUpdate;
    DatabaseReference dbRef;
    User dep;



    private String Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrivecontactus);

        Name = getIntent().getStringExtra("Name");

        name = findViewById(R.id.name1);
        email = findViewById(R.id.email1);
        message = findViewById(R.id.message1);

        btnDelete = findViewById(R.id.deletebtn);
        btnUpdate = findViewById(R.id.updatebtn);

        //final String getName = name.toString();

        dep = new User();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("User");
                readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(Name)) {
                            try {
                                dep.setName(name.getText().toString().trim());
                                dep.setEmail(email.getText().toString().trim());
                                dep.setMessage(message.getText().toString().trim());
                                //dep.name.setText(dataSnapshot.child("name").getValue().toString());
                                //dep.email.setText(dataSnapshot.child("email").getValue().toString());
                                // message.setText(dataSnapshot.child("message").getValue().toString());



                                dbRef = FirebaseDatabase.getInstance().getReference().child("User").child(Name);
                                dbRef.setValue(dep);
                                clearcontrols();

                                Toast.makeText(retrivecontactus.this, "Update Success", Toast.LENGTH_SHORT).show();

                            } catch (Exception e) {

                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("User").child(Name);
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){
                    name.setText(dataSnapshot.child("name").getValue().toString());
                    email.setText(dataSnapshot.child("email").getValue().toString());
                    message.setText(dataSnapshot.child("message").getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("User");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(Name)){
                            dbRef = FirebaseDatabase.getInstance().getReference().child("User").child(Name);
                            dbRef.removeValue();
                            clearcontrols();
                            Toast.makeText(getApplicationContext(),"Deleted Successfully",Toast.LENGTH_SHORT).show();

                        }
                        else
                            Toast.makeText(getApplicationContext(),"Operation unsuccessful",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });





    }
    public void clearcontrols(){
        name.setText("");
        email.setText("");
        message.setText("");
    }
}