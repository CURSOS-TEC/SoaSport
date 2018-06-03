package com.soa.jnavarro.soasport.database;

import android.content.Context;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.soa.jnavarro.soasport.utils.soa.soaalerts.SoaAlert;
import com.soa.jnavarro.soasport.utils.soa.soapost.SoaPost;

import java.util.ArrayList;

public class DBManager {
    private static final DBManager ourInstance = new DBManager();

    public static DBManager getInstance() {
        return ourInstance;
    }

    private DBManager() {
    }

    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();


    /**
     * Retorna una referencia a la base de datos de firebase para extraer los datos dabo
     * una referencia DatabaseReference
     * @param ref el nombre de la referencia
     * @return la instancia de la referencia
     */
    public DatabaseReference getDataBaseReference (String ref){
        DatabaseReference myRef = mDatabase.getReference(ref);
        return myRef;
    }


    public void setPostEventListener (DatabaseReference pRef, ArrayList<SoaPost> list,  final Context ctx){
        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                SoaAlert.getInstance().ToastMessage(ctx,"onChildAdded: " + dataSnapshot.getKey());

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
                //Comment newComment = dataSnapshot.getValue(Comment.class);
                String commentKey = dataSnapshot.getKey();
                SoaAlert.getInstance().ToastMessage(ctx,"onChildChanged: " + commentKey);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String commentKey = dataSnapshot.getKey();
                SoaAlert.getInstance().ToastMessage(ctx,"onChildRemoved: " + commentKey);

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
                String commentKey = dataSnapshot.getKey();
                SoaAlert.getInstance().ToastMessage(ctx,"onChildMoved: " + commentKey);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                String message = databaseError.getMessage();
                SoaAlert.getInstance().ToastMessage(ctx,"onChildMoved: " + message);
            }
        };
        pRef.addChildEventListener(childEventListener);

    }
}
