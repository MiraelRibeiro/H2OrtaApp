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

public class AdapterComprar extends RecyclerView.Adapter <AdapterComprar.MyViewHolder> {

    private List<TamanhosEstufas> listaEstufas;
    private Context context;
    private View itemLista;

    public AdapterComprar(List<TamanhosEstufas> listaEstufas, Context context) {
        this.listaEstufas = listaEstufas;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_preco_estufa, parent, false);
        return new AdapterComprar.MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TamanhosEstufas tamanhosEstufas = listaEstufas.get(position);
        holder.tamanho.setText(tamanhosEstufas.getTamanho());
        holder.descricao.setText(tamanhosEstufas.getInformacoes());
        holder.valor.setText(tamanhosEstufas.getValor());
    }

    @Override
    public int getItemCount() {
        return listaEstufas.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tamanho;
        TextView descricao;
        TextView valor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tamanho = itemView.findViewById(R.id.textTamanho);
            descricao = itemView.findViewById(R.id.textDescricao);
            valor = itemView.findViewById(R.id.textValor);
        }
    }
}
