package model;


public class Ingredient {
    private String name;
    private boolean isVegan;
    private long calories = 0;
    private int cookTime = 0;  // minutes
    private int cookTemp = 0;    // Fahrenheit
    private String cookType; //Can be BOIL, FRY, BAKE, TOAST


    public static void main(String[] args) {}

    public String getName() {
        return name;
    }
    public boolean getIsVegan() {
        return isVegan;
    }
    public long getCalories() {
        return calories;
    }
    public int getCookTime() {
        return cookTime;
    }
    public int getCookTemp() {
        return cookTemp;
    }
    public String getCookType() {
        return cookType;
    }


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
