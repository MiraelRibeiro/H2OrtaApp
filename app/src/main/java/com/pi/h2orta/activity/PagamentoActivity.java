package com.pi.h2orta.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.pi.h2orta.R;
import com.pi.h2orta.model.CompraEstufa;
import com.pi.h2orta.model.TamanhosEstufas;

import java.util.List;

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

    private Resources resources;
    private Configuration configuration;
    private String linguagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        resources = getResources();
        configuration = resources.getConfiguration();
        linguagem = configuration.getLocales().toString().replace("[", "").replace("]", "");

        inicializarComponentes();
        Bundle dados = getIntent().getExtras();
        String txtValorCompra = dados.getString("valor");
        String txtModeloCompra = dados.getString("modelo");
        String txtTamanhoEstufa = dados.getString("tamanho");
        int imagemRecebida = dados.getInt("imagem");

        valorCompra.setText(txtValorCompra);
        modeloCompra.setText(txtModeloCompra);
        tamanhoEstufa.setText(txtTamanhoEstufa);
        imagemDaCompra.setImageResource(imagemRecebida);

        btnAdicionarCartao.setEnabled(false);
        btnAdicionarCartao.setVisibility(View.GONE);

        validarPagamentoSelecionado();

        btnFinalizarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CompraEstufa compraEstufa = new CompraEstufa();
                compraEstufa.setModelo(txtModeloCompra);
                compraEstufa.setImagem(imagemRecebida);

                AlertDialog.Builder dialog = new AlertDialog.Builder(PagamentoActivity.this);
                dialog.setTitle(retornosetTitle(linguagem));
                dialog.setMessage(retornosetMessage(linguagem));
                dialog.setPositiveButton(retornoBotaoConfirmar(linguagem), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        compraEstufa.salvarPedido();
                        Toast.makeText(getApplicationContext(), retornoMensagemSucesso(linguagem), Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }).setNegativeButton(retornoBotaoCancelar(linguagem), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        compraEstufa.setImagem(0);
                        compraEstufa.setModelo("");
                        compraEstufa.setDadosEstufa(null);
                        Toast.makeText(getApplicationContext(), retornoMensagemCancelado(linguagem), Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                dialog.create();
                dialog.show();
            }
        });

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

    private void validarPagamentoSelecionado(){

        rbBoleto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAdicionarCartao.setEnabled(false);
                btnAdicionarCartao.setVisibility(View.GONE);
                Toast.makeText(getApplication(), retornomensagemBoleto(linguagem), Toast.LENGTH_LONG).show();
            }
        });
        rbPix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAdicionarCartao.setEnabled(false);
                btnAdicionarCartao.setVisibility(View.GONE);
                Intent i = new Intent(getApplicationContext(), MetodoPagamentoActivity.class);
                i.putExtra("metodo", "pix");
                startActivity(i);
            }
        });

        rbDebito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAdicionarCartao.setEnabled(true);
                btnAdicionarCartao.setVisibility(View.VISIBLE);
                btnAdicionarCartao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getApplicationContext(), DadosCartaoActivity.class);
                        i.putExtra("metodo", "debito");
                        startActivity(i);
                    }
                });
            }
        });

        rbCredito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAdicionarCartao.setEnabled(true);
                btnAdicionarCartao.setVisibility(View.VISIBLE);
                btnAdicionarCartao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getApplicationContext(), DadosCartaoActivity.class);
                        i.putExtra("metodo", "credito");
                        startActivity(i);
                    }
                });
            }
        });
    }

    private String retornoMensagemSucesso(String linguagem){

        String mensagemRetorno ="Compra Efetuada Com Sucesso!";

        if (linguagem.equals("pt_BR")){
            mensagemRetorno ="Compra Efetuada Com Sucesso!";
        }
        else if (linguagem.equals("en")){
            mensagemRetorno ="Purchase Made Successfully!";
        }
        else if (linguagem.equals("fr")){
            mensagemRetorno ="Achat effectué avec succès !";
        }
        else if (linguagem.equals("it")){
            mensagemRetorno ="Acquisto effettuato con successo!";
        }
        else if (linguagem.equals("es")){
            mensagemRetorno ="¡Compra realizada con éxito!";
        }

        return mensagemRetorno;
    }

    private String retornoMensagemCancelado(String linguagem){

        String mensagemRetorno ="Compra Cancelada!";

        if (linguagem.equals("pt_BR")){
            mensagemRetorno ="Compra Cancelada!";
        }
        else if (linguagem.equals("en")){
            mensagemRetorno ="Cancelled purchase!";
        }
        else if (linguagem.equals("fr")){
            mensagemRetorno ="Achat annulé!";
        }
        else if (linguagem.equals("it")){
            mensagemRetorno ="Acquisto annullato!";
        }
        else if (linguagem.equals("es")){
            mensagemRetorno ="Compra cancelada!";
        }

        return mensagemRetorno;
    }

    private String retornoBotaoConfirmar(String linguagem){

        String mensagemRetorno ="Comprar!";

        if (linguagem.equals("pt_BR")){
            mensagemRetorno ="Comprar";
        }
        else if (linguagem.equals("en")){
            mensagemRetorno ="Buy";
        }
        else if (linguagem.equals("fr")){
            mensagemRetorno ="Acheter";
        }
        else if (linguagem.equals("it")){
            mensagemRetorno ="Acquista";
        }
        else if (linguagem.equals("es")){
            mensagemRetorno ="Comprar";
        }

        return mensagemRetorno;
    }

    private String retornoBotaoCancelar(String linguagem){

        String mensagemRetorno ="Cancelar";

        if (linguagem.equals("pt_BR")){
            mensagemRetorno ="Cancelar";
        }
        else if (linguagem.equals("en")){
            mensagemRetorno ="Cancell";
        }
        else if (linguagem.equals("fr")){
            mensagemRetorno ="Annuler";
        }
        else if (linguagem.equals("it")){
            mensagemRetorno ="Annulla";
        }
        else if (linguagem.equals("es")){
            mensagemRetorno ="Cancelar";
        }

        return mensagemRetorno;
    }

    public String retornosetTitle(String linguagem){

        String mensagemRetorno ="Deseja Confirmar Compra?";

        if (linguagem.equals("pt_BR")){
            mensagemRetorno ="Deseja Confirmar Compra?";
        }
        else if (linguagem.equals("en")){
            mensagemRetorno ="Want to Confirm Purchase?";
        }
        else if (linguagem.equals("fr")){
            mensagemRetorno ="Vous voulez confirmer l'achat?";
        }
        else if (linguagem.equals("it")){
            mensagemRetorno ="Vuoi confermare l'acquisto?";
        }
        else if (linguagem.equals("es")){
            mensagemRetorno ="Quiere confirmar la compra?";
        }
        return mensagemRetorno;
    }

    public String retornosetMessage(String linguagem){

        String mensagemRetorno ="Realizar pedido de compra?";

        if (linguagem.equals("pt_BR")){
            mensagemRetorno ="Realizar pedido de compra?";
        }
        else if (linguagem.equals("en")){
            mensagemRetorno ="Place a purchase order?";
        }
        else if (linguagem.equals("fr")){
            mensagemRetorno ="Passer un bon de commande?";
        }
        else if (linguagem.equals("it")){
            mensagemRetorno ="Effettuare un ordine di acquisto?";
        }
        else if (linguagem.equals("es")){
            mensagemRetorno ="Realizar orden de compra?";
        }
        return mensagemRetorno;
    }

    public String retornomensagemBoleto(String linguagem){

        String mensagemRetorno ="Boleto será enviado por e-mail ao finalizar o pedido!";

        if (linguagem.equals("pt_BR")){
            mensagemRetorno ="Boleto será enviado por e-mail ao finalizar o pedido!";
        }
        else if (linguagem.equals("en")){
            mensagemRetorno ="Boleto will be sent by email when ordering!";
        }
        else if (linguagem.equals("fr")){
            mensagemRetorno ="Boleto sera envoyé par email lors de la commande !";
        }
        else if (linguagem.equals("it")){
            mensagemRetorno ="Boleto verrà inviato via e-mail al momento dell'ordine!";
        }
        else if (linguagem.equals("es")){
            mensagemRetorno ="¡El boleto se enviará por correo electrónico al realizar el pedido!";
        }
        return mensagemRetorno;
    }
}