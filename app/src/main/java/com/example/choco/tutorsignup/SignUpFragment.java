package com.example.choco.tutorsignup;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;


public class SignUpFragment extends Fragment implements View.OnClickListener{
    private static View view;
    private static EditText username, email, password;
    private static Spinner accountType;
    private Button signUp, login;
    private CheckBox officer, sponsor;

    public SignUpFragment() {

    }

    private void initViews() {
        email = view.findViewById(R.id.email);
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        signUp= view.findViewById(R.id.signUp);
        login = view.findViewById(R.id.login);
        accountType = view.findViewById(R.id.accountType);
        officer = view.findViewById(R.id.officer);
        sponsor = view.findViewById(R.id.sponsor);
    }

    public void onClick(View v) {
        
    }


}
