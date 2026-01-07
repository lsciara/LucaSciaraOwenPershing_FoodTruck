package truck;

import java.util.ArrayList;
import java.util.HashMap;

import model.MenuItem;
import model.Ingredient;

public class Truck {
    public String name;                     
    public double cash;                    
    public ArrayList<MenuItem> menu;             
    public HashMap<Ingredient, Integer> inventory;  //temp dictionary
    
    public boolean isOpen;                   
    // public int reputation;                   
    // public String location;                  

    
    public static void main(String[] args) {}

    public Truck(String name, double startingCash) {
        this.name = name;
        this.cash = startingCash;
        this.menu = new ArrayList<>();
        this.inventory = new HashMap<Ingredient, Integer>(); //Temp dictionary
        this.isOpen = false;
    }

    public static void cookAndPrepare(double timeToCook) {
        System.out.println("Cooking");
        System.out.println("This will take " + timeToCook);

    }

    public void addIngredient(Ingredient ingredient, Integer amount) {
        this.inventory.put(ingredient, amount);
    }
}