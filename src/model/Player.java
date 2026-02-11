package model;

public class Player { 
    private String name;
    private int hungrinessIndex; // 0 to 5
    private double cashOnHand; //Money on hand
    private boolean cashOnly; //Only cash paying?
    private double maxWillingnessToPay; //Most will pay

    public static void main(String[] args) {}

    public Player(String name, int hungrinessIndex, double cashOnHand, boolean cashOnly, double maxWillingnessToPay) {
        this.name = name;
        this.hungrinessIndex = hungrinessIndex;
        this.cashOnHand = cashOnHand;
        this.cashOnly = cashOnly;
        this.maxWillingnessToPay = maxWillingnessToPay;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getHungrinessIndex() {
        return hungrinessIndex;
    }

    public double getCashOnHand() {
        return cashOnHand;
    }

    public boolean isCashOnly() {
        return cashOnly;
    }

    public double getMaxWillingnessToPay() {
        return maxWillingnessToPay;
    }
}
