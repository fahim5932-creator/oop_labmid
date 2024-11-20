


    public class test {

        public static void testCase1() {
            IceCreamShop shop = new IceCreamShop();
            Order order = new Order(shop);

            order.addFlavor("Chocolate Fudge", 1);
            order.addFlavor("Mint Chocolate Chip", 1);
            order.addFlavor(" Pistachio Delight", 1);

            order.addTopping("Chocolate Chips", 1);
            order.addTopping("Fresh Strawberries", 2);

            order.setWaffleCone(true);

            double subtotal = order.calculateSubtotal();
            double tax = order.calculateTax();
            double total = order.calculateTotal();

            assert subtotal == 16.10 : "Subtotal mismatch";
            assert tax == 1.29 : "Tax mismatch";
            assert total == 17.39 : "Total mismatch";

            System.out.println("Test Case 1 Passed.");
        }

        public static void testCase2() {
            IceCreamShop shop = new IceCreamShop();
            Order order = new Order(shop);

            try {
                order.addFlavor("Vanilla Bean", 1);
                System.out.println("Test Case 2 Failed: No exception thrown for invalid flavor.");
            } catch (IllegalArgumentException e) {
                assert e.getMessage().equals("Flavor not found: Vanilla Bean") : "Incorrect error message in Test Case 2";
                System.out.println("Test Case 2 Passed.");
            }
        }

        public static void testCase3() {
            IceCreamShop shop = new IceCreamShop();
            Order order = new Order(shop);

            try {
                order.addTopping("Chopped Almonds", 1);
                System.out.println("Test Case 3 Failed: No exception thrown for invalid topping.");
            } catch (IllegalArgumentException e) {
                assert e.getMessage().equals("Topping not found: Chopped Almonds") : "Incorrect error message in Test Case 3";
                System.out.println("Test Case 3 Passed.");
            }
        }

        public static void testCase4() {
            IceCreamShop shop = new IceCreamShop();
            Order order = new Order(shop);

            order.setWaffleCone(true);

            double subtotal = order.calculateSubtotal();
            double tax = order.calculateTax();
            double total = order.calculateTotal();

            assert subtotal == 5.00 : "Subtotal mismatch in Test Case 4";
            assert tax == 0.40 : "Tax mismatch in Test Case 4";
            assert total == 5.40 : "Total mismatch in Test Case 4";

            System.out.println("Test Case 4 Passed.");
        }


        public static void testCase5() {
            IceCreamShop shop = new IceCreamShop();
            Order order = new Order(shop);

            double subtotal = order.calculateSubtotal();
            double tax = order.calculateTax();
            double total = order.calculateTotal();

            assert subtotal == 0.00 : "Subtotal mismatch in Test Case 5";
            assert tax == 0.00 : "Tax mismatch in Test Case 5";
            assert total == 0.00 : "Total mismatch in Test Case 5";

            System.out.println("Test Case 5 Passed.");

        }
        public static void main(String[] args) {
            testCase1();
            testCase2();
            testCase3();
            testCase4();
            testCase5();
        }
    }

