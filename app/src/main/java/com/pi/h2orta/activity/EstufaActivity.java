package com.pi.h2orta.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pi.h2orta.R;
import com.pi.h2orta.adapter.AdapterComprar;
import com.pi.h2orta.adapter.AdapterEscolha;
import com.pi.h2orta.model.TamanhosEstufas;
import com.pi.h2orta.ui.gallery.GalleryFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EstufaActivity extends AppCompatActivity {

    private TextView textModelo;
    private ImageView imagem;
    private RecyclerView recyclerView;
    public List<TamanhosEstufas> listaTamanhos = new ArrayList<>();
    private int imagemRecebida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estufa);

        iniciarComponentes();

        Bundle dados = getIntent().getExtras();
        textModelo.setText(dados.getString("modelo"));
        imagemRecebida = dados.getInt("imagem");
        imagem.setImageResource(imagemRecebida);

        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        String linguagem = configuration.getLocales().toString().replace("[", "").replace("]", "");


        if (linguagem.equals("pt_BR")){
            preencheListaBR();
        }
        else if (linguagem.equals("fr")){
            preencheListaFr();
        }
        else if (linguagem.equals("en")){
            preencheListaEn();
        }
        else if (linguagem.equals("it")){
            preencheListaIt();
        }
        else if (linguagem.equals("es")){
            preencheListaEs();
        }

        try {
            AdapterEscolha adapterEscolha = new AdapterEscolha(listaTamanhos, getApplicationContext(), textModelo);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapterEscolha);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void preencheListaBR() {
        listaTamanhos.clear();
        if(textModelo.getText().toString().equals("Semi-Aberta"))
        {
            TamanhosEstufas tamanhos = new TamanhosEstufas("Normal", "R$ 500,00", "8 slots(5 cm de di??metros) 2 fileiras 4 slots Lumin??ria t??rmica ajust??vel Sem bomba de circula????o de ??gua Tamanho total 45x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("M??dio", "R$ 600,00", "10 slots(5 cm de di??metros) 2 fileiras 5 slots Lumin??ria t??rmica ajust??vel Sem bomba de circula????o de ??gua Tamanho total 55x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Grande", "R$ 700,00", "12 slots(5 cm de di??metros) 3 fileiras 4 slots Lumin??ria t??rmica ajust??vel Com bomba de circula????o de ??gua Tamanho total 45x35 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);
        }

        else if(textModelo.getText().toString().equals("Aqu??rio"))
        {
            TamanhosEstufas tamanhos = new TamanhosEstufas("Normal", "R$ 700,00", "8 slots(5 cm de di??metros)\n" +
                    "2 fileiras 4 slots\n Aqu??rio, filtro\n Com bomba de circula????o de ??gua\n Tamanho total 45x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("M??dio", "R$ 800,00", "10 slots(5 cm de di??metros)\n 2 fileiras 5 slots\n" +
                    "Aqu??rio, filtro\n Com bomba de circula????o de ??gua\n Tamanho total 55x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Grande", "R$ 900,00", "12 slots(5 cm de di??metros)\n" +
                    "3 fileiras 4 slots\n Aqu??rio, filtro, display de temperatura e ph\n Com bomba de circula????o de ??gua\n" +
                    "Tamanho total 45x35 cms", imagemRecebida);
            listaTamanhos.add(tamanhos);
        }

        else if(textModelo.getText().toString().equals("Box Model"))
        {
            TamanhosEstufas tamanhos = new TamanhosEstufas("Normal", "R$ 1.000,00", "8 slots(5 cm de di??metros)\n" +
                    "2 fileiras 4 slots\n Display, sensores de temperatura e ph, filtro, lumin??ria t??rmica, ventila????o\n" +
                    "Com bomba de circula????o de ??gua\n Tamanho total 45x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("M??dio", "R$ 1.200,00", "10 slots(5 cm de di??metros)\n" +
                    "2 fileiras 5 slots\n Display, sensores de temperatura e ph, filtro, lumin??ria t??rmica, ventila????o\n" +
                    "Com bomba de circula????o de ??gua\n Tamanho total 55x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Grande", "R$ 1.400,00", "12 slots(5 cm de di??metros)\n" +
                    "3 fileiras 4 slots\n Display, sensores de temperatura e ph, filtro, lumin??ria t??rmica, controle de temperatura e ventila????o\n" +
                    "Com bomba de circula????o de ??gua\n Tamanho total 45x35 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);
        }

    }

    private void preencheListaFr() {
        listaTamanhos.clear();
        if(textModelo.getText().toString().equals("Mod??le semi-ouvert"))
        {
            TamanhosEstufas tamanhos = new TamanhosEstufas("Normal", "??? 82,08", "8 fentes (5 cm de diam??tre) \n2 lignes 4 fentes  \nLumi??re thermique r??glable \nPas de pompe de circulation d'eau \nDimensions totales 45x25cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Moyenne", "??? 98,49", "10 fentes(5 cm de diam??tre) \n2 lignes 5 fentes \nLumi??re thermique r??glable \nPas de pompe de circulation d'eau \nDimensions totales 55x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("G??nial", "??? 114,91", "12 fentes(5 cm de diam??tre) \n3 lignes 4 fentes\n Lumi??re thermique r??glable \nAvec pompe de circulation d'eau \nDimensions totales 45x35 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);
        }

        else if(textModelo.getText().toString().equals("Aquarium"))
        {
            TamanhosEstufas tamanhos = new TamanhosEstufas("Normal", "??? 114,91", "8 fentes (5 cm de diam??tre)\n" +
                    "2 lignes 4 emplacements\n aquarium, filtre\n Avec pompe de circulation d'eau\n Dimensions totales 45x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Moyenne", "??? 131,32", "10 fentes(5 cm de diam??tre)\n 2 lignes 5 emplacements\n" +
                    "Aquarium, filtre\n Avec pompe de circulation d'eau\n Dimensions totales 55x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("G??nial", "??? 147,74", "12 fentes(5 cm de diam??tre)\n" +
                    "3 lignes 4 emplacements\n Aquarium, filtre, affichage de la temp??rature et du pH\n Avec pompe de circulation d'eau\n" +
                    "Dimensions totales 45x35cm", imagemRecebida);
            listaTamanhos.add(tamanhos);
        }

        else if(textModelo.getText().toString().equals("Mod??le de bo??te"))
        {
            TamanhosEstufas tamanhos = new TamanhosEstufas("Normal", "??? 164,16", "8 emplacements (5 cm de diam??tre) \n" +
                    "2 rang??es 4 emplacements\n Afficheur, capteurs de temp??rature et de ph, filtre, ??clairage thermique, ventilation avec \n" +
                    "pompe de circulation d'eau\n Dimensions totales 45X25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Moyenne", "??? 196,99", "10 emplacements (5 cm de diam??tre) \n" +
                    "2 rang??es 5 emplacements\n Afficheur, capteurs de temp??rature et de ph, filtre, ??clairage thermique, ventilation avec \n" +
                    "pompe de circulation d'eau\n Dimensions totales 55X25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("G??nial", "??? 229,82", "12 emplacements (5 cm de diam??tre) \n" +
                    "3 rang??es 4 emplacements\n Affichage, capteurs de temp??rature et de ph, filtre, ??clairage thermique, contr??le de temp??rature et ventilation avec \n" +
                    "pompe de circulation d'eau\n Dimensions totales 45X35 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);
        }

    }

    private void preencheListaEn() {
        listaTamanhos.clear();
        if(textModelo.getText().toString().equals("Semi-Open"))
        {
            TamanhosEstufas tamanhos = new TamanhosEstufas("Normal", "US$ 99.1", "8 slots (5 cm diameter)  \n2 rows 4 slots \nAdjustable thermal light \nWithout water circulation pump  \nOverall size 45x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Average", "US$ 118.92", "10 slots(5 cm diameter) \n2 rows 5 slots \nAdjustable thermal light \nWithout water circulation pump \nOverall size 55x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Great", "US$ 138.74", "12 slots(5 cm diameter) \n3 rows 4 slots \nAdjustable thermal light \nWith water circulation pump \nOverall size 45x35 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);
        }

        else if(textModelo.getText().toString().equals("Aquarium"))
        {
            TamanhosEstufas tamanhos = new TamanhosEstufas("Normal", "US$ 138.74", "8 slots(5 cm diameter)\n" +
                    "2 rows 4 slots\n Aquarium, filter\n With water circulation pump \n Overall size 45x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Average", "R$ 800,00", "10 slots(5 cm diameter)\n 2 rows 5 slots\n" +
                    "Aquarium, filter\n With water circulation pump \n Overall size 55x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Great", "R$ 900,00", "12 slots(5 cm diameter)\n" +
                    "3 rows 4 slots\n Aquarium, filter, Display temperature and ph sensors\n With water circulation pump \n" +
                    "Overall size 45x35 cms", imagemRecebida);
            listaTamanhos.add(tamanhos);
        }

        else if(textModelo.getText().toString().equals("Box Model"))
        {
            TamanhosEstufas tamanhos = new TamanhosEstufas("Normal", "R$ 1.000,00", "8 slots (5 cm in diameter) \n" +
                    "2 rows 4 slots\n Display, temperature and ph sensors, filter, thermal lighting, ventilation \n" +
                    "with water circulation pump\n total size 45X25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Average", "R$ 1.200,00", "10 slots (5cm diameter)\n" +
                    "2 rows 5 slots\n Display, temperature and ph sensors, filter, thermal lighting, ventilation \n" +
                    "with water circulation pump\n Tamanho total 55x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Great", "R$ 1.400,00", "12 slots (5cm diameter) \n" +
                    "3 rows 4 slots\n Display, temperature and ph sensors, filter, thermal lighting, temperature control and ventilation\n" +
                    "with water circulation pump\n Total size 45X35 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);
        }

    }

    private void preencheListaIt() {
        listaTamanhos.clear();
        if(textModelo.getText().toString().equals("Parzialmente aperto"))
        {
            TamanhosEstufas tamanhos = new TamanhosEstufas("Normale", "??? 82,08", "8 fessure (5 cm di diametro)\n 2 righe 4 slot\n Luce termica regolabile. Nessuna pompa di circolazione dell'acqua\n Dimensioni totali 45x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Media", "??? 98,49", "10 fessure (5 cm di diametro)\n2 righe 5 slot \nApparecchio termico orientabile. Nessuna pompa di circolazione dell'acqua \nDimensioni totali 55x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Grande", "??? 114,91", "12 fessure (5 cm di diametro) \n3 righe 4 slot  \nLuce termica regolabile. Nessuna pompa di circolazione dell'acqua \nDimensioni totali 45x35 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);
        }

        else if(textModelo.getText().toString().equals("Acquario"))
        {
            TamanhosEstufas tamanhos = new TamanhosEstufas("Normale", "??? 114,91", "8 fessure (5 cm di diametro)\n" +
                    "3 righe 4 slot\n acquario, filtro\n Con pompa di circolazione dell'acqua\n Dimensioni totali 45x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Media", "??? 131,32", "10 fessure (5 cm di diametro)\n 2 righe. 5 slot\n" +
                    "acquario, filtro\n Con pompa di circolazione dell'acqua\n Dimensioni totali 45x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Grande", "??? 147,74", "12 fessure (5 cm di diametro)\n" +
                    "3 righe 4 slot\n Acquario, filtro, display della temperatura e del PH\n Con pompa di circolazione dell'acqua\n" +
                    "Dimensioni totali 45x35 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);
        }

        else if(textModelo.getText().toString().equals("Modello di scatola"))
        {
            TamanhosEstufas tamanhos = new TamanhosEstufas("Normale", "??? 164,16", "8 fessure (5 cm di diametro)\n" +
                    "2 file 4 fessure\n Display, sensori di temperatura e ph, filtro, illuminazione termica, ventilazione\n" +
                    "Con pompa di circolazione dell'acqua\n Dimensione totale 45X25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Media", "??? 196,99", "10 slot (diametro 5 cm)\n" +
                    "2 file 5 slot\n Display, sensori di temperatura e ph, filtro, illuminazione termica, ventilazione\n" +
                    "Con pompa di circolazione dell'acqua\n Dimensioni totali 55X25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Grande", "??? 229,82", "12 slot (diametro 5 cm)\n" +
                    "3 file 4 slot\n Display, sensori di temperatura e ph, filtro, illuminazione termica, controllo della temperatura e ventilazione\n" +
                    "con pompa di circolazione dell'acqua\n Dimensioni totali 45X35 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);
        }

    }

    private void preencheListaEs() {
        listaTamanhos.clear();
        if(textModelo.getText().toString().equals("Parcialmente abierto"))
        {
            TamanhosEstufas tamanhos = new TamanhosEstufas("Normal", "??? 82,08", "8 ranuras (5 cm de di??metro) \n2 l??neas 4 ranuras  \nLuz t??rmica regulable \n. Sin bomba de circulaci??n de agua \nDimensiones totales 45x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Promedio", "??? 98,49", "10 ranuras (5 cm de di??metro) \n2 l??neas 5 ranuras  \nLuz t??rmica ajustable \nSin bomba de circulaci??n de agua \nDimensiones totales 55x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Estupendo", "??? 114,91", "12 ranuras (5 cm de di??metro) \n3 l??neas 4 ranuras \nLuz t??rmica regulable \nBomba de circulaci??n de agua \nDimensiones totales 45x35 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);
        }

        else if(textModelo.getText().toString().equals("Acuario"))
        {
            TamanhosEstufas tamanhos = new TamanhosEstufas("Normal", "??? 114,91", "8 ranuras (5 cm de di??metro)\n" +
                    "2 l??neas. 4 ranuras\n acuario, filtro\n Con bomba de circulaci??n de agua\n Dimensiones totales 45x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Promedio", "??? 131,32", "10 ranuras (5 cm de di??metro)\n 2 l??neas 5 ranuras\n" +
                    "acuario, filtro\n Con bomba de circulaci??n de agua\n Dimensiones totales 55x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Estupendo", "??? 147,74", "12 ranuras(5 cm de di??metro)\n" +
                    "3 l??neas 4 ranuras\n acuario, filtro, Display, sensores de temperatura y ph\n Con bomba de circulaci??n de agua\n" +
                    "Dimensiones totales 45x35 cms", imagemRecebida);
            listaTamanhos.add(tamanhos);
        }

        else if(textModelo.getText().toString().equals("Modelo de caja"))
        {
            TamanhosEstufas tamanhos = new TamanhosEstufas("Normal", "??? 164,16", "8 ranuras (5 cm de di??metro)\n" +
                    "2 filas 4 ranuras\n Display, sensores de temperatura y ph, filtro, iluminaci??n t??rmica, ventilaci??n\n" +
                    "Con bomba de circulaci??n de agua\n Tama??o total 45X25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Promedio", "??? 196,99", "10 slots(5 cm de di??metros)\n" +
                    "2 fileiras 5 slots\n Display, sensores de temperatura e ph, filtro, lumin??ria t??rmica, ventila????o\n" +
                    "Com bomba de circula????o de ??gua\n Tamanho total 55x25 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);

            tamanhos = new TamanhosEstufas("Estupendo", "??? 229,82", "12 ranuras (5 cm de di??metro)\n" +
                    "3 filas 4 ranuras\n Display, sensores de temperatura y ph, filtro, iluminaci??n t??rmica, control de temperatura y ventilaci??n \n" +
                    "Con bomba de circulaci??n de agua\n Tama??o total 45X35 cm", imagemRecebida);
            listaTamanhos.add(tamanhos);
        }

    }

    private void iniciarComponentes(){
        textModelo = findViewById(R.id.textModeloEstuda);
        imagem = findViewById(R.id.imagemDaEstufa);
        recyclerView = findViewById(R.id.recyclerValores);
    }
}