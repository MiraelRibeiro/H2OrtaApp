package com.pi.h2orta.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pi.h2orta.R;

public class MetodoPagamentoActivity extends AppCompatActivity {

    private Button btnCopiarSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodo_pagamento);
        btnCopiarSair = findViewById(R.id.buttonCopiaSalva);

        btnCopiarSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MetodoPagamentoActivity.this, mensagemRetorno(), Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private String mensagemRetorno(){
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        String linguagem = configuration.getLocales().toString().replace("[", "").replace("]", "");
        String stringRetorno = "PIX copiado";

        if (linguagem.equals("pt_BR")){
            stringRetorno = "PIX copiado";
        }
        else if (linguagem.equals("en")){
            stringRetorno = "PIX copy";
        }
        else if (linguagem.equals("fr")){
            stringRetorno = "Pix copiée";
        }
        else if (linguagem.equals("it")){
            stringRetorno = "Pix copiati";
        }
        else if (linguagem.equals("es")){
            stringRetorno = "PIX copiado";
        }

        return  stringRetorno;
    }
}