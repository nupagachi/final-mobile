package com.example.mobile_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobile_final.Adapters.CartOrderAdapter;
import com.example.mobile_final.Models.Order;
import com.example.mobile_final.SQLDatabase.DBHelpler;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        RecyclerView recyclerView = findViewById(R.id.cart_recyclerview);
        TextView textView = findViewById(R.id.textView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DBHelpler dbHelpler = new DBHelpler(this);

        ArrayList<Order> list = (ArrayList<Order>) dbHelpler.getAllOrder();
        if (list.size() == 0) {
            textView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
        }
        else {
            textView.setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
        }

        CartOrderAdapter adapter = new CartOrderAdapter(list, this);
        recyclerView.setAdapter(adapter);

    }
}