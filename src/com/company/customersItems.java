package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class customersItems {
    static ArrayList<Items> item = new ArrayList<>();

    static Scanner input = new Scanner(System.in);

    static int paying = generatorRandomPay();
    static double cardNumber = generatorRandomDebitCardNumber();
    static int cvvNumber = generatorRandomDebitCardCVVNumber();
//    public static void items() {
//        item.add(new Items("Sprite 24 pack", 7.88));
//        item.add(new Items("Dr Pepper 12 pack", 5.18));
//        item.add(new Items("Pepsi 12 pack", 3.68));
//        item.add(new Items("Mountain Dew 12 pack", 3.68));
//        item.add(new Items("Reese's Puffs Cereal 31.2 oz", 4.98));
//        item.add(new Items("Cinnamon Toast Crunch 19.3 oz.", 3.64));
//        item.add(new Items("Fruity PEBBLES Cereal 27.5 Ounce", 4.98));
//        item.add(new Items("Cheerios 18oz", 3.64));
//        item.add(new Items("Tyson® Any'tizers® Popcorn Chicken 1.5 lb Bag", 6.30));
//        item.add(new Items("Farm Rich Breaded Mozzarella Sticks, 52 Oz", 9.96));
//        item.add(new Items("Totino's Pizza Rolls, Pepperoni, 120 Rolls, 59.3 oz Bag", 9.26));
//        item.add(new Items("Tai Pei Chicken Fried Rice Frozen Asian Entrée 11 oz", 2.52));
//        item.add(new Items("Lay's Barbecue Flavored Potato Chips, Party Size, 12.5 oz Bag", 3.57));
//        item.add(new Items("Doritos Nаcho Cheese Flavored Party Size!", 3.98));
//        item.add(new Items("Takis Fuego Flavored Tortilla Chips, Fiesta Size, 20 oz", 4.42));
//        item.add(new Items("Cheetos Crunchy Cheese Flavored Snacks, Party Size, 15 oz Bag", 3.98));
//        item.add(new Items("Wonder® Giant Enriched Bread 24 oz. Loaf", 2.28));
//        item.add(new Items("King's Hawaiian Original Hawaiian Sweet Rolls 12 CT (Pack - 3)", 17.79));
//        item.add(new Items("Nature's Own 100% Whole Grain Bread - 20 oz Bag", 10.99));
//        item.add(new Items("Sprite 12 Pack", 7.88));
//    }

    public static void addItem(){
        String itemName;
        int quantity = 0;
        double cost = 0;

        boolean validQuantity = false;
        boolean validCost = false;


        System.out.print("ItemName: ");
        itemName = input.next();

        while (!validQuantity){
            System.out.print("Quantity: ");
            quantity = input.nextInt();
            if(quantity > 0){
                validQuantity = true;
            }else {
                System.out.println("Please put a number greater than 0");
            }
        }
        while (!validCost){
            System.out.print("Cost: $");
            cost = input.nextDouble();
            if(cost > 0){
                validCost = true;
            }else {
                System.out.println("Please put a number greater than 0");
            }
        }
        item.add(new Items(itemName, quantity, cost));
    }

    public static void updateItem(){
        System.out.print("ItemName: ");
        String name = input.next().toLowerCase();
        boolean updated = false;
        for(Items newItem : item){
            if(name.equalsIgnoreCase(newItem.itemName)){
                int quantity = 0;
                double cost = 0;

                boolean validQuantity = false;
                boolean validCost = false;

                while (!validQuantity){
                    System.out.print("Quantity: ");
                    quantity = input.nextInt();
                    if(quantity > 0){
                        validQuantity = true;
                    }else {
                        System.out.println("Please put a number greater than 0");
                    }
                }

                while (!validCost){
                    System.out.print("Cost: $");
                    cost = input.nextDouble();
                    if(cost > 0){
                        validCost = true;
                    }else {
                        System.out.println("Please put a number greater than 0");
                    }
                }

                newItem.updateItem(quantity, cost);
                updated = true;
            }
        }
        if(!updated){
            System.out.println("This item doesn't exist");
        }
    }

    public static void deleteItem(){
        System.out.print("ItemName: ");
        String name = input.next().toLowerCase();
        boolean found = false;
        for(Items i : item){
            if(name.equalsIgnoreCase(i.itemName)){
                System.out.println(i.itemName+" was deleted off the item list\n");
                item.remove(i);

                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("This item doesn't exist");
        }
    }

    public static double calculatingSubTotal(){
        double sum = 0;
        for(Items d : item){
            sum += (d.priceItem * d.quantity);
        }
        return Math.round(sum * 100) / 100.0;
    }

    public static double calculatingTotal(){
        double total = (calculatingSubTotal() + calculatingTaxes());
        return Math.round(total * 100) / 100.0;
    }


    public static double calculatingTaxes(){
        double tax = (calculatingSubTotal() * 0.07);
        return Math.round(tax * 100) / 100.0;
    }

    public static double customerWallet(double total){
        double customerPaying = 0;

        if (paying == 1){
            customerPaying = Math.round(total)+2;
        }else if(paying == 2){
            customerPaying = Math.round(total);
        }
        else if(paying == 3){
            customerPaying = Math.round(total);
        }
        else if(paying == 4){
            customerPaying = Math.round(total);
        }
        else if(paying == 5){
            customerPaying = Math.round(total)+3;
        }
        else if(paying == 6){
            customerPaying = Math.round(total)+5;
        }
        if(customerPaying < total){
            customerPaying++;
        }

        return customerPaying;
    }
    public static double calculatingCustomerPayment(double pay){
        double total = (pay - calculatingTotal());
        return Math.round(total * 100) / 100.0;
    }

    public static int generatorRandomPay() {
        int min = 1;
        int max = 3;

        Random random = new Random();

        return random.nextInt(max + min) + min;
    }

    public static double paymentWithCash(){
        double total = calculatingTotal();
        double customerPayed = customerWallet(total);
        boolean validPayment = false;
        double amountPayed = 0;
        while(!validPayment){
            System.out.printf("Customer gave you $" +  (("%.2f" + "\n")),customerPayed);
            System.out.print("Customer Payment: $");
            double payment = input.nextDouble();
            if(payment >= calculatingTotal() && payment == customerPayed){
                amountPayed = payment;
                System.out.println("**PAYMENT SUCCESSFULLY**");
                validPayment = true;
            }else{
                System.out.println("**PAYMENT IS NOT OVER TOTAL**");
            }
        }
        return amountPayed;
    }

    public static int paymentWithDebit(){
        boolean validDebitNumber = false;
        boolean validDebitNumberCVV = false;
        int debitNumber = 0;
        System.out.println("Customer enter their debit card number last four digits and their CVV number as well");
        while(!validDebitNumber){
            System.out.printf("Here is the Debit Card Number: " +(("%.0f"+ "\n")), cardNumber);
            System.out.print("Enter the Debit Card Number: ");
            int debit = input.nextInt();
            if(debit == cardNumber){
                debitNumber = debit;
                System.out.println("**SUCCESSFULLY ENTER THE CORRECT DEBIT CARD NUMBER**\n");
                validDebitNumber = true;
            }else{
                System.out.println("**INCORRECT DEBIT CARD NUMBER**");
            }
        }
        while(!validDebitNumberCVV){
            System.out.println("Here is the Debit Card CVV Number: " + cvvNumber);
            System.out.print("Enter the Debit Card CVV Number: ");
            int cvv = input.nextInt();
            if(cvv == cvvNumber){
                System.out.println("**SUCCESSFULLY ENTER THE CORRECT DEBIT CARD CVV NUMBER**\n");
                validDebitNumberCVV = true;
            }else{
                System.out.println("**INCORRECT DEBIT CARD CVV NUMBER**");
            }
        }
        return debitNumber;
    }

    public static int generatorRandomDebitCardNumber() {
        int min = 1000;
        int max = 9998;

        min = (int) Math.ceil(min);
        max = (int) Math.floor(max);
        return (int) (Math.floor(Math.random() * (max - min + 1)) + min);
    }
    public static int generatorRandomDebitCardCVVNumber() {
        int min = 100;
        int max = 998;

        min = (int) Math.ceil(min);
        max = (int) Math.floor(max);
        return (int) (Math.floor(Math.random() * (max - min + 1)) + min);
    }

    public static void receipt(String cashOrDebit, double pay, int card){
        if(cashOrDebit.equals("c")){
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            for (Items items : item){
                System.out.printf("- ItemName: "+items.itemName +" | Quantity:"+items.quantity+" | Cost: $"+(("%.2f"+ "\n")),items.priceItem);
            }
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.printf("                                 SUBTOTAL       $"+(("%.2f"+ "\n")),calculatingSubTotal());
            System.out.printf("                                 TAX            $"+(("%.2f"+ "\n")),+calculatingTaxes());
            System.out.printf("                                 TOTAL          $"+(("%.2f"+ "\n")),calculatingTotal());
            System.out.printf("                                 CASH DUE       $"+(("%.2f"+ "\n")),pay);
            System.out.printf("                                 CHANGE DUE     $"+(("%.2f"+ "\n")),calculatingCustomerPayment(pay));
        }else if(cashOrDebit.equals("d")){
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            for (Items items : item){
                System.out.printf("- ItemName: "+items.itemName +" | Quantity:"+items.quantity+" | Cost: $"+(("%.2f"+ "\n")),items.priceItem);
            }
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.printf("                                 SUBTOTAL       $"+(("%.2f"+ "\n")),calculatingSubTotal());
            System.out.printf("                                 TAX            $"+(("%.2f"+ "\n")),+calculatingTaxes());
            System.out.printf("                                 TOTAL          $"+(("%.2f"+ "\n")),calculatingTotal());
            System.out.printf("                                 DEBIT (POS)    $"+(("%.2f"+ "\n")),calculatingTotal());
            System.out.println("                                   XXXXXXXXXXXX"+ card);
            System.out.println("                                 CHANGE DUE     $0.00");


        }

    }
}


