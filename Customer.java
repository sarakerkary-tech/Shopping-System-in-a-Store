package store;

import java.util.ArrayList;

public class Customer {

    private String name;

    // Composition: Customer contains a list of Cart objects.
    private ArrayList<Cart> carts;

    // Composition: Customer contains a list of Bill objects.
    private ArrayList<Bill> bills;

    // Constructor
    public Customer(String name) {
        this.name = name;
        this.carts = new ArrayList<>();
        this.bills = new ArrayList<>();
    }

    // Add a cart
    public void addCart(Cart cart) {
        carts.add(cart);
    }

    // Add a bill
    public void addBill(Bill bill) {
        bills.add(bill);
    }

    // Create a bill from a cart
    public Bill createBill(String billId, Cart cart) {

        if (!carts.contains(cart)) {
            carts.add(cart);
        }

        Bill bill = new Bill(billId, cart);
        bills.add(bill);

        return bill;
    }

    // Getters
    public String getName() {
        return name;
    }

    public ArrayList<Cart> getCarts() {
        return carts;
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCarts(ArrayList<Cart> carts) {
        this.carts = carts;
    }

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }
}
