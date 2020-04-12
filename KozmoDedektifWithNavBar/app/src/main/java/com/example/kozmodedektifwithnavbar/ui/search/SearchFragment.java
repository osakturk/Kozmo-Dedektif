package com.example.kozmodedektifwithnavbar.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.kozmodedektifwithnavbar.R;
import com.example.kozmodedektifwithnavbar.ui.products.ProductFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchFragment extends Fragment {

    private SearchViewModel searchViewModel;

    @BindView(R.id.changeFragment)
    Button changeFragment;

    @BindView(R.id.text_search)
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        searchViewModel =
                ViewModelProviders.of(this).get(SearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this,root);
        searchViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        changeFragment.setOnClickListener(v -> {
            searchViewModel.pushFragment(new ProductFragment(),getFragmentManager());
        });


        return root;
    }
}
