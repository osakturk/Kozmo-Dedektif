package com.example.kozmodedektifwithnavbar.ui.products;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.kozmodedektifwithnavbar.R;
import com.example.kozmodedektifwithnavbar.ui.search.SearchViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductFragment extends Fragment {

    private ProductViewModel mViewModel;

    @BindView(R.id.productContentText)
    TextView productContentTextView;

    @BindView(R.id.productNameText)
    TextView productNameTextView;

    public static ProductFragment newInstance() {
        return new ProductFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel =
                ViewModelProviders.of(this).get(ProductViewModel.class);
        View root = inflater.inflate(R.layout.fragment_product, container, false);
        ButterKnife.bind(this,root);
        mViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        // TODO: Use the ViewModel
    }

}
