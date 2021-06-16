package com.pi.h2orta.model;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.pi.h2orta.config.Base64Custom;
import com.pi.h2orta.config.ConfiguracaoFirebase;

import java.util.List;

public class CompraEstufa {

    private String modelo;
    private int imagem;
    private List<TamanhosEstufas> dadosEstufa;

    public CompraEstufa() {
    }

    public CompraEstufa(String modelo, int imagem, List<TamanhosEstufas> dadosEstufa) {
        this.modelo = modelo;
        this.imagem = imagem;
        this.dadosEstufa = dadosEstufa;
    }

    public void salvarPedido(){
        try {
            FirebaseAuth autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
            String idUser = Base64Custom.codificarBase64(autenticacao.getCurrentUser().getEmail());

            DatabaseReference firebaseRef = ConfiguracaoFirebase.getFirebaseDataBase();
            firebaseRef.child("minhas_compras")
                    .child(idUser)
                    .setValue(this); // salva baseado nesse modelo
        }
        catch (Exception e){
            Log.i("Erro", "Erro ao salvar dados gerados pelo usuario no banco");
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public List<TamanhosEstufas> getDadosEstufa() {
        return dadosEstufa;
    }

    public void setDadosEstufa(List<TamanhosEstufas> dadosEstufa) {
        this.dadosEstufa = dadosEstufa;
    }
}
