package Cafe_Manager;

public class Cafe {
    private MenuItem menuItem1;
    private MenuItem menuItem2;
    private MenuItem menuItem3;
    private Order currentOrder;

    public void addMenuItem1(MenuItem item) {
        this.menuItem1 = item;
    }

    public void addMenuItem2(MenuItem item) {
        this.menuItem2 = item;

    }

    public void addMenuItem3(MenuItem item) {
        this.menuItem3 = item;
    }

    public void placeOrder(Order order) {
        this.currentOrder = order;
        this.currentOrder.calculateTotal();
    }

    public void displayMenu(){
        System.out.println("Cafe Menu:");
        this.menuItem1.displayItemInfo();
        this.menuItem2.displayItemInfo();
        this.menuItem3.displayItemInfo();
    }

    //getter methods to access menu items, needed for checking quantities
    public MenuItem getMenuItem1() {
        return menuItem1;
    }

    public MenuItem getMenuItem2() {
        return menuItem2;
    }

    public MenuItem getMenuItem3() {
        return menuItem3;
    }

}
