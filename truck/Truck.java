package truck;

import java.util.List;
import java.util.ArrayList;
import model.MenuItem;
import model.Ingredient;

public class Truck {
    private String name;                     
    private double cash;                    
    private List<MenuItem> menu;             
    private List<Ingredient> inventory;      
    
    private boolean isOpen;                   // Operating status
    private int reputation;                   // Customer satisfaction score
    // private String location;                  

    
    public static void main(String[] args) {}

    public Truck(String name, double startingCash) {
        this.name = name;
        this.cash = startingCash;
        this.menu = new ArrayList<>();
        this.inventory = new ArrayList<>();
        this.isOpen = false;
    }
}