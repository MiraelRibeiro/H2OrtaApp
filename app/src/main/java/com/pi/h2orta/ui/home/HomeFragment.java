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
        Estufa estufa = new Estufa("Semi-Aberta","Modelo Semi-Aberta oferece melhor visualiza????o das plantas, n??o possui sistema de refrigera????o, " +
                "mas conta com um sistema de ilumin????o ajust??vel e apropriado para o cultivo. Possui tr??s tamanhos diferentes com a altura de 40cm",
                R.drawable.primeiro_modeloaberto);
        listaEstufas.add( estufa);

        estufa = new Estufa("Semi-Aberta","Modelo Semi-Aberta oferece melhor visualiza????o das plantas, n??o possui sistema de refrigera????o, " +
                "mas conta com um sistema de ilumin????o ajust??vel e apropriado para o cultivo. Possui tr??s tamanhos diferentes com a altura de 40cm",
                R.drawable.segundo_modeloaberto);
        listaEstufas.add( estufa);

        estufa = new Estufa("Aqu??rio","Modelo Aqu??rio possui um sistema simple de circula????o da ??gua que utiliza a bomba do aqu??rio" +
                " para levar os nutrientes at?? a planta, e um sistema de filtragem b??sico para manter o equil??brio do ph. Possui tr??s tamanhos diferentes " +
                "com a altura de 40cm. (Animais ou plantas da imagem s??o meramente ilustrativas, n??o s??o inclusos com o produto).",
                R.drawable.primeiro_modeloaquario);
        listaEstufas.add( estufa);

        estufa = new Estufa("Aqu??rio","Modelo Aqu??rio possui um sistema simple de circula????o da ??gua que utiliza a bomba do aqu??rio" +
                " para levar os nutrientes at?? a planta, e um sistema de filtragem b??sico para manter o equil??brio do ph. Possui tr??s tamanhos diferentes " +
                "com a altura de 40cm. (Animais ou plantas da imagem s??o meramente ilustrativas, n??o s??o inclusos com o produto).",
                R.drawable.segundo_modeloaquario);
        listaEstufas.add( estufa);

        estufa = new Estufa("Box Model","BoxModel possui um sistema integrado de circula????o de ar e de ??gua, controle de temperatura," +
                " controle do ph e um sistema de ilumina????o ajust??vel al??m de um display com os dados gerais da estufa, possui um sistema de inserir nutrientes " +
                "(incluso separadamente). Possui tr??s tamanhos diferentes com a altura de 100cm. (Animais ou plantas da imagem s??o meramente ilustrativas, n??o s??o inclusos com o produto).",
                R.drawable.primeiro_modelocaixa);
        listaEstufas.add( estufa);

        estufa = new Estufa("Box Model","BoxModel possui um sistema integrado de circula????o de ar e de ??gua, controle de temperatura," +
                " controle do ph e um sistema de ilumina????o ajust??vel al??m de um display com os dados gerais da estufa, possui um sistema de inserir nutrientes " +
                "(incluso separadamente). Possui tr??s tamanhos diferentes com a altura de 100cm. (Animais ou plantas da imagem s??o meramente ilustrativas, n??o s??o inclusos com o produto).",
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
        Estufa estufa = new Estufa("Mod??le semi-ouvert","Le mod??le semi-ouvert offre une meilleure visualisation des plantes, n'a pas de syst??me de r??frig??ration, " +
                "mais dispose d'un syst??me d'??clairage r??glable adapt?? ?? la culture.Il a trois tailles diff??rentes avec une hauteur de 40 cm",
                R.drawable.primeiro_modeloaberto);
        listaEstufas.add( estufa);

        estufa = new Estufa("Mod??le semi-ouvert","Le mod??le semi-ouvert offre une meilleure visualisation des plantes, n'a pas de syst??me de r??frig??ration, " +
                "mais dispose d'un syst??me d'??clairage r??glable adapt?? ?? la culture.Il a trois tailles diff??rentes avec une hauteur de 40 cm",
                R.drawable.segundo_modeloaberto);
        listaEstufas.add( estufa);

        estufa = new Estufa("Aquarium","Model Aquarium dispose d'un syst??me de circulation d'eau simple qui utilise la pompe de " +
                "l'aquarium pour fournir des nutriments ?? la plante et d'un syst??me de filtration de base pour maintenir l'??quilibre du pH. Il a trois tailles diff??rentes avec une hauteur de 40cm." +
                "(Les animaux ou les plantes dans l'image sont ?? titre indicatif seulement, ils ne sont pas inclus avec le produit).",
                R.drawable.primeiro_modeloaquario);
        listaEstufas.add( estufa);

        estufa = new Estufa("Aquarium","Model Aquarium dispose d'un syst??me de circulation d'eau simple qui utilise la pompe de " +
                "l'aquarium pour fournir des nutriments ?? la plante et d'un syst??me de filtration de base pour maintenir l'??quilibre du pH. Il a trois tailles diff??rentes avec une hauteur de 40cm." +
                "(Les animaux ou les plantes dans l'image sont ?? titre indicatif seulement, ils ne sont pas inclus avec le produit).",
                R.drawable.segundo_modeloaquario);
        listaEstufas.add( estufa);

        estufa = new Estufa("Mod??le de bo??te","Le mod??le Box dispose d'un syst??me de circulation d'air et d'eau int??gr??, d'un contr??le de la temp??rature, d'un contr??le du pH et d'un " +
                "syst??me d'??clairage r??glable en plus d'un affichage avec des donn??es g??n??rales sur la serre, il dispose d'un syst??me d'entr??e de nutriments (inclus s??par??ment)." +
                "Il a trois tailles diff??rentes avec une hauteur de 100cm. (Les animaux ou les plantes dans l'image sont ?? titre indicatif seulement, ils ne sont pas inclus avec le produit).",
                R.drawable.primeiro_modelocaixa);
        listaEstufas.add( estufa);

        estufa = new Estufa("Mod??le de bo??te","Le mod??le Box dispose d'un syst??me de circulation d'air et d'eau int??gr??, d'un contr??le de la temp??rature, d'un contr??le du pH et d'un " +
                "syst??me d'??clairage r??glable en plus d'un affichage avec des donn??es g??n??rales sur la serre, il dispose d'un syst??me d'entr??e de nutriments (inclus s??par??ment)." +
                "Il a trois tailles diff??rentes avec une hauteur de 100cm. (Les animaux ou les plantes dans l'image sont ?? titre indicatif seulement, ils ne sont pas inclus avec le produit).",
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
        Estufa estufa = new Estufa("Parcialmente abierto","El modelo semiabierto ofrece una mejor visualizaci??n de las plantas, no tiene sistema de refrigeraci??n, " +
                "pero tiene un sistema de iluminaci??n regulable apto para cultivo.Tiene tres tama??os diferentes con una altura de 40 cm.",
                R.drawable.primeiro_modeloaberto);
        listaEstufas.add( estufa);

        estufa = new Estufa("Parcialmente abierto","El modelo semiabierto ofrece una mejor visualizaci??n de las plantas, no tiene sistema de refrigeraci??n, " +
                "pero tiene un sistema de iluminaci??n regulable apto para cultivo.Tiene tres tama??os diferentes con una altura de 40 cm.",
                R.drawable.segundo_modeloaberto);
        listaEstufas.add( estufa);

        estufa = new Estufa("Acuario","Model Aquarium tiene un sistema de circulaci??n de agua simple que utiliza la bomba del acuario " +
                "para entregar nutrientes a la planta y un sistema de filtraci??n b??sico para mantener el equilibrio del pH. Tiene tres tama??os diferentes con una altura de 40cm." +
                "(Los animales o plantas en la imagen son solo para fines ilustrativos, no est??n incluidos con el producto).",
                R.drawable.primeiro_modeloaquario);
        listaEstufas.add( estufa);

        estufa = new Estufa("Acuario","Model Aquarium tiene un sistema de circulaci??n de agua simple que utiliza la bomba del acuario " +
                "para entregar nutrientes a la planta y un sistema de filtraci??n b??sico para mantener el equilibrio del pH. Tiene tres tama??os diferentes con una altura de 40cm." +
                "(Los animales o plantas en la imagen son solo para fines ilustrativos, no est??n incluidos con el producto).",
                R.drawable.segundo_modeloaquario);
        listaEstufas.add( estufa);

        estufa = new Estufa("Modelo de caja","El modelo Box tiene un sistema integrado de circulaci??n de aire y agua, control de temperatura, control de ph y un sistema " +
                "de iluminaci??n ajustable adem??s de una pantalla con datos generales del invernadero, tiene un sistema de entrada de nutrientes (incluido por separado)." +
                "Tiene tres tama??os diferentes con una altura de 100 cm. (Los animales o plantas en la imagen son solo para fines ilustrativos, no est??n incluidos con el producto).",
                R.drawable.primeiro_modelocaixa);
        listaEstufas.add( estufa);

        estufa = new Estufa("Modelo de caja","El modelo Box tiene un sistema integrado de circulaci??n de aire y agua, control de temperatura, control de ph y un sistema " +
                "de iluminaci??n ajustable adem??s de una pantalla con datos generales del invernadero, tiene un sistema de entrada de nutrientes (incluido por separado)." +
                "Tiene tres tama??os diferentes con una altura de 100 cm. (Los animales o plantas en la imagen son solo para fines ilustrativos, no est??n incluidos con el producto).",
                R.drawable.segundo_modelocaixa);
        listaEstufas.add( estufa);
    }
}