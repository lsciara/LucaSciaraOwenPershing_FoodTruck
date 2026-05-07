package model;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuItem {
    private String name;
    private double price;
    // private double timeToCook; //In mins and seconds

    private ArrayList<Ingredient> ingredients;  

    public static void main(String[] args) {}


    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }


    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.ingredients = new ArrayList<>();
    }

    public MenuItem(String name, double price, Ingredient... initialIngredients) { //The three dots is the "java varargs" 
        this.name = name;
        this.price = price;
        this.ingredients = new ArrayList<>(Arrays.asList(initialIngredients)); //Make em a list 
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    // public String toString() {
    //     return name; 
    // }
}

