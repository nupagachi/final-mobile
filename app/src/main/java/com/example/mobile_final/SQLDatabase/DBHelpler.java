package com.example.mobile_final.SQLDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mobile_final.Models.Order;

import java.util.ArrayList;
import java.util.List;

public class DBHelpler extends SQLiteOpenHelper {
     final static String DB_NAME ="mobile_final.db";
    public DBHelpler(@Nullable Context context) {
        super(context, DB_NAME, null, 2);
    }

    public DBHelpler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String querryCreate = "CREATE TABLE orders (" +
                "id INTEGER PRIMARY KEY, name TEXT, phone TEXT,image int, price INT, quantity INT, description TEXT, foodname TEXT)";

        db.execSQL(querryCreate);

//        db.execSQL("create table orders" + "(id int primary key autoincrement,"+"name text,"+"phone text,"+"price int,"+"description text,"+"foodname text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists orders");
        onCreate(db);
    }

    public boolean insertOrder(String name,String phone,int image,int price,String description,String foodName,Integer quantity){
        SQLiteDatabase sqLiteDatabase= getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("image",image);
        values.put("price",price);
        values.put("description",description);
        values.put("foodname",foodName);
        values.put("quantity",quantity);
        long id = sqLiteDatabase.insert("orders",null,values);
        if(id<=0) {
            return false;
        }
            return true;
    }
    public List<Order> getAllOrder () {
        SQLiteDatabase db =  getReadableDatabase();;
        List<Order> orderList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM orders", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(0);
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String phone = cursor.getString(cursor.getColumnIndex("phone"));
                Integer image = cursor.getInt(cursor.getColumnIndex("image"));
                Integer price = cursor.getInt(cursor.getColumnIndex("price"));
                Integer quantity = cursor.getInt(cursor.getColumnIndex("quantity"));
                String description = cursor.getString(cursor.getColumnIndex("description"));
                String foodName = cursor.getString(cursor.getColumnIndex("foodname"));
                Order order= new Order(id,name,phone,image,price,quantity,description,foodName);
                orderList.add(order);
                cursor.moveToNext();
            }
        }
        return orderList;

    }

    public boolean updateOrder(String name,String phone,int image,int price,String description,String foodName,Integer quantity,int id){
        SQLiteDatabase sqLiteDatabase= getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("image",image);
        values.put("price",price);
        values.put("description",description);
        values.put("foodname",foodName);
        values.put("quantity",quantity);
        int row = sqLiteDatabase.update("orders",values,"id="+id,null);
        if(id<=0) {
            return false;
        }
        return true;
    }
}
