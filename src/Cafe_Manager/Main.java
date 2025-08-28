package Cafe_Manager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Cafe cafe = new Cafe();

        System.out.println("Welcome to the Cafe!");
        System.out.println("--------------------");

        System.out.println("Specify the menu for your cafe:");
        System.out.println();

        System.out.println("Enter Menu Item 1 Name: ");
        String name1 = scnr.nextLine();

        System.out.println("Enter Menu Item 1 Price: ");
        double price1 = scnr.nextDouble();
        scnr.nextLine(); //after it stores the double, we need to proceed

        System.out.println("Enter Menu Item 1 Category (ie. Food, Drink): ");
        String category1 = scnr.nextLine();

        MenuItem item1 = new MenuItem(name1, price1, category1);
        cafe.addMenuItem1(item1); //create the menuitem instance with the info, then add to cafe menu
        System.out.println();

        //Get Menu Item 2 info now
        System.out.println("Enter Menu Item 2 Name: ");
        String name2 = scnr.nextLine();
        System.out.println("Enter Menu Item 2 Price: ");
        double price2 = scnr.nextDouble();
        scnr.nextLine();

        System.out.println("Enter Menu Item 2 Category (ie. Food, Drink): ");
        String category2 = scnr.nextLine();
        MenuItem item2 = new MenuItem(name2, price2, category2);
        cafe.addMenuItem2(item2);
        System.out.println();

        //etc

        System.out.println("Enter Menu Item 3 Name: ");
        String name3 = scnr.nextLine();
        System.out.println("Enter Menu Item 3 Price: ");
        double price3 = scnr.nextDouble();
        scnr.nextLine();
        System.out.println("Enter Menu Item 3 Category (ie. Food, Drink): ");
        String category3 = scnr.nextLine();
        MenuItem item3 = new MenuItem(name3, price3, category3);
        cafe.addMenuItem3(item3);
        System.out.println();

        //Show the menu
        cafe.displayMenu();
        System.out.println();

        //Take order
        System.out.println("Place your order: You can order items by entering 1, 2, 3, or 0 to skip, followed by quantity. ");
        System.out.println("Example: for 1 x item 2, enter 2 1");
        System.out.println("When finished ordering, enter 0 0");
        System.out.println();

        Order order = new Order();

        //wrapping this in a loop with 0 to exit
        while (true) {
            System.out.print("Enter item number and quantity (Or 0 0 to finish): ");
            int itemChoice = scnr.nextInt();
            int quantity = scnr.nextInt();

            if (itemChoice == 0) {
                break;
            }

            if (quantity <= 0) {
                System.out.println("Quantity must be greater than 0");
                continue;
            }
            if (itemChoice == 1) {
                order.addItem1(item1, quantity);
                System.out.println("Added " + quantity + "x " + item1.getName());

            } else if (itemChoice == 2) {
                order.addItem2(item2, quantity);
                System.out.println("Added " + quantity + "x " + item2.getName());

            } else if (itemChoice == 3) {
                order.addItem3(item3, quantity);
                System.out.println("Added " + quantity + "x " + item3.getName());

            } else {
                System.out.println("Invalid item choice, enter 1, 2 or 3 followed by quantity");
            }
        }

        //place order
        cafe.placeOrder(order);

        System.out.println();
        order.displayOrderDetails();

        scnr.close();

    }
}
