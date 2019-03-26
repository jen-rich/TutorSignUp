package com.example.choco.tutorsignup;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseTcrViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    Context mContext;
    public FirebaseTcrViewHolder(View requestView) {
        super(requestView);
        mView = requestView;
        mContext = requestView.getContext();
    }

    public void bindRequest(Request request) {
        TextView name = (TextView) mView.findViewById(R.id.teacherName);
        TextView subject = (TextView) mView.findViewById(R.id.sbjct);
        TextView room = (TextView) mView.findViewById(R.id.roomNo);
        TextView date = (TextView) mView.findViewById(R.id.tutorDate);
        TextView time = (TextView) mView.findViewById(R.id.tutorTime);
    }
    @Override
    public void onClick(View view) {
        final ArrayList<Request> requests = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Requests");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    requests.add(snapshot.getValue(Request.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, FulfillActivity.class);

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
