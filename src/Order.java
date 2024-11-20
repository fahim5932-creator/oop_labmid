import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


class Order {
    private final IceCreamShop shop;
    private final Map<String, Integer> selectedFlavors;
    private final Map<String, Integer> selectedToppings;
    private boolean isWaffleCone;

    public Order(IceCreamShop shop) {
        this.shop = shop;
        this.selectedFlavors = new HashMap<>();
        this.selectedToppings = new HashMap<>();
        this.isWaffleCone = false;
    }

    public void addFlavor(String flavor, int scoops) {
        if (!shop.getFlavors().containsKey(flavor)) {
            throw new IllegalArgumentException("Flavor not found: " + flavor);
        }
        selectedFlavors.put(flavor, selectedFlavors.getOrDefault(flavor, 0) + scoops);
    }

    public void addTopping(String topping, int quantity) {
        if (!shop.getToppings().containsKey(topping)) {
            throw new IllegalArgumentException("Topping not found: " + topping);
        }
        selectedToppings.put(topping, selectedToppings.getOrDefault(topping, 0) + quantity);
    }


    public void setWaffleCone(boolean isWaffleCone) {
        this.isWaffleCone = isWaffleCone;
    }

    public double calculateSubtotal() {
        double subtotal = 0.0;

        for (Map.Entry<String, Integer> entry : selectedFlavors.entrySet()) {
            subtotal += shop.getFlavors().get(entry.getKey()) * entry.getValue();
        }

        for (Map.Entry<String, Integer> entry : selectedToppings.entrySet()) {
            subtotal += shop.getToppings().get(entry.getKey()) * entry.getValue();
        }

        if (isWaffleCone) {
            subtotal += IceCreamShop.getWaffleConePrice();
        }

        return subtotal;
    }

    public double calculateTax() {
        return calculateSubtotal() * IceCreamShop.getTaxRate();
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }

    public void generateInvoice(String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Ice Cream Shop Invoice\n");
            for (Map.Entry<String, Integer> entry : selectedFlavors.entrySet()) {
                writer.write(entry.getKey() + " - " + entry.getValue() + " scoop(s): $" +
                        String.format("%.2f", shop.getFlavors().get(entry.getKey()) * entry.getValue()) + "\n");
            }
            for (Map.Entry<String, Integer> entry : selectedToppings.entrySet()) {
                writer.write(entry.getKey() + " - " + entry.getValue() + " time(s): $" +
                        String.format("%.2f", shop.getToppings().get(entry.getKey()) * entry.getValue()) + "\n");
            }
            if (isWaffleCone) {
                writer.write("Waffle Cone: $" + String.format("%.2f", IceCreamShop.getWaffleConePrice()) + "\n");
            }
            writer.write("Subtotal: $" + String.format("%.2f", calculateSubtotal()) + "\n");
            writer.write("Tax: $" + String.format("%.2f", calculateTax()) + "\n");
            writer.write("Total Amount Due: $" + String.format("%.2f", calculateTotal()) + "\n");
        }
    }
}
