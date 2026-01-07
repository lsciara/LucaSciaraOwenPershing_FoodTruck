package model;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    private String name;
    private double price;
    
    public List<Ingredient> ingredients;

    public static void main(String[] args) {}

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.ingredients = new ArrayList<>(); 
    }

}
