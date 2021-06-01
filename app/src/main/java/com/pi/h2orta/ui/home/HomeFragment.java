package com.pi.h2orta.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pi.h2orta.R;
import com.pi.h2orta.adapter.AdapterEstufas;
import com.pi.h2orta.model.Estufa;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private List<Estufa> listaEstufas = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        if (listaEstufas.size()>0){
            listaEstufas.clear();
        }
        preencherLista();

        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final RecyclerView recyclerView = root.findViewById(R.id.recyclerEstufas);
        // testar isso pra ver se da certo
        AdapterEstufas adapterEstufas = new AdapterEstufas(listaEstufas, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterEstufas);

        return root;
    }

    public void preencherLista(){
        Estufa estufa = new Estufa("Semi-Aberta","Modelo Semi-Aberta oferece melhor visualização das plantas, não possui sistema de refrigeração, " +
                "mas conta com um sistema de iluminção ajustável e apropriado para o cultivo. Possui três tamanhos diferentes com a altura de 40cm",
                R.drawable.primeiro_modeloaberto);
        listaEstufas.add( estufa);

        estufa = new Estufa("Semi-Aberta","Modelo Semi-Aberta oferece melhor visualização das plantas, não possui sistema de refrigeração, " +
                "mas conta com um sistema de iluminção ajustável e apropriado para o cultivo. Possui três tamanhos diferentes com a altura de 40cm",
                R.drawable.segundo_modeloaberto);
        listaEstufas.add( estufa);

        estufa = new Estufa("Aquário","Modelo Aquário possui um sistema simple de circulação da água que utiliza a bomba do aquário" +
                " para levar os nutrientes até a planta, e um sistema de filtragem básico para manter o equilíbrio do ph. Possui três tamanhos diferentes " +
                "com a altura de 40cm. (Animais ou plantas da imagem são meramente ilustrativas, não são inclusos com o produto).",
                R.drawable.primeiro_modeloaquario);
        listaEstufas.add( estufa);

        estufa = new Estufa("Aquário","Modelo Aquário possui um sistema simple de circulação da água que utiliza a bomba do aquário" +
                " para levar os nutrientes até a planta, e um sistema de filtragem básico para manter o equilíbrio do ph. Possui três tamanhos diferentes " +
                "com a altura de 40cm. (Animais ou plantas da imagem são meramente ilustrativas, não são inclusos com o produto).",
                R.drawable.segundo_modeloaquario);
        listaEstufas.add( estufa);

        estufa = new Estufa("Box Model","BoxModel possui um sistema integrado de circulação de ar e de água, controle de temperatura," +
                " controle do ph e um sistema de iluminação ajustável além de um display com os dados gerais da estufa, possui um sistema de inserir nutrientes " +
                "(incluso separadamente). Possui três tamanhos diferentes com a altura de 100cm. (Animais ou plantas da imagem são meramente ilustrativas, não são inclusos com o produto).",
                R.drawable.primeiro_modelocaixa);
        listaEstufas.add( estufa);

        estufa = new Estufa("Box Model","BoxModel possui um sistema integrado de circulação de ar e de água, controle de temperatura," +
                " controle do ph e um sistema de iluminação ajustável além de um display com os dados gerais da estufa, possui um sistema de inserir nutrientes " +
                "(incluso separadamente). Possui três tamanhos diferentes com a altura de 100cm. (Animais ou plantas da imagem são meramente ilustrativas, não são inclusos com o produto).",
                R.drawable.segundo_modelocaixa);
        listaEstufas.add( estufa);
    }
}