package com.pi.h2orta.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.pi.h2orta.R;

public class CadastroActivity extends AppCompatActivity {

    private EditText campoNome, campoSobrenome, campoUser, campoCpf, campoSenha, campoConfSenha;
    private EditText campoEmail, campoEndereco, campoCidade, campoCep;
    private Spinner spinnerEstado, spinnerPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        inicializarComponentes();
    }

    public boolean validarcadastro(){
        return false;
    }

    public void cadastrar(View view){
        boolean validar = validarcadastro();
        if (validar){
            Toast.makeText(this, "Cadastro criado com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
        }

    }

    public void inicializarComponentes(){
        campoNome = findViewById(R.id.editTextNome);
        campoSobrenome = findViewById(R.id.editTextSobrenome);
        campoUser = findViewById(R.id.editTextUser);
        campoCpf = findViewById(R.id.editTextCPF);
        campoSenha = findViewById(R.id.editTextSenha);
        campoConfSenha = findViewById(R.id.editTextConfSenha);
        campoEmail = findViewById(R.id.editTextEmail);
        campoEndereco = findViewById(R.id.editTextEndereco);
        campoCidade = findViewById(R.id.editTextCidade);
        campoCep = findViewById(R.id.editTextCEP);
        spinnerEstado = findViewById(R.id.spinnerEstado);
        spinnerPais = findViewById(R.id.spinnerPais);
    }
}