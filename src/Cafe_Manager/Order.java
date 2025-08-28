package Cafe_Manager;

public class Order {
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int quantity1;
    private int quantity2;
    private int quantity3;

    private double totalAmount;

    public void addItem1(MenuItem item, int quantity) {
        this.item1 = item;
        this.quantity1 += quantity;
        //Note: I am using += here because the intended outcome if a user
        // attempts to add the same item twice is that it just adds more of that item
        // So you could order 2 Croissants for Item 1, then on Item 2, Order 3 croissants, and get 5 croissants
    }

    public void addItem2(MenuItem item, int quantity) {
        this.item2 = item;
        this.quantity2 += quantity;
    }

    public void addItem3(MenuItem item, int quantity) {
        this.item3 = item;
        this.quantity3 += quantity;
    }

    public double calculateTotal() {
        double totalAmount = 0;
        if (item1 != null) {
            totalAmount += item1.getPrice() * quantity1;
        }
        if (item2 != null) {
            totalAmount += item2.getPrice() * quantity2;
        }
        if (item3 != null) {
            totalAmount += item3.getPrice() * quantity3;
        }

        this.totalAmount = totalAmount;

        return totalAmount;

    }

    public void displayOrderDetails() {
        System.out.println("Order Details: ");
        if (item1 != null && quantity1 > 0) {
            System.out.print(quantity1 + "x ");
            item1.displayItemInfo();
                }
        if (item2 != null && quantity2 > 0) {
            System.out.print(quantity2 + "x ");
            item2.displayItemInfo();
        }
        if (item3 != null && quantity3 > 0) {
            System.out.print(quantity3 + "x ");
            item3.displayItemInfo();
        }

        System.out.println("Order Total: " + totalAmount);
        System.out.println("Enjoy!");
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
