package com.pi.h2orta.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.pi.h2orta.R;

public class PagamentoActivity extends AppCompatActivity {

    private ImageView imagemDaCompra;
    private TextView valorCompra;
    private TextView modeloCompra;
    private TextView tamanhoEstufa;
    private Button btnAdicionarCartao;
    private Button btnFinalizarPedido;
    private RadioButton rbCredito;
    private RadioButton rbDebito;
    private RadioButton rbBoleto;
    private RadioButton rbPix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        inicializarComponentes();

        Bundle dados = getIntent().getExtras();
        valorCompra.setText(dados.getString("valor"));
        modeloCompra.setText(dados.getString("modelo"));
        tamanhoEstufa.setText(dados.getString("tamanho"));
        imagemDaCompra.setImageResource(dados.getInt("imagem"));

        btnAdicionarCartao.setEnabled(true);

        if (rbBoleto.isChecked()){
            btnAdicionarCartao.setEnabled(false);
            btnAdicionarCartao.setVisibility(View.GONE);
            Toast.makeText(this, "Boleto será enviado por e-mail ao finalizar o pedido!", Toast.LENGTH_LONG).show();

        }
        else if (rbPix.isChecked()){
            btnAdicionarCartao.setEnabled(false);
            btnAdicionarCartao.setVisibility(View.GONE);
            startActivity(new Intent(getApplicationContext(), MetodoPagamentoActivity.class));
        }
        else if (rbDebito.isChecked()){
            btnAdicionarCartao.setEnabled(true);
            btnAdicionarCartao.setVisibility(View.VISIBLE);

        }
        else if (rbCredito.isChecked()){
            btnAdicionarCartao.setEnabled(true);
            btnAdicionarCartao.setVisibility(View.VISIBLE);

        }
    }

    private void inicializarComponentes(){
        imagemDaCompra = findViewById(R.id.imageModeloCompra);
        valorCompra = findViewById(R.id.textValorCompra);
        modeloCompra = findViewById(R.id.textModeloCompra);
        tamanhoEstufa = findViewById(R.id.textTamanhoCompra);

        btnAdicionarCartao = findViewById(R.id.btnAdicionarCartao);
        btnFinalizarPedido = findViewById(R.id.btnFinalizar);

        rbCredito = findViewById(R.id.radioButtonCredito);
        rbDebito = findViewById(R.id.radioButtonDebito);
        rbBoleto = findViewById(R.id.radioButtonBoleto);
        rbPix = findViewById(R.id.radioButtonPix);
    }
}