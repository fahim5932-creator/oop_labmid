import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IceCreamShop {
    private static final double TAX_RATE = 0.08;
    private static final double WAFFLE_CONE_PRICE = 5.00;

    private final Map<String, Double> flavors;
    private final Map<String, Double> toppings;

    public IceCreamShop() {
        flavors = new HashMap<>();
        toppings = new HashMap<>();

        // Initialize flavors

        flavors.put("Chocolate Fudge", 3.00);
        flavors.put("Strawberry Swirl", 2.75);
        flavors.put("Mint Chocolate Chip", 2.80);
        flavors.put(" Pistachio Delight", 3.25);

        // Initialize toppings
        toppings.put("Sprinkles", 0.30);
        toppings.put("Marshmallow", 0.70);
        toppings.put("Crushed Oreo", 0.85);
        toppings.put("Fresh Strawberries", 1.00);
        toppings.put("Chocolate Chips", 0.50);
    }

    public Map<String, Double> getFlavors() {
        return flavors;
    }

    public Map<String, Double> getToppings() {
        return toppings;
    }

    public static double getTaxRate() {
        return TAX_RATE;
    }

    public static double getWaffleConePrice() {
        return WAFFLE_CONE_PRICE;
    }
}
