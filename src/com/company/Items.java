package com.company;

public class Items {
    String itemName;
    int quantity;
    double priceItem;

    public Items(String name, int q, double price){
        itemName = name;
        quantity = q;
        priceItem = price;
    }

    public void updateItem(int q, double price){
        quantity = q;
        priceItem = price;
    }



}
