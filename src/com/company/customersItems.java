package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class customersItems {
    static ArrayList<Items> item = new ArrayList<>();
    static ArrayList<Items> customerItem = new ArrayList<>();
    static ArrayList<Items> scanItem = new ArrayList<>();

    static Scanner input = new Scanner(System.in);

    int amountItems = 0;

    public static void items() {
        item.add(new Items("Sprite 24 pack", 7.88));
        item.add(new Items("Dr Pepper 12 pack", 5.18));
        item.add(new Items("Pepsi 12 pack", 3.68));
        item.add(new Items("Mountain Dew 12 pack", 3.68));
        item.add(new Items("Reese's Puffs Cereal 31.2 oz", 4.98));
        item.add(new Items("Cinnamon Toast Crunch 19.3 oz.", 3.64));
        item.add(new Items("Fruity PEBBLES Cereal 27.5 Ounce", 4.98));
        item.add(new Items("Cheerios 18oz", 3.64));
        item.add(new Items("Tyson® Any'tizers® Popcorn Chicken 1.5 lb Bag", 6.30));
        item.add(new Items("Farm Rich Breaded Mozzarella Sticks, 52 Oz", 9.96));
        item.add(new Items("Totino's Pizza Rolls, Pepperoni, 120 Rolls, 59.3 oz Bag", 9.26));
        item.add(new Items("Tai Pei Chicken Fried Rice Frozen Asian Entrée 11 oz", 2.52));
        item.add(new Items("Lay's Barbecue Flavored Potato Chips, Party Size, 12.5 oz Bag", 3.57));
        item.add(new Items("Doritos Nаcho Cheese Flavored Party Size!", 3.98));
        item.add(new Items("Takis Fuego Flavored Tortilla Chips, Fiesta Size, 20 oz", 4.42));
        item.add(new Items("Cheetos Crunchy Cheese Flavored Snacks, Party Size, 15 oz Bag", 3.98));
        item.add(new Items("Wonder® Giant Enriched Bread 24 oz. Loaf", 2.28));
        item.add(new Items("King's Hawaiian Original Hawaiian Sweet Rolls 12 CT (Pack - 3)", 17.79));
        item.add(new Items("Nature's Own 100% Whole Grain Bread - 20 oz Bag", 10.99));
        item.add(new Items("Sprite", 7.88));

    }

    public static void randomItems(){
        int numberOfItems = randomNumber();

        Random random_method = new Random();

        int countItems = 0;


        for (int i = 0; i < numberOfItems; i++) {
            countItems++;
            int randomIndex = random_method.nextInt(item.size());
            customerItem.add(item.get(randomIndex));
            item.remove(randomIndex);
        }
        System.out.println("[Their are "+countItems+ " items]");
    }

    public static void scanningItems(){
        for (Items list : customerItem) {
            while (true){
                System.out.print("Scan item:[type 'scan' to scan item] ");
                String scan = input.nextLine().substring(0,1).toLowerCase();
                if(scan.equals("s")){
                    System.out.println(list.itemName +" $"+list.priceItem);
                    System.out.println("**SCAN ITEM**\n");
                    scanItem.add(list);
                    break;
                }else{
                    System.out.println("please type the correct input");
                }
            }

        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        for (Items itemsScan : scanItem){
            System.out.println("- "+itemsScan.itemName +" \n  $"+itemsScan.priceItem);
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.printf("Total: $"+(("%.2f"+ "\n")), calculatingTotal());
    }

    public static double calculatingSubTotal(){
        double sum = 0;
        for(Items d : scanItem){
            sum += d.priceItem;
        }
        return sum;
    }

    public static double calculatingTotal(){
        double sum = 0;
        for(Items d : scanItem){
            sum += d.priceItem;
        }
        double tax = (sum * 0.07);
        double round = Math.round(tax * 100) / 100.0;
        double total = (sum + round);
        return Math.round(total * 100) / 100.0;
    }

    public static double calculatingTaxes(){
        double sum = 0;
        for(Items d : scanItem){
            sum += d.priceItem;
        }
        double tax = (sum * 0.07);
        return Math.round(tax * 100) / 100.0;
    }

    public static double customerWallet(){
        int paying = randomHowTheyPay();
        
        double customerPaying = 0;
        
        if (paying == 1){
            customerPaying = calculatingTotal();
        }else if(paying == 2){
            customerPaying = Math.round(calculatingTotal())+1;
        }
        else if(paying == 3){
            customerPaying = Math.round(calculatingTotal())+1;
        }
        else if(paying == 4){
            customerPaying = Math.round(calculatingTotal())+1;
        }
        else if(paying == 5){
            customerPaying = Math.round(calculatingTotal())+1;
        }
        return customerPaying;
    }

    public static int randomHowTheyPay() {
        int min = 1;
        int max = 3;

        Random random = new Random();

        return random.nextInt(max + min) + min;
    }

    public static int randomNumber() {
        int min = 1;
        int max = 3;

        Random random = new Random();

        return random.nextInt(max + min) + min;
    }

    public static void receipt(String cashOrDebit){
        double customerPayed = customerWallet();
        if(cashOrDebit.equals("c")){
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            for (Items itemsScan : scanItem){
                System.out.println("- "+itemsScan.itemName +" \n  $"+itemsScan.priceItem);
            }
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println("                                 SUBTOTAL       $"+calculatingSubTotal()+"");
            System.out.println("                                 TAX            $"+calculatingTaxes()+"");
            System.out.println("                                 TOTAL          $"+calculatingTotal()+"");
            System.out.println("                                 CASH DUE       $"+customerWallet()+"");
            System.out.printf("                                 CHANGE DUE     $"+(("%.2f"+ "\n")),(customerPayed - calculatingTotal()));
        }else if(cashOrDebit.equals("d")){
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            for (Items itemsScan : scanItem){
                System.out.println("- "+itemsScan.itemName +" \n  $"+itemsScan.priceItem);
            }
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println("                                 SUBTOTAL       $"+calculatingSubTotal()+"");
            System.out.println("                                 TAX            $"+calculatingTaxes()+"");
            System.out.println("                                 TOTAL          $"+calculatingTotal()+"");
            System.out.println("                                 DEBIT DUE      $"+calculatingTotal()+"");
            System.out.println("                                 CHANGE DUE     $0.00");


        }
//
//        System.out.printf("Total: $"+(("%.2f"+ "\n")), calculatingTotal());
//
//        System.out.println("$"+customerPayed);

        customerItem.clear();
        scanItem.clear();
    }
}


