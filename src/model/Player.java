package model;

public class Player { 
    public double hungrinessIndex; // 0.0 to 1.0
    public double cashOnHand; //Money on hand
    public boolean cashOnly; //Only cash paying?
    public boolean knowsAllOptions; //Have they checked all the different food trucks (Not relevant yet)
    
    public double maxWillingnessToPay; //Most will pay
    public double timePreference;      // True = prefers speed and False = prefers cheap

    public static void main(String[] args) {}

    public Player(double hungrinessIndex, double cashOnHand, boolean cashOnly, double maxWillingnessToPay, double timePreference) {
        this.hungrinessIndex = hungrinessIndex;
        this.cashOnHand = cashOnHand;
        this.cashOnly = cashOnly;
        this.knowsAllOptions = false; // defaults to false as they start by knowing nothing
        this.maxWillingnessToPay = maxWillingnessToPay;
        this.timePreference = timePreference;
    }
}