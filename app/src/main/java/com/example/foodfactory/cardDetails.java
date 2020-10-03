package com.example.foodfactory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.jar.Attributes;

public class cardDetails extends AppCompatActivity {

    EditText Cardno,name,exdate;
    Button sub,next;


    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carddetails);

        name=findViewById(R.id.namecard);
        exdate=findViewById(R.id.expirdate);
        Cardno=findViewById(R.id.cardno);
        sub=findViewById(R.id.sub_card);
        next=findViewById(R.id.next_card);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Card detail");

                String Name =name.getEditableText().toString();
                String cardNo= Cardno.getEditableText().toString();
                String ex_date = exdate.getEditableText().toString();

                Card card = new Card(Name,cardNo,ex_date);

                reference.child(cardNo).setValue(card);
            }
        });
    }

}
