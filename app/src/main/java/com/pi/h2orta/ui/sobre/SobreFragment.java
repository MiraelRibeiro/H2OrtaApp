package com.pi.h2orta.ui.sobre;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pi.h2orta.R;

public class SobreFragment extends Fragment {

    private SobreViewModel mViewModel;

    public static SobreFragment newInstance() {
        return new SobreFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.sobre_fragment, container, false);

        final TextView textSobre = root.findViewById(R.id.textSobre);
        final TextView textEmpresa = root.findViewById(R.id.textSobreEmpresa);
        final TextView textPorque = root.findViewById(R.id.textPorque);
        final TextView textEsplic = root.findViewById(R.id.textEsplicacao);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SobreViewModel.class);
        // TODO: Use the ViewModel
    }

}