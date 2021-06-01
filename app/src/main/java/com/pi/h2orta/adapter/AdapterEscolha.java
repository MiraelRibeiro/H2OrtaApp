package com.pi.h2orta.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pi.h2orta.R;
import com.pi.h2orta.model.TamanhosEstufas;

import java.util.List;

public class AdapterEscolha extends RecyclerView.Adapter<AdapterEscolha.MyViewHolder>{

    private List<TamanhosEstufas> listaEstufas;
    private Context context;
    private View itemLista;

    public AdapterEscolha(List<TamanhosEstufas> listaEstufas, Context context) {
        this.listaEstufas = listaEstufas;
        this.context = context;
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
    }

    @Override
    public int getItemCount() {
        return listaEstufas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tamanho;
        TextView informacoes;
        TextView valor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tamanho = itemView.findViewById(R.id.textTamanho);
            informacoes = itemView.findViewById(R.id.textInformacoes);
            valor = itemView.findViewById(R.id.textValor);
        }
    }
}
