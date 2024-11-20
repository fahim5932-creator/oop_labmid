

public class Main {
    public static void main(String[] args) {
        try {
            IceCreamShop shop = new IceCreamShop();
            Order order = new Order(shop);

            // Add flavors
            order.addFlavor("Chocolate Fudge", 1);
            order.addFlavor("Mint Chocolate Chip", 1);
            order.addFlavor(" Pistachio Delight", 1);


            // Add toppings
            order.addTopping("Chocolate Chips", 1);
            order.addTopping("Fresh Strawberries", 2);

            // Set container
            order.setWaffleCone(true);

            // Print the total
            System.out.println("Total Amount Due: $" + String.format("%.2f", order.calculateTotal()));

            // Generate an invoice
            order.generateInvoice("invoice.txt");
            System.out.println("Invoice generated as 'invoice.txt'.");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
