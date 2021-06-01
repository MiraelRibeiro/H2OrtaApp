package com.pi.h2orta.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.pi.h2orta.R;

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

        return root;
    }
}