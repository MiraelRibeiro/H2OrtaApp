package com.pi.h2orta.ui.gallery;

import android.content.ClipData;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.pi.h2orta.MainActivity;
import com.pi.h2orta.R;
import com.pi.h2orta.ui.home.HomeFragment;

import java.util.Locale;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final ImageView imagemBr = root.findViewById(R.id.imagemBrasil);
        final ImageView imagemUSA = root.findViewById(R.id.imagemUSA);
        final ImageView imagemItalia = root.findViewById(R.id.imagemItalia);
        final ImageView imagemFranca = root.findViewById(R.id.imagemFranca);
        final ImageView imagemEspanha = root.findViewById(R.id.imagemEspanha);



        imagemBr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                configurarLinguagem("br");
                Toast.makeText(getContext(), "Alterado para português!", Toast.LENGTH_SHORT).show();
            }
        });

        imagemUSA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                configurarLinguagem("en");
                Toast.makeText(getContext(), "Changed to English!", Toast.LENGTH_SHORT).show();
            }
        });

        imagemItalia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                configurarLinguagem("it");
                Toast.makeText(getContext(), "Cambiato in italiano!", Toast.LENGTH_SHORT).show();
            }
        });

        imagemFranca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                configurarLinguagem("fr");
                Toast.makeText(getContext(), "Changé en français!", Toast.LENGTH_SHORT).show();
            }
        });

        imagemEspanha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                configurarLinguagem("es");
                Toast.makeText(getContext(), "Cambiado a español!", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }

    public void configurarLinguagem(String linguagem){
        Locale linguagemLocal = new Locale(linguagem);
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.locale =linguagemLocal;
        resources.updateConfiguration(configuration, displayMetrics);

    }
}