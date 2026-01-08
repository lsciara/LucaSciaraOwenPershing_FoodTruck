package model;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuItem {
    public String name;
    public double price;
    public double timeToCook; //In mins and seconds

    public ArrayList<Ingredient> ingredients;  

    public static void main(String[] args) {}

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.ingredients = new ArrayList<>();
    }

    public MenuItem(String name, double price, Ingredient... initialIngredients) { //The three dots is the "java varargs" 
        this.name = name;
        this.price = price;
        this.ingredients = new ArrayList<>(Arrays.asList(initialIngredients)); 
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    // @Override //This is from AI - It may work
    // public String toString() {
    //     return name; 
    // }
}