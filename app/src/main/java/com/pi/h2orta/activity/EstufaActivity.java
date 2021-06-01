package com.pi.h2orta.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pi.h2orta.R;
import com.pi.h2orta.adapter.AdapterComprar;
import com.pi.h2orta.adapter.AdapterEscolha;
import com.pi.h2orta.model.TamanhosEstufas;

import java.util.ArrayList;
import java.util.List;

public class EstufaActivity extends AppCompatActivity {

    private TextView textModelo;
    private ImageView imagem;
    private RecyclerView recyclerView;
    private List<TamanhosEstufas> listaTamanhos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estufa);

        iniciarComponentes();

        Bundle dados = getIntent().getExtras();
        textModelo.setText(dados.getString("modelo"));
        imagem.setImageResource(dados.getInt("imagem"));

        preencheLista();

        try {
            AdapterEscolha adapterEscolha = new AdapterEscolha(listaTamanhos, getApplicationContext());
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapterEscolha);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void preencheLista() {
        listaTamanhos.clear();
        if(textModelo.getText().toString().equals("Semi-Aberta"))
        {
            TamanhosEstufas tamanhos = new TamanhosEstufas("Normal", "R$ 500,00", "8 slots(5 cm de diâmetros) 2 fileiras 4 slots Luminária térmica ajustável Sem bomba de circulação de água Tamanho total 45x25 cm");
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Médio", "R$ 600,00", "10 slots(5 cm de diâmetros) 2 fileiras 5 slots Luminária térmica ajustável Sem bomba de circulação de água Tamanho total 55x25 cm");
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Grande", "R$ 700,00", "12 slots(5 cm de diâmetros) 3 fileiras 4 slots Luminária térmica ajustável Com bomba de circulação de água Tamanho total 45x35 cm");
            listaTamanhos.add(tamanhos);
        }

        else if(textModelo.getText().toString().equals("Aquário"))
        {
            TamanhosEstufas tamanhos = new TamanhosEstufas("Normal", "R$ 700,00", "8 slots(5 cm de diâmetros)\n" +
                    "2 fileiras 4 slots\n Aquário, filtro\n Com bomba de circulação de água\n Tamanho total 45x25 cm");
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Médio", "R$ 800,00", "10 slots(5 cm de diâmetros)\n 2 fileiras 5 slots\n" +
                    "Aquário, filtro\n Com bomba de circulação de água\n Tamanho total 55x25 cm");
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Grande", "R$ 900,00", "12 slots(5 cm de diâmetros)\n" +
                    "3 fileiras 4 slots\n Aquário, filtro, display de temperatura e ph\n Com bomba de circulação de água\n" +
                    "Tamanho total 45x35 cms");
            listaTamanhos.add(tamanhos);
        }

        else if(textModelo.getText().toString().equals("Box Model"))
        {
            TamanhosEstufas tamanhos = new TamanhosEstufas("Normal", "R$ 1.000,00", "8 slots(5 cm de diâmetros)\n" +
                    "2 fileiras 4 slots\n Display, sensores de temperatura e ph, filtro, luminária térmica, ventilação\n" +
                    "Com bomba de circulação de água\n Tamanho total 45x25 cm");
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Médio", "R$ 1.200,00", "10 slots(5 cm de diâmetros)\n" +
                    "2 fileiras 5 slots\n Display, sensores de temperatura e ph, filtro, luminária térmica, ventilação\n" +
                    "Com bomba de circulação de água\n Tamanho total 55x25 cm");
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Grande", "R$ 1.400,00", "12 slots(5 cm de diâmetros)\n" +
                    "3 fileiras 4 slots\n Display, sensores de temperatura e ph, filtro, luminária térmica, controle de temperatura e ventilação\n" +
                    "Com bomba de circulação de água\n Tamanho total 45x35 cm");
            listaTamanhos.add(tamanhos);
        }

    }
    public void iniciarComponentes(){
        textModelo = findViewById(R.id.textModeloEstuda);
        imagem = findViewById(R.id.imagemDaEstufa);
        recyclerView = findViewById(R.id.recyclerValores);
    }
}