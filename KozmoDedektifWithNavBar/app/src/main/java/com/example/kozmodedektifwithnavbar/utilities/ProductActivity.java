package com.example.kozmodedektifwithnavbar.utilities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kozmodedektifwithnavbar.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.Map;

public class ProductActivity extends AppCompatActivity {

    public long barcode;
    TextView productName, productBarcode;
    ImageView productImage;
    private FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        firebaseFirestore = FirebaseFirestore.getInstance();
        Intent intent = getIntent();
        intent.getStringExtra("result");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_product);
        productImage = (ImageView) findViewById(R.id.productImageView);
        productName = (TextView) findViewById(R.id.productNameText);
        barcode = Long.parseLong(intent.getStringExtra("result"));
        getProductInformation();
    }

    public void getProductInformation() {

        CollectionReference collectionReference = firebaseFirestore.collection("Product");
        collectionReference.whereEqualTo("barcode", barcode).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Toast.makeText(ProductActivity.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
                }
                if (queryDocumentSnapshots != null) {
                    for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {
                        Map<String, Object> data = snapshot.getData();

                        productName.setText(data.get("name").toString());
                        productBarcode.setText(data.get("barcode").toString());

                    }
                }

            }
        });
    }
}
