package com.example.choco.tutorsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateAccount extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private FirebaseDatabase mDatabase;
    DatabaseReference users;
    EditText username, password;
    Spinner accountType;
    String selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        mDatabase = FirebaseDatabase.getInstance();
        users = mDatabase.getReference("Users");
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        accountType = findViewById(R.id.accountType);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        selected = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + selected, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
    public void onClick(View v) {
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                writeNewAccount(user, pass, selected);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //helper.insertData(user, pass, em, selected, role);
    }

    private void writeNewAccount(String username, String password, String type) {
        Account user = new Account(username, password, type);
        users.child(username).setValue(user);
    }

    public void goToLogin(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
