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

public class CreateAccount extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText username, password, email;
    Spinner accountType;
    CheckBox clubRole;
    String role;
    String selected;
    myDbAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        accountType = findViewById(R.id.accountType);
        helper = new myDbAdapter(this);
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
                // I'm lactose intolerant
                break;
            // TODO: Veggie sandwich
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
        String em = email.getText().toString();
        helper.insertData(user, pass, em, selected, role);
    }

    public void goToLogin(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
