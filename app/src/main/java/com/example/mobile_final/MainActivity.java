package com.example.mobile_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.mobile_final.Adapters.MainAdapter;
import com.example.mobile_final.Models.Product;
import com.example.mobile_final.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//private ActivityMainBinding binding;
RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.recycleView);

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(R.drawable.kfc,"Combo KFC","70000","decription 1"));
        products.add(new Product(R.drawable.food1,"Combo hamburger","1000","decription 2"));
        products.add(new Product(R.drawable.food2,"hamburger loại 1","40000","decription 3"));
        products.add(new Product(R.drawable.food3,"hamburger loại 2","50000","decription 4"));
        products.add(new Product(R.drawable.food4,"hamburger loại 3","60000","decription 5"));
        products.add(new Product(R.drawable.food5,"hamburger loại 4","60000","decription 5"));
        products.add(new Product(R.drawable.food6,"KFC","60000","decription 5"));
        MainAdapter mainAdapter = new MainAdapter(products,this);
        recyclerView.setAdapter(mainAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.cart) {
            startActivity(new Intent(getBaseContext(), CartActivity.class));
        }
        return true;
    }

}