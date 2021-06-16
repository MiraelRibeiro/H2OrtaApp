package com.pi.h2orta.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfiguracaoFirebase {

    private static DatabaseReference database;
    private static FirebaseAuth auth;

    // retorna a instancia do firebasedatabase
    public static DatabaseReference getFirebaseDataBase(){
        if (database == null){
            database = FirebaseDatabase.getInstance().getReference();
        }
        return  database;
    }


    // retorna a instancia do firebaseauth
    public static FirebaseAuth getFirebaseAutenticacao(){
        if (auth == null){
            auth = FirebaseAuth.getInstance();
        }
        return auth;
    }
}
