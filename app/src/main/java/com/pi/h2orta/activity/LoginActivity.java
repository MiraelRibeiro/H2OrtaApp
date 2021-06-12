package com.pi.h2orta.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.pi.h2orta.MainActivity;
import com.pi.h2orta.R;

public class LoginActivity extends AppCompatActivity {

    private EditText campoEmail, campoSenha;
    private Switch switchLembrar;
    private TextView textCadastrar, textEsqueciSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inicializarComponentes();
    }

    public void fazerLogin(View view){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    public void fazerCadastro(View view){
        startActivity(new Intent(getApplicationContext(), CadastroActivity.class));
    }

    private void inicializarComponentes(){
        campoEmail = findViewById(R.id.editTextEmailLogin);
        campoSenha = findViewById(R.id.editTextSenhaLogin);
        switchLembrar = findViewById(R.id.switchLembrar);
        textCadastrar = findViewById(R.id.textViewCadastrar);
        textEsqueciSenha = findViewById(R.id.textViewRecuperar);
    }
}