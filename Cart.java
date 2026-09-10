package store;

import java.util.ArrayList;

public class Cart {

    private String cartId;

    // Composition: Cart contains a list of Item objects.
    private ArrayList<Item> items;

    // Stores the quantity of each corresponding item.
    private ArrayList<Integer> quantities;

    // Constructor
    public Cart(String cartId) {
        this.cartId = cartId;
        this.items = new ArrayList<>();
        this.quantities = new ArrayList<>();
    }

    // Add an item with a quantity
    public void addItem(Item item, int quantity) {

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;
        }

        int index = items.indexOf(item);

        if (index >= 0) {
            quantities.set(
                index,
                quantities.get(index) + quantity
            );
        } else {
            items.add(item);
            quantities.add(quantity);
        }
    }

    // Remove an item from the cart
    public void removeItem(Item item) {

        int index = items.indexOf(item);

        if (index >= 0) {
            items.remove(index);
            quantities.remove(index);
        }
    }

    // Calculate total cart amount
    public double calculateTotal() {

        double total = 0;

        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getPrice() * quantities.get(i);
        }

        return total;
    }

    // Getters
    public String getCartId() {
        return cartId;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Integer> getQuantities() {
        return quantities;
    }

    // Setters
    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void setQuantities(ArrayList<Integer> quantities) {
        this.quantities = quantities;
    }

    // Check whether the cart is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Clear all items from the cart
    public void clearCart() {
        items.clear();
        quantities.clear();
    }
}
