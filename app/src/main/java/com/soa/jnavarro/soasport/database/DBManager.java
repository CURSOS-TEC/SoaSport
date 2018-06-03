package com.soa.jnavarro.soasport.database;

import android.content.Context;
import android.widget.Adapter;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.soa.jnavarro.soasport.utils.soa.soaalerts.SoaAlert;
import com.soa.jnavarro.soasport.utils.soa.soapost.SoaPost;
import com.soa.jnavarro.soasport.utils.soa.soapost.SoaPostAdapter;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

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

    /**
     * Es una combinación altamente acoplada y no recomendada de utilizar El event Listener de
     * las modificaciones de los elementos del arreglo de news, con el adapter respectivo para que
     * el recycler view se entere de modificar la interfaz gráfica, sin embargo, se logra no hacer muy
     * densa la calse de la actividad respectiva. Además que dicha implementación se puede aprovechar
     * para otras activitites de android.
     * @param pRef La referencia de los datos de Firebase, asociado a News por ejemplo.
     * @param adapter El Adapter que tiene la lista de datos a mostrar.
     * @param soaPostArrayList La lista que representa el data set.
     * @param ctx El contexto de la actividad de donde proviene el llamado.
     */
    public void setPostEventListener (DatabaseReference pRef,
                                      final SoaPostAdapter adapter,
                                      final ArrayList<SoaPost> soaPostArrayList,
                                      final Context ctx){
        ChildEventListener childEventListener = new ChildEventListener() {
            /**
             * Este método es ejecutado cuando cuando se insertan nuevos elementos
             * @param dataSnapshot El valor nuevo que debe ser reinterpretado para ser convertido
             *                     en un Soa Post
             * @param previousChildName
             */
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                /*SoaAlert.getInstance().ToastMessage(ctx,"Child array id: "
                        + dataSnapshot.getKey());*/
                try {
                    SoaPost soaPost1 =  dataSnapshot.getValue(SoaPost.class);
                    soaPostArrayList.add(soaPost1);
                    adapter.notifyDataSetChanged();
                }catch (Exception e){
                    SoaAlert.getInstance().ToastMessage(ctx,"Error "+ e.getMessage());
                }
            }

            /**
             *Este método es llamado cada vez que se actualiza el set de datos del arreglo.
             * @param dataSnapshot Versión del dato a borrar.
             * @param previousChildName
             */
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
                int index  = Integer.parseInt(dataSnapshot.getKey());
                SoaPost updatedPost = dataSnapshot.getValue(SoaPost.class);
                try{
                    soaPostArrayList.set(index,updatedPost);
                    /*SoaAlert.getInstance().ToastMessage(ctx,"onChildChanged: "
                            + updatedPost.toString());*/
                    adapter.notifyDataSetChanged();
                }catch (Exception e){
                    SoaAlert.getInstance().ToastMessage(ctx,"Error "+ e.getMessage());
                }

            }

            /**
             * Este método es llamado en el momento en que se elimina un elemento.
             * @param dataSnapshot
             */
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                int index  = Integer.parseInt(dataSnapshot.getKey());
                try{
                    soaPostArrayList.remove(index);
                    /*SoaAlert.getInstance().ToastMessage(ctx,"onChildChanged: "
                            + updatedPost.toString());*/
                    adapter.notifyDataSetChanged();
                }catch (Exception e){
                    SoaAlert.getInstance().ToastMessage(ctx,"Error "+ e.getMessage());
                }
            }

            /**
             *
             * @param dataSnapshot
             * @param previousChildName
             */
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
                String commentKey = dataSnapshot.getKey();
                SoaAlert.getInstance().ToastMessage(ctx,"onChildMoved: " + commentKey);

            }

            /**
             *
             * @param databaseError
             */
            @Override
            public void onCancelled(DatabaseError databaseError) {
                String message = databaseError.getMessage();
                SoaAlert.getInstance().ToastMessage(ctx,"onChildMoved: " + message);
            }
        };
        pRef.addChildEventListener(childEventListener);

    }
}
