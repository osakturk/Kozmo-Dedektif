package com.example.kozmodedektifwithnavbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.PostHolder> {

    private ArrayList<String> productNameList;
    private ArrayList<String> productImageList;


    public MainRecyclerAdapter(ArrayList<String> productNameList, ArrayList<String> productImageList) {
        this.productNameList = productNameList;
        this.productImageList = productImageList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_row,parent,false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {

        holder.productNameText.setText(productNameList.get(position));
        Picasso.get().load(productImageList.get(position)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return productNameList.size();
    }

    class PostHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView productNameText;

        public PostHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.recyclerview_row_imageview);
            productNameText = itemView.findViewById(R.id.recyclerview_row_name_text);

        }
    }
}
