package com.example.mobile_final.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_final.ActivityOrder;
import com.example.mobile_final.Models.Order;
import com.example.mobile_final.Models.Product;
import com.example.mobile_final.R;

import java.util.ArrayList;

public class CartOrderAdapter extends RecyclerView.Adapter<CartOrderAdapter.MyViewHoder> {
    private ArrayList<Order> orders;
    private Context context;

    public CartOrderAdapter(ArrayList<Order> orders, Context context) {
        this.orders = orders;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //ket noi class - layout
        View view = LayoutInflater.from(context).inflate(R.layout.order_item_row, parent, false);
        return new MyViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoder holder, int position) {
        Order order = orders.get(position);
        Log.d("orderDetail", order.toString());
        holder.imageCard.setImageResource(order.getImage());
        holder.idCard.setText(order.getId()+"");
        holder.titleCard.setText(order.getFoodName());
        holder.priceCard.setText("Giá $" + order.getPrice());
        holder.quantityCard.setText("Số lượng" + order.getQuantity());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, ActivityOrder.class);
//                intent.putExtra("image", product.getImage());
//                intent.putExtra("title", product.getTitle());
//                intent.putExtra("price", product.getPrice() + "");
//                intent.putExtra("description", product.getDescription());
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class MyViewHoder extends RecyclerView.ViewHolder {
        private ImageView imageCard;
        private TextView priceCard, idCard,titleCard,quantityCard;

        public MyViewHoder(@NonNull View itemView) {
            super(itemView);
            titleCard=itemView.findViewById(R.id.titleCard);
            imageCard = itemView.findViewById(R.id.imageCard);
            priceCard = itemView.findViewById(R.id.priceCard);
            idCard = itemView.findViewById(R.id.idCard);
            quantityCard=itemView.findViewById(R.id.quantityCard);
        }
    }
}