package com.company;

import java.util.Random;
import java.util.Scanner;

public class cashier {
    static Scanner input = new Scanner(System.in);
    public static void cashierPotions(){
        int customers = randomHowManyCustomer();
        int counter = 0;
        while (counter < customers){
            System.out.println("There are "+customers+" customers");
            customersItems.items();
            customersItems.randomItems();
            customersItems.scanningItems();
            System.out.print("How would you like to pay?[Cash or Debit] ");
            String paying = input.nextLine().substring(0,1).toLowerCase();
            System.out.print("Would you like too have you receipt?[Y/N] ");
            String receipt = input.nextLine().substring(0,1).toLowerCase();
            if(receipt.equals("y")){
                customersItems.receipt(paying);
            }
            System.out.println("\nHave a Nice Day!\n");
            counter++;

        }
    }

    public static int randomHowManyCustomer() {
        int min = 1;
        int max = 2;

        Random random = new Random();

        return random.nextInt(max + min) + min;
    }
}
