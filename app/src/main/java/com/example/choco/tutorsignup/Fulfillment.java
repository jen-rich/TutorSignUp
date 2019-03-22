package com.example.choco.tutorsignup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Fulfillment extends AppCompatActivity {

    private ListView fulfilled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fulfillment);

        fulfilled = new ListView(getApplicationContext());
    }

}
