package store;

public class Bill {

    private String billId;

    // Association: Bill is created from a Cart.
    private Cart cart;

    private double totalAmount;

    // Constructor
    public Bill(String billId, Cart cart) {
        this.billId = billId;
        this.cart = cart;
        this.totalAmount = calculateTotal();
    }

    // Calculate total amount from the cart
    public double calculateTotal() {
        totalAmount = cart.calculateTotal();
        return totalAmount;
    }

    // Generate and display the bill
    public void generateBill() {

        calculateTotal();

        System.out.println("\n========== BILL ==========");
        System.out.println("Bill ID: " + billId);
        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("--------------------------");

        for (int i = 0; i < cart.getItems().size(); i++) {

            Item item = cart.getItems().get(i);
            int quantity = cart.getQuantities().get(i);

            double subtotal = item.getPrice() * quantity;

            System.out.printf(
                "%-15s x%-3d $%.2f%n",
                item.getName(),
                quantity,
                subtotal
            );
        }

        System.out.println("--------------------------");
        System.out.printf(
            "Total Amount: $%.2f%n",
            totalAmount
        );
        System.out.println("==========================");
    }

    // Getters
    public String getBillId() {
        return billId;
    }

    public Cart getCart() {
        return cart;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    // Setters
    public void setBillId(String billId) {
        this.billId = billId;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
        calculateTotal();
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
