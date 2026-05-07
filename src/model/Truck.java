package model;

import java.util.ArrayList;
import java.util.HashMap;
import model.MenuItem;
import model.Ingredient;

public class Truck {
    private String name;                     
    private double startingCash;                    
    private ArrayList<MenuItem> menu;             
    private HashMap<Ingredient, Integer> inventory;  //temp dictionary
    
    private boolean isOpen;                   
    // public int reputation;                   
    // public String location;          
    
    //Loc
    private int centerX;
    private int centerY;
    private int length;
    private int width;
    

    
    public static void main(String[] args) {}

    public Truck(String name, double startingCash, int centerX, int centerY, int length, int width) {
        this.name = name;
        this.startingCash = startingCash;
        this.menu = new ArrayList<>();
        this.inventory = new HashMap<Ingredient, Integer>(); //Temp dictionary
        this.isOpen = false;

        this.centerX = centerX;
        this.centerY = centerY;
        this.length = length;
        this.width = width;
    }

    public void addIngredient(Ingredient ingredient, Integer amount) {
        this.inventory.put(ingredient, amount);
    }

    public String getName() {
        return name;
    }
    
    public double getStartingCash() {
        return startingCash;
    }
    
    public int getXLoc() {
        return centerX;
    }
    
    public int getYLoc() {
        return centerY;
    }
    
    public int getLength() {
        return length;
    }
    
    public int getWidth() {
        return width;
    }
}

