package com.pi.h2orta.ui.home;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pi.h2orta.R;
import com.pi.h2orta.adapter.AdapterEstufas;
import com.pi.h2orta.model.Estufa;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private List<Estufa> listaEstufas = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        if (listaEstufas.size()>0){
            listaEstufas.clear();
        }

        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        String linguagem = configuration.getLocales().toString().replace("[", "").replace("]", "");


        if (linguagem.equals("pt_BR")){
            preencherListaBr();
        }
        else if (linguagem.equals("en")){
            preencherListaEn();
        }
        else if (linguagem.equals("fr")){
            preencherListaFr();
        }
        else if (linguagem.equals("it")){
            preencherListaIt();
        }
        else if (linguagem.equals("es")){
            preencherListaEs();
        }

        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final RecyclerView recyclerView = root.findViewById(R.id.recyclerEstufas);

        AdapterEstufas adapterEstufas = new AdapterEstufas(listaEstufas, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterEstufas);

        return root;
    }

    public void preencherListaBr(){
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

    public void preencherListaEn(){
        Estufa estufa = new Estufa("Semi-Open","Semi-Open Model offers better visualization of the plants, does not have a refrigeration system, " +
                "but has an adjustable lighting system suitable for cultivation. It has three different sizes with a height of 40 cm ",
                R.drawable.primeiro_modeloaberto);
        listaEstufas.add( estufa);

        estufa = new Estufa("Semi-Open","Semi-Open Model offers better visualization of the plants, does not have a refrigeration system, " +
                "but has an adjustable lighting system suitable for cultivation. It has three different sizes with a height of 40 cm ",
                R.drawable.segundo_modeloaberto);
        listaEstufas.add( estufa);

        estufa = new Estufa("Aquarium","Model Aquarium has a simple water circulation system that uses the aquarium pump to deliver " +
                "nutrients to the plant, and a basic filtration system to maintain the ph balance. It has three different sizes with a height of 40cm." +
                "(Animals or plants in the image are for illustrative purposes only, they are not included with the product).",
                R.drawable.primeiro_modeloaquario);
        listaEstufas.add( estufa);

        estufa = new Estufa("Aquarium","Model Aquarium has a simple water circulation system that uses the aquarium pump to deliver " +
                "nutrients to the plant, and a basic filtration system to maintain the ph balance. It has three different sizes with a height of 40cm." +
                "(Animals or plants in the image are for illustrative purposes only, they are not included with the product).",
                R.drawable.segundo_modeloaquario);
        listaEstufas.add( estufa);

        estufa = new Estufa("Box Model","Box model has an integrated air and water circulation system, temperature control, ph control and an adjustable lighting " +
                "system in addition to a display with general greenhouse data, It has a nutrient input system (included separately)." +
                "It has three different sizes with a height of 100cm. (Animals or plants in the image are for illustrative purposes only, they are not included with the product).",
                R.drawable.primeiro_modelocaixa);
        listaEstufas.add( estufa);

        estufa = new Estufa("Box Model","Box model has an integrated air and water circulation system, temperature control, ph control and an adjustable lighting " +
                "system in addition to a display with general greenhouse data, It has a nutrient input system (included separately)." +
                "It has three different sizes with a height of 100cm. (Animals or plants in the image are for illustrative purposes only, they are not included with the product).",
                R.drawable.segundo_modelocaixa);
        listaEstufas.add( estufa);
    }

    public void preencherListaFr(){
        Estufa estufa = new Estufa("Modèle semi-ouvert","Le modèle semi-ouvert offre une meilleure visualisation des plantes, n'a pas de système de réfrigération, " +
                "mais dispose d'un système d'éclairage réglable adapté à la culture.Il a trois tailles différentes avec une hauteur de 40 cm",
                R.drawable.primeiro_modeloaberto);
        listaEstufas.add( estufa);

        estufa = new Estufa("Modèle semi-ouvert","Le modèle semi-ouvert offre une meilleure visualisation des plantes, n'a pas de système de réfrigération, " +
                "mais dispose d'un système d'éclairage réglable adapté à la culture.Il a trois tailles différentes avec une hauteur de 40 cm",
                R.drawable.segundo_modeloaberto);
        listaEstufas.add( estufa);

        estufa = new Estufa("Aquarium","Model Aquarium dispose d'un système de circulation d'eau simple qui utilise la pompe de " +
                "l'aquarium pour fournir des nutriments à la plante et d'un système de filtration de base pour maintenir l'équilibre du pH. Il a trois tailles différentes avec une hauteur de 40cm." +
                "(Les animaux ou les plantes dans l'image sont à titre indicatif seulement, ils ne sont pas inclus avec le produit).",
                R.drawable.primeiro_modeloaquario);
        listaEstufas.add( estufa);

        estufa = new Estufa("Aquarium","Model Aquarium dispose d'un système de circulation d'eau simple qui utilise la pompe de " +
                "l'aquarium pour fournir des nutriments à la plante et d'un système de filtration de base pour maintenir l'équilibre du pH. Il a trois tailles différentes avec une hauteur de 40cm." +
                "(Les animaux ou les plantes dans l'image sont à titre indicatif seulement, ils ne sont pas inclus avec le produit).",
                R.drawable.segundo_modeloaquario);
        listaEstufas.add( estufa);

        estufa = new Estufa("Modèle de boîte","Le modèle Box dispose d'un système de circulation d'air et d'eau intégré, d'un contrôle de la température, d'un contrôle du pH et d'un " +
                "système d'éclairage réglable en plus d'un affichage avec des données générales sur la serre, il dispose d'un système d'entrée de nutriments (inclus séparément)." +
                "Il a trois tailles différentes avec une hauteur de 100cm. (Les animaux ou les plantes dans l'image sont à titre indicatif seulement, ils ne sont pas inclus avec le produit).",
                R.drawable.primeiro_modelocaixa);
        listaEstufas.add( estufa);

        estufa = new Estufa("Modèle de boîte","Le modèle Box dispose d'un système de circulation d'air et d'eau intégré, d'un contrôle de la température, d'un contrôle du pH et d'un " +
                "système d'éclairage réglable en plus d'un affichage avec des données générales sur la serre, il dispose d'un système d'entrée de nutriments (inclus séparément)." +
                "Il a trois tailles différentes avec une hauteur de 100cm. (Les animaux ou les plantes dans l'image sont à titre indicatif seulement, ils ne sont pas inclus avec le produit).",
                R.drawable.segundo_modelocaixa);
        listaEstufas.add( estufa);
    }

    public void preencherListaIt(){
        Estufa estufa = new Estufa("Parzialmente aperto","Il modello semiaperto offre una migliore visualizzazione delle piante, non ha un sistema di refrigerazione, " +
                "ma ha un sistema di illuminazione regolabile adatto alla coltivazione, ha tre diverse dimensioni con un'altezza di 40 cm",
                R.drawable.primeiro_modeloaberto);
        listaEstufas.add( estufa);

        estufa = new Estufa("Parzialmente aperto","Il modello semiaperto offre una migliore visualizzazione delle piante, non ha un sistema di refrigerazione, " +
                "ma ha un sistema di illuminazione regolabile adatto alla coltivazione, ha tre diverse dimensioni con un'altezza di 40 cm",
                R.drawable.segundo_modeloaberto);
        listaEstufas.add( estufa);

        estufa = new Estufa("Acquario","Model Aquarium ha un semplice sistema di circolazione dell'acqua che utilizza " +
                "la pompa dell'acquario per fornire nutrienti alla pianta e un sistema di filtraggio di base per mantenere l'equilibrio del pH. Ha tre diverse dimensioni con un'altezza di 40 cm." +
                "(Animali o piante nell'immagine sono solo a scopo illustrativo, non sono inclusi con il prodotto).",
                R.drawable.primeiro_modeloaquario);
        listaEstufas.add( estufa);

        estufa = new Estufa("Acquario","Model Aquarium ha un semplice sistema di circolazione dell'acqua che utilizza " +
                "la pompa dell'acquario per fornire nutrienti alla pianta e un sistema di filtraggio di base per mantenere l'equilibrio del pH. Ha tre diverse dimensioni con un'altezza di 40 cm." +
                "(Animali o piante nell'immagine sono solo a scopo illustrativo, non sono inclusi con il prodotto).",
                R.drawable.segundo_modeloaquario);
        listaEstufas.add( estufa);

        estufa = new Estufa("Modello di scatola","Il modello Box ha un sistema integrato di circolazione dell'aria e dell'acqua, controllo della temperatura, " +
                "controllo del ph e un sistema di illuminazione regolabile oltre a un display con i dati generali della serra, ha un sistema di immissione dei nutrienti (incluso separatamente)." +
                "Ha tre diverse dimensioni con un'altezza di 100 cm. (Animali o piante nell'immagine sono solo a scopo illustrativo, non sono inclusi con il prodotto).",
                R.drawable.primeiro_modelocaixa);
        listaEstufas.add( estufa);

        estufa = new Estufa("Modello di scatola","Il modello Box ha un sistema integrato di circolazione dell'aria e dell'acqua, controllo della temperatura, " +
                "controllo del ph e un sistema di illuminazione regolabile oltre a un display con i dati generali della serra, ha un sistema di immissione dei nutrienti (incluso separatamente)." +
                "Ha tre diverse dimensioni con un'altezza di 100 cm. (Animali o piante nell'immagine sono solo a scopo illustrativo, non sono inclusi con il prodotto).",
                R.drawable.segundo_modelocaixa);
        listaEstufas.add( estufa);
    }

    public void preencherListaEs(){
        Estufa estufa = new Estufa("Parcialmente abierto","El modelo semiabierto ofrece una mejor visualización de las plantas, no tiene sistema de refrigeración, " +
                "pero tiene un sistema de iluminación regulable apto para cultivo.Tiene tres tamaños diferentes con una altura de 40 cm.",
                R.drawable.primeiro_modeloaberto);
        listaEstufas.add( estufa);

        estufa = new Estufa("Parcialmente abierto","El modelo semiabierto ofrece una mejor visualización de las plantas, no tiene sistema de refrigeración, " +
                "pero tiene un sistema de iluminación regulable apto para cultivo.Tiene tres tamaños diferentes con una altura de 40 cm.",
                R.drawable.segundo_modeloaberto);
        listaEstufas.add( estufa);

        estufa = new Estufa("Acuario","Model Aquarium tiene un sistema de circulación de agua simple que utiliza la bomba del acuario " +
                "para entregar nutrientes a la planta y un sistema de filtración básico para mantener el equilibrio del pH. Tiene tres tamaños diferentes con una altura de 40cm." +
                "(Los animales o plantas en la imagen son solo para fines ilustrativos, no están incluidos con el producto).",
                R.drawable.primeiro_modeloaquario);
        listaEstufas.add( estufa);

        estufa = new Estufa("Acuario","Model Aquarium tiene un sistema de circulación de agua simple que utiliza la bomba del acuario " +
                "para entregar nutrientes a la planta y un sistema de filtración básico para mantener el equilibrio del pH. Tiene tres tamaños diferentes con una altura de 40cm." +
                "(Los animales o plantas en la imagen son solo para fines ilustrativos, no están incluidos con el producto).",
                R.drawable.segundo_modeloaquario);
        listaEstufas.add( estufa);

        estufa = new Estufa("Modelo de caja","El modelo Box tiene un sistema integrado de circulación de aire y agua, control de temperatura, control de ph y un sistema " +
                "de iluminación ajustable además de una pantalla con datos generales del invernadero, tiene un sistema de entrada de nutrientes (incluido por separado)." +
                "Tiene tres tamaños diferentes con una altura de 100 cm. (Los animales o plantas en la imagen son solo para fines ilustrativos, no están incluidos con el producto).",
                R.drawable.primeiro_modelocaixa);
        listaEstufas.add( estufa);

        estufa = new Estufa("Modelo de caja","El modelo Box tiene un sistema integrado de circulación de aire y agua, control de temperatura, control de ph y un sistema " +
                "de iluminación ajustable además de una pantalla con datos generales del invernadero, tiene un sistema de entrada de nutrientes (incluido por separado)." +
                "Tiene tres tamaños diferentes con una altura de 100 cm. (Los animales o plantas en la imagen son solo para fines ilustrativos, no están incluidos con el producto).",
                R.drawable.segundo_modelocaixa);
        listaEstufas.add( estufa);
    }
}