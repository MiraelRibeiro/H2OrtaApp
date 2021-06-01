package com.pi.h2orta.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pi.h2orta.R;
import com.pi.h2orta.activity.EstufaActivity;
import com.pi.h2orta.model.Estufa;

import java.util.List;

public class AdapterEstufas extends RecyclerView.Adapter<AdapterEstufas.MyViewHolder> {

    private List<Estufa> listaEstufas;
    private Context context;
    private View itemLista;

    public AdapterEstufas() {
    }

    public AdapterEstufas(List<Estufa> listaServicos, Context context) {
        this.listaEstufas = listaServicos;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_estufas, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Estufa estufa = listaEstufas.get(position);
        holder.textModelo.setText(estufa.getModelo());
        holder.textDescricao.setText(estufa.getDescricao());
        holder.imagem.setImageResource(estufa.getImagem());

        itemLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EstufaActivity.class);
                intent.putExtra("modelo", estufa.getModelo());
                intent.putExtra("imagem", estufa.getImagem());
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

        TextView textModelo;
        TextView textDescricao;
        ImageView imagem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textModelo = itemView.findViewById(R.id.textModelo);
            textDescricao = itemView.findViewById(R.id.textDescricao);
            imagem = itemView.findViewById(R.id.imageEstufa);
        }
    }
}
