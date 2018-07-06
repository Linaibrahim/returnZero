package com.example.pcworld.return0_final.firebase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.pcworld.return0_final.R;
import com.example.pcworld.return0_final.model;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by pc world on 13/11/2017.
 */

public class firebase_mypro extends AppCompatActivity implements OnCompleteListener<Void> {

    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myprod1);
        FirebaseUser firebaseUser  = FirebaseAuth.getInstance().getCurrentUser();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = firebaseDatabase.getReference();
        databaseReference.child("models").push()
                .setValue(new model("model1", "desModel1",firebaseUser.getUid()))
                .addOnCompleteListener(this);
        textview = (TextView) findViewById(R.id.my_prod_tit);

        DatabaseReference databaseReference1 = firebaseDatabase
                .getReference("models");
        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<Map<String
                                        , model>> t =
                        new GenericTypeIndicator<Map<String
                                                        , model>>() {
                        };
                Map<String, model> stringmodelMap = dataSnapshot.getValue(t);
                ArrayList<model> models = new ArrayList<>(stringmodelMap.values());
                String x = "";
                for (int i = 0; i < models.size(); i++) {
                    x += models.get(i).getTitle() + "ِ\n"
                            + models.get(i).getDescription();
                }
                textview.setText(x);

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databaseReference1.orderByChild("title").equalTo("model1")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                            dataSnapshot1.getRef().child("title").setValue("newTile").addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                }
                            });
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


    }


    @Override
    public void onComplete(@NonNull Task<Void> task) {

    }

}

