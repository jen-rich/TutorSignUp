package com.example.choco.tutorsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateAccount extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private DatabaseReference mDatabase;
    EditText username, password, name, idNum;
    Spinner accountType;
    CheckBox clubRole;
    String role;
    String selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        accountType = findViewById(R.id.accountType);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.officer:
                if (checked) {
                    clubRole = findViewById(R.id.officer);
                }

            else
                break;
            case R.id.sponsor:
                if (checked)
                    clubRole = findViewById(R.id.sponsor);
            else
                break;
        }
        role = clubRole.getText().toString();
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
        String user = username.getText().toString();
        String pass = password.getText().toString();
        String person = name.getText().toString();
        String id = idNum.getText().toString();
        writeNewAccount(id, person, user, pass, selected, role);
        //helper.insertData(user, pass, em, selected, role);
    }

    private void writeNewAccount(String idNo, String name, String username, String password, String type, String role) {
        Account user = new Account(name, username, password, type, role);

        mDatabase.child("users").child(idNo).setValue(user);
    }

    public void goToLogin(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
