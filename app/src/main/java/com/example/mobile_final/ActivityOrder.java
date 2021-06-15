package com.example.mobile_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobile_final.SQLDatabase.DBHelpler;

public class ActivityOrder extends AppCompatActivity {
    private ImageView imageOrder,minusOrder,plusOrder;
    private TextView titleOrder, priceOrder, descriptionOrder,btnOrder,quantityOrder;
    private DBHelpler dbHelpler;
    EditText yourNameOrder,phoneOrder;
    private static int priceSaveDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        //init OrderView
        imageOrder = findViewById(R.id.imageOrder);
        minusOrder=findViewById(R.id.minus);
        plusOrder=findViewById(R.id.plus);
        titleOrder = findViewById(R.id.titleOrder);
        priceOrder = findViewById(R.id.priceOrder);
        descriptionOrder = findViewById(R.id.descriptionOrder);
        btnOrder=findViewById(R.id.btnOrder);
        yourNameOrder = findViewById(R.id.yourNameOrder);
        phoneOrder = findViewById(R.id.phoneOrder);
        quantityOrder=findViewById(R.id.quantity);

        //data binding to main
        int image = getIntent().getIntExtra("image", 0);
        String title = getIntent().getStringExtra("title");
        int price = Integer.parseInt(getIntent().getStringExtra("price"));
        String description = getIntent().getStringExtra("description");
        String _quantity = quantityOrder.getText().toString();
        dbHelpler= new DBHelpler(this);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dbHelpler.insertOrder(yourNameOrder.getText().toString(), phoneOrder.getText().toString(),image,priceSaveDataBase,description,title,Integer.parseInt(quantityOrder.getText().toString()))== true) {
                    Toast.makeText(ActivityOrder.this, "Thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getBaseContext(), MainActivity.class));
                }else{
                    Toast.makeText(ActivityOrder.this, "Thất bại", Toast.LENGTH_SHORT).show();
                };

            }
        });
        minusOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int _quantity = Integer.parseInt(quantityOrder.getText().toString());
               if(_quantity == 1) {
                   Toast.makeText(ActivityOrder.this,"Số lượng lớn hơn 0",Toast.LENGTH_SHORT).show();
               }else{
                   quantityOrder.setText(_quantity-1+"");
                   priceSaveDataBase=price*(_quantity-1);
                   priceOrder.setText("$ " + price*(_quantity-1));
               }
            }
        });
        plusOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int _quantity = Integer.parseInt(quantityOrder.getText().toString()) + 1;

                    quantityOrder.setText(_quantity+"");
                priceSaveDataBase=price*(_quantity+1);
                priceOrder.setText("$ " + price*_quantity);
            }
        });
        // show data to view
        imageOrder.setImageResource(image);
        titleOrder.setText(title);
        priceOrder.setText("$ " + price);
        descriptionOrder.setText(description);


    }
}