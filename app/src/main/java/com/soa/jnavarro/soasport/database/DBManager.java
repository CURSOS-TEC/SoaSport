package com.soa.jnavarro.soasport.database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
}
