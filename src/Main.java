

public class Main {
    public static void main(String[] args) {
        try {
            IceCreamShop shop = new IceCreamShop();
            Order order = new Order(shop);

            order.addFlavor("Chocolate Fudge", 1);
            order.addFlavor("Mint Chocolate Chip", 1);
            order.addFlavor(" Pistachio Delight", 1);


            order.addTopping("Chocolate Chips", 1);
            order.addTopping("Fresh Strawberries", 2);

            order.setWaffleCone(true);

            System.out.println("Total Amount Due: $" + String.format("%.2f", order.calculateTotal()));

            order.generateInvoice("invoice.txt");
            System.out.println("Invoice generated as 'invoice.txt'.");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
