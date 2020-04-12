package com.example.kozmodedektifwithnavbar.ui.ocr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.kozmodedektifwithnavbar.R;
import com.example.kozmodedektifwithnavbar.ui.search.SearchViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OcrFragment extends Fragment {

    private OcrViewModel ocrViewModel;
/*
    @BindView(R.id.text_ocr)
    TextView textView;*/
/*
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ocrViewModel =
                ViewModelProviders.of(this).get(OcrViewModel.class);
        View root = inflater.inflate(R.layout.fragment_ocr, container, false);
        ButterKnife.bind(this,root);
        ocrViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }

    */
}
