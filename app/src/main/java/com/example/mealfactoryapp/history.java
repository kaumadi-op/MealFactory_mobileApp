package com.example.mealfactoryapp;

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

public class history extends AppCompatActivity {


    EditText editTextTextPersonName4, editTextTextPersonID, editTextTextPersonTime;
    Button Updatebtn, Deletebtn,view;

    DatabaseReference dbRef;
    user up;

    private String id_no ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        id_no = getIntent().getStringExtra("id");

        editTextTextPersonName4 = findViewById(R.id.editTextTextPersonName4);
        editTextTextPersonID = findViewById(R.id.editTextTextPersonID);
        editTextTextPersonTime = findViewById(R.id.editTextTextPersonTime);

        Updatebtn = findViewById(R.id.Updatebtn);
        Deletebtn = findViewById(R.id.Deletebtn);
        view = findViewById(R.id.viewwbtn);

        up = new user();

        Updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("user");
                readRef.addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(id_no)){
                            try{
                                up.setName(editTextTextPersonName4.getText().toString().trim());
                                up.setName(editTextTextPersonID.getText().toString().trim());
                                up.setName(editTextTextPersonTime.getText().toString().trim());

                                dbRef = FirebaseDatabase.getInstance().getReference().child("user").child(id_no);
                                dbRef.setValue(up);

                            }catch (Exception e){
                                Toast.makeText(getApplicationContext(), "No source to Update", Toast.LENGTH_SHORT).show();
                            }

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference readRef= FirebaseDatabase.getInstance().getReference().child("user").child(id_no);
                readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChildren()){
                            try {
                                editTextTextPersonName4.setText(dataSnapshot.child("editTextTextPersonName4").getValue().toString());
                                editTextTextPersonID.setText(dataSnapshot.child("editTextTextPersonID").getValue().toString());
                                editTextTextPersonTime.setText(dataSnapshot.child("editTextTextPersonTime").getValue().toString());
                            }
                            catch (Exception e) {
                            }
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


        //id = getIntent().getStringExtra("id");

        //editTextTextPersonName4 = findViewById(R.id.editTextTextPersonName4);
        //editTextTextPersonID = findViewById(R.id.editTextTextPersonID) ;
        //editTextTextPersonTime = findViewById(R.id.editTextTextPersonTime);

        //Updatebtn = findViewById(R.id.Updatebtn);
        //Deletebtn = findViewById(R.id.Deletebtn);
        //viewwbtn = findViewById(R.id.viewwbtn);

        //viewwbtn.setOnClickListener(new View.OnClickListener() {
        //  @Override
        //public void onClick(View view) {
        //  dbRef = FirebaseDatabase.getInstance().getReference().child("user").child("600");
        //dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
        //  @Override
        //public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        //  if (dataSnapshot.hasChildren()) ;
        //String Name = dataSnapshot.child("name").getValue().toString();
        //String ID = dataSnapshot.child("id").getValue().toString();
        //String Phone = dataSnapshot.child("phone").getValue().toString();
        //editTextTextPersonName4.setText(Name);
        //editTextTextPersonID.setText(ID);
        //editTextTextPersonTime.setText(Phone);
        //}
        //else

        // {
        //Toast.makeText(getApplicationContext(), "No source to Display", Toast.LENGTH_SHORT).show();
        // }
        // }
        // });
        //}
        //});


        //viewwbtn.setOnClickListener(new View.OnClickListener() {
        //@Override
        // public void onClick(View view) {

        // DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("user").child("600");
        //readRef.child(id).addValueEventListener(new ValueEventListener() {
        // @Override
        // public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        //if(dataSnapshot.hasChildren()){
        // user user = dataSnapshot.getValue(user.class);
        //editTextTextPersonName4.setText(user.getName());
        // editTextTextPersonID.setText(user.getID());
        // editTextTextPersonTime.setText(user.getPhone());


        // }
        //}

        // @Override
        // public void onCancelled(@NonNull DatabaseError databaseError) {

        //}
        //});


        //}
        // });

//        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("user").child(id);
//        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if(dataSnapshot.hasChildren()){
//                    editTextTextPersonName4.setText(dataSnapshot.child("name").getValue().toString());
//
//                    editTextTextPersonID.setText(dataSnapshot.child("id").getValue().toString());
//
//                    editTextTextPersonTime.setText(dataSnapshot.child("phone").getValue().toString());
//
//
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        Deletebtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
             DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("user");
            delRef.addListenerForSingleValueEvent(new ValueEventListener() {
              @Override
         public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              if (dataSnapshot.hasChild(id_no.toString())) {
                  DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("user").child(id_no.toString());
                  readRef.removeValue();

           Toast.makeText(getApplicationContext(), "Deleted Successfully", Toast.LENGTH_SHORT).show();
        } else
         Toast.makeText(getApplicationContext(), "Operation unsuccessful", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
        });
        }
        });


    }
}
