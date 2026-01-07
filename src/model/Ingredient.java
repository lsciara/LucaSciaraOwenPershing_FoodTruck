package model;


public class Ingredient {
    public String name;
    public boolean isVegan;
    public long calories = 0;
    public int cookTime = 0;  // minutes
    public int cookTemp = 0;    // Fahrenheit
    public String cookType;

    public Ingredient(String name, boolean isVegan) {
        this.name = name;
        this.isVegan = isVegan;
    }
    
    public Ingredient(String name, boolean isVegan, long calories) {
        this.name = name;
        this.isVegan = isVegan;
        this.calories = calories;
    }

    public Ingredient(String name, boolean isVegan, long calories, int cookTime, int cookTemp, String cookType) {
        this.name = name;
        this.isVegan = isVegan;
        this.calories = calories;
        this.cookTime = cookTime;
        this.cookTemp = cookTemp;
        this.cookType = cookType;
    }
}
