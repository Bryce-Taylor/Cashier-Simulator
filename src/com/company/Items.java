package com.company;

public class Items {
    String itemName;
    double priceItem;

    public Items(String item, double price){
        itemName = item;
        priceItem = price;
    }

    public double getPriceItem() {
        return priceItem;
    }

    public String getItemName(){
        return itemName;
    }


}
