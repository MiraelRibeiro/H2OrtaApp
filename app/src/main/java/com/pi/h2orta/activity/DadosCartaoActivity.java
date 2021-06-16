package com.pi.h2orta.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pi.h2orta.R;

public class DadosCartaoActivity extends AppCompatActivity {

    private Button btnSalvarCartao;
    private EditText numeroCartao;
    private EditText codCVV;
    private EditText dataVencimento;
    private EditText nomeTitular;
    private Resources resources;
    private Configuration configuration;
    private String linguagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_cartao);
        btnSalvarCartao = findViewById(R.id.buttonSalvarCartao);
        numeroCartao = findViewById(R.id.editTextNumeroCartao);
        codCVV = findViewById(R.id.editTextCodCvv);
        dataVencimento = findViewById(R.id.editTextValidadeCartao);
        nomeTitular = findViewById(R.id.editTextNomeCartao);

        resources = getResources();
        configuration = resources.getConfiguration();
        linguagem = configuration.getLocales().toString().replace("[", "").replace("]", "");

        btnSalvarCartao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarCamposCartao();
            }
        });
    }

    private void validarCamposCartao(){
        String textoNumeroCartao = numeroCartao.getText().toString();
        String textoCodCVV = codCVV.getText().toString();
        String textoDataVencimento = dataVencimento.getText().toString();
        String textoNomeTitular = nomeTitular.getText().toString();

        if (!textoNumeroCartao.isEmpty()){

            if (!textoCodCVV.isEmpty() && textoCodCVV.length() == 3){

                if (!textoDataVencimento.isEmpty()){

                    if (!textoNomeTitular.isEmpty() && textoCodCVV.length() > 3){

                        Toast.makeText(this, "Dados Salvos com sucesso!", Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(this, retornoMensagemElse(linguagem), Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, retornoMensagemElse(linguagem), Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, retornoMensagemElse(linguagem), Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, retornoMensagemElse(linguagem), Toast.LENGTH_SHORT).show();
        }
    }

    private String retornoMensagemElse(String linguagem){

        String mensagemRetorno ="Preencha os campos corretamente!";

        if (linguagem.equals("pt_BR") ){
            mensagemRetorno ="Preencha os campos corretamente!";
        }
        else if (linguagem.equals("en")){
            mensagemRetorno ="Fill in the fields correctly!";
        }
        else if (linguagem.equals("fr")){
            mensagemRetorno ="Remplissez correctement les champs!";
        }
        else if (linguagem.equals("it")){
            mensagemRetorno ="Compila correttamente i campi!";
        }
        else if (linguagem.equals("es")){
            mensagemRetorno ="Complete los campos correctamente!";
        }
        return mensagemRetorno;
    }
}