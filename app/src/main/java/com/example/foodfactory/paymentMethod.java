package com.example.foodfactory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class paymentMethod extends AppCompatActivity {

    EditText name1,amount1,date1,phone1;
    Button Next,enter;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentmethod);

        //Hooks
        name1=findViewById(R.id.name1);
        amount1 =findViewById(R.id.amount1);
        date1=findViewById(R.id.date1);
        phone1=findViewById(R.id.phone1);
        enter=findViewById(R.id.sub);
        Next=findViewById(R.id.nxt);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Payment");

                String name = name1.getEditableText().toString();
                String amount = amount1.getEditableText().toString();
                String date = date1.getEditableText().toString();
                String phone = phone1.getEditableText().toString();

                PaymentHelper payment  = new PaymentHelper(name,amount,date,phone);

                reference.child(phone).setValue(payment);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(paymentMethod.this, cardDetails.class);
                startActivity(intent);
            }
        });
    }
}
