package Cafe_Manager;

public class Test {
    public static void main(String[] args) {
        System.out.println("   Cafe Test:");
        System.out.println("--------------------");
        Cafe cafe = new Cafe();

        //Create some default menu items for test
        MenuItem item1 = new MenuItem("Latte", 3.50, "Drink");
        MenuItem item2 = new MenuItem("Croissant", 2.50, "Food");
        MenuItem item3 = new MenuItem("Soda", 1.50, "Drink");

        //Add them to the cafe instance menu
        cafe.addMenuItem1(item1);
        cafe.addMenuItem2(item2);
        cafe.addMenuItem3(item3);

        cafe.displayMenu();

        System.out.println();

        Order order = new Order();
        order.addItem1(item1, 2); //2 Lattes
        order.addItem2(item2, 3); //3 croissants
        order.addItem3(item3, 1); //1 soda

        order.addItem1(item1, 1); //add another latte for 3 total

        cafe.placeOrder(order);

        order.displayOrderDetails();

        System.out.println();
        System.out.println(" Expected Total: 3 lattes, 3 croissants, 1 soda for $19.50");
    }
}
