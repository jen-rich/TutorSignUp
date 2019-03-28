package com.example.choco.tutorsignup;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FulfillFragment extends Fragment {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRequestReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    RecyclerView mRecyclerView;

    View mView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_teacher, container, false);
        mRecyclerView = mView.findViewById(R.id.stdRView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return mView;

    }

    public void onStart() {
        super.onStart();
        mDatabase = FirebaseDatabase.getInstance();
        mRequestReference = mDatabase.getReference("Fulfillments");
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Fulfillment, FirebaseFlfllViewHolder>
                (Fulfillment.class, R.layout.ffl_list_item, FirebaseFlfllViewHolder.class,
                        mRequestReference) {

            @Override
            protected void populateViewHolder(FirebaseFlfllViewHolder viewHolder,
                                              Fulfillment model, int position) {
                viewHolder.bindRequest(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}
