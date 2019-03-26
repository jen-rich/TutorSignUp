package com.example.choco.tutorsignup;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentActivity extends AppCompatActivity {

    FirebaseDatabase mDatabase;
    DatabaseReference requests;

    ActionBar.Tab Tab1, Tab2, Tab3;
    Fragment fragmentTab1 = new ();
    Fragment fragmentTab2 = new NeedHelp();
    Fragment fragmentTab3 = new FulfillActivity();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();

        // Hide Actionbar Icon
        actionBar.setDisplayShowHomeEnabled(false);

        // Hide Actionbar Title
        actionBar.setDisplayShowTitleEnabled(false);

        // Create Actionbar Tabs
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Set Tab Icon and Titles
        Tab1 = actionBar.newTab().setIcon(R.drawable.tab1);
        Tab2 = actionBar.newTab().setText("Tab2");
        Tab3 = actionBar.newTab().setText("Tab3");

        // Set Tab Listeners
        Tab1.setTabListener(new TabListener(fragmentTab1));
        Tab2.setTabListener(new TabListener(fragmentTab2));
        Tab3.setTabListener(new TabListener(fragmentTab3));

        // Add tabs to actionbar
        actionBar.addTab(Tab1);
        actionBar.addTab(Tab2);
        actionBar.addTab(Tab3);
    }
}