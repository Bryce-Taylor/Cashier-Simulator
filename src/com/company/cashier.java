package com.company;


import java.util.Scanner;

public class cashier {
    static Scanner input = new Scanner(System.in);
    public static void cashierPotions() {
        boolean isCustomer;
        System.out.print("New Customer(Y or N)? ");
        String customer = input.next().substring(0,1).toLowerCase();
        if(customer.equals("y")){
            isCustomer = false;
        }else{
            isCustomer = true;
        }

        while (!isCustomer){
            checkingCustomerItems();
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            for (Items items : customersItems.item){
                System.out.printf("- ItemName: "+items.itemName +" | Quantity:"+items.quantity+" | Cost: $"+(("%.2f"+ "\n")),items.priceItem);
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            }
            System.out.println("Checkout(c) - Update Your Items(u) - Delete item (d) - Add more Items (a)");
            System.out.print("> ");
            String userInput = input.next().substring(0,1).toLowerCase();
            if(userInput.equals("c")){
                paymentProcess();
                isCustomer = true;
            }else if (userInput.equals("u")){
                customersItems.updateItem();
            }else if (userInput.equals("d")){
                customersItems.deleteItem();
            }else if (userInput.equals("a")){
                checkingCustomerItems();
            }else{
                System.out.println("Please type in the correct input");
            }
        }
    }

    public static void paymentProcess(){
        boolean cashOrDebit = true;
        while (cashOrDebit) {
            System.out.printf("\nHere is your Total: "+(("%.2f"+ "\n")),customersItems.calculatingTotal());
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.print("How would you like to pay?[Cash or Debit] ");
            String paying = input.next().substring(0, 1).toLowerCase();
            if (paying.equals("c")) {
                double pay = customersItems.paymentWithCash();
                System.out.print("Would you like too have you receipt?[Y/N] ");
                String receipt = input.next().substring(0,1).toLowerCase();
                if(receipt.equals("y")){
                    customersItems.receipt(paying, pay);
                }
                cashOrDebit = false;
            } else if(paying.equals("d")){
                double pay = customersItems.paymentWithCash();
                System.out.print("Would you like too have you receipt?[Y/N] ");
                String receipt = input.next().substring(0,1).toLowerCase();
                if(receipt.equals("y")){
                    customersItems.receipt(paying, pay);
                }
                cashOrDebit = false;
            } else{
                System.out.println("Please type in the correct input");
            }
        }
    }

    public static void checkingCustomerItems(){
        boolean checkingItems = false;
        while (!checkingItems) {
            System.out.print("New Item(Y or N)? ");
            String newItem = input.next().substring(0, 1).toLowerCase();
            if(newItem.equals("y")){
                customersItems.addItem();
            }
            else if (newItem.equals("n")) {
                checkingItems = true;
            } else {
                System.out.println("Please type in the correct input");
            }
        }
    }

//    public static void tryAgainPaying() {
//        boolean isCustomer = false;
//        while (!isCustomer) {
//            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
//            for (Items items : customersItems.item) {
//                System.out.printf("- ItemName: " + items.itemName + " | Quantity:" + items.quantity + " | Cost: $" + (("%.2f" + "\n")), items.priceItem);
//                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
//            }
//            System.out.println("Checkout(c) - Update Your Items(u) - Delete item (d) - Add more Items (a)");
//            System.out.print("> ");
//            String userInput = input.next().substring(0, 1).toLowerCase();
//            if (userInput.equals("c")) {
//                paymentProcess();
//                isCustomer = true;
//            } else if (userInput.equals("u")) {
//                customersItems.updateItem();
//            } else if (userInput.equals("d")) {
//                customersItems.deleteItem();
//            } else if (userInput.equals("a")) {
//                checkingCustomerItems();
//            } else {
//                System.out.println("Please type in the correct input");
//            }
//        }
//    }
}
