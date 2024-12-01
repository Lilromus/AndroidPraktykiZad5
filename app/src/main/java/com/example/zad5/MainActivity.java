package com.example.zad5;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Produkt> shoppingList;
    private ShoppingListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shoppingList = new ArrayList<>();

        RecyclerView rvShoppingList = findViewById(R.id.rvShoppingList);
        rvShoppingList.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ShoppingListAdapter(shoppingList);
        rvShoppingList.setAdapter(adapter);

        EditText etProductName = findViewById(R.id.etProductName);
        EditText etProductPrice = findViewById(R.id.etProductPrice);
        Button btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(v -> {
            String name = etProductName.getText().toString().trim();
            String priceText = etProductPrice.getText().toString().trim();

            if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(priceText)) {
                try {
                    double price = Double.parseDouble(priceText);
                    Produkt product = new Produkt(name, price + " PLN");
                    shoppingList.add(product);
                    adapter.notifyItemInserted(shoppingList.size() - 1);
                    etProductName.setText("");
                    etProductPrice.setText("");
                } catch (NumberFormatException e) {
                    etProductPrice.setError("Wprowadź poprawną cenę");
                }
            }
        });
    }
}
