package com.example.choco.tutorsignup;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FulfillActivity extends AppCompatActivity {

    private FirebaseDatabase mDatabase;
    DatabaseReference fulfills;
    EditText student, teacher, dte, subj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fulfill);
        mDatabase = FirebaseDatabase.getInstance();
        fulfills = mDatabase.getReference("Fulfillments");
        student = findViewById(R.id.stdnt);
        teacher = findViewById(R.id.tchr);
        dte = findViewById(R.id.ttrDte);
        subj = findViewById(R.id.sbjct);
    }

    public void onClick(View v) {
        fulfills.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String stud = student.getText().toString();
                String teach = teacher.getText().toString();
                String dt = dte.getText().toString();
                String sbj = subj.getText().toString();
                fulfills.child(stud).setValue(Fulfillment.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
