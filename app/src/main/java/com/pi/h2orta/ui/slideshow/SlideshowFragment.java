package com.pi.h2orta.ui.slideshow;

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

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        final TextView textViewFone = root.findViewById(R.id.textViewFone);
        final TextView textViewNumero = root.findViewById(R.id.textViewNumero);
        final TextView textViewEmail = root.findViewById(R.id.textViewEmail);
        final TextView textEmailCompleto = root.findViewById(R.id.textEmailCompleto);
        final TextView textEndereco = root.findViewById(R.id.textEndereco);
        final TextView textLocal = root.findViewById(R.id.textLocal);
        final ImageView imagemEmail = root.findViewById(R.id.imageFone);
        final ImageView imagemTelefone = root.findViewById(R.id.imageEmail);

        return root;
    }
}