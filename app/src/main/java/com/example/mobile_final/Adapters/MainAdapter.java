package com.example.mobile_final.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_final.ActivityOrder;
import com.example.mobile_final.Models.Product;
import com.example.mobile_final.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHoder> {
    private ArrayList<Product> products;
    private Context context;

    public MainAdapter(ArrayList<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }
    @NonNull
    @Override
    public viewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //ket noi class - layout
        View view = LayoutInflater.from(context).inflate(R.layout.detail_item,parent,false);
        return new viewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHoder holder, int position) {
        Product product = products.get(position);
        holder.imageProduct.setImageResource(product.getImage());
        holder.titleProduct.setText(product.getTitle());
        holder.priceProduct.setText("$"+product.getPrice());
        holder.descriptionProduct.setText(product.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityOrder.class);
                intent.putExtra("image",product.getImage());
                intent.putExtra("title",product.getTitle());
                intent.putExtra("price",product.getPrice()+"");
                intent.putExtra("description",product.getDescription());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class viewHoder extends RecyclerView.ViewHolder {
        private ImageView imageProduct;
        private TextView titleProduct,priceProduct,descriptionProduct;

        public viewHoder(@NonNull View itemView) {
            super(itemView);
            imageProduct = itemView.findViewById(R.id.image);
            titleProduct = itemView.findViewById(R.id.title);
            priceProduct = itemView.findViewById(R.id.price);
            descriptionProduct = itemView.findViewById(R.id.desctiption);
        }
    }


}
