package com.example.foodfactory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                try {
                    if (TextUtils.isEmpty(name1.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a Name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(amount1.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter Your Amount", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(date1.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter Your date", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(phone1.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter an Phone number", Toast.LENGTH_SHORT).show();
                    else {
                String name = name1.getEditableText().toString();
                String amount = amount1.getEditableText().toString();
                String date = date1.getEditableText().toString();
                String phone = phone1.getEditableText().toString();

                PaymentHelper payment  = new PaymentHelper(name,amount,date,phone);

                reference.child(phone).setValue(payment);
                Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_SHORT).show();
                }
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
