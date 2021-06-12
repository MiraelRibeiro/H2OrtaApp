package com.pi.h2orta.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pi.h2orta.R;
import com.pi.h2orta.activity.PagamentoActivity;
import com.pi.h2orta.model.TamanhosEstufas;

import java.util.List;

public class AdapterEscolha extends RecyclerView.Adapter<AdapterEscolha.MyViewHolder>{

    private List<TamanhosEstufas> listaEstufas;
    private Context context;
    private View itemLista;
    private TextView textModelo;
    private ImageView imagem;

    public AdapterEscolha(List<TamanhosEstufas> listaEstufas, Context context, TextView modelo, ImageView imagem) {
        this.listaEstufas = listaEstufas;
        this.context = context;
        this.imagem = imagem;
        this.textModelo = modelo;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_preco_estufa, parent, false);
        return new AdapterEscolha.MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TamanhosEstufas tamanhosEstufas = listaEstufas.get(position);
        holder.tamanho.setText(tamanhosEstufas.getTamanho());
        holder.valor.setText(tamanhosEstufas.getValor());
        holder.informacoes.setText(tamanhosEstufas.getInformacoes());
        holder.btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PagamentoActivity.class);
                intent.putExtra("tamanho", tamanhosEstufas.getTamanho());
                intent.putExtra("valor", tamanhosEstufas.getValor());
                intent.putExtra("modelo", textModelo.getText());
                intent.putExtra("imagem", imagem.toString());
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaEstufas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tamanho;
        TextView informacoes;
        TextView valor;
        Button btnComprar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tamanho = itemView.findViewById(R.id.textTamanho);
            informacoes = itemView.findViewById(R.id.textInformacoes);
            valor = itemView.findViewById(R.id.textValor);
            btnComprar = itemView.findViewById((R.id.btnComprar));
        }
    }
}
