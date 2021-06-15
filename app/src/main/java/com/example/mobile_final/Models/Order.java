package com.example.mobile_final.Models;

public class Order {
    private int id;
    private String name;
    private String phone;
    private int image;
    private int price;
    private int quantity;
    private String description;
    private String foodName;

    public Order(int id, String name, String phone, int image, int price, int quantity, String description, String foodName) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.foodName = foodName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", foodName='" + foodName + '\'' +
                '}';
    }
}
