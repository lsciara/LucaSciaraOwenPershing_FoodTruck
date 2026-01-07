package simulation;

import truck.Truck;
import model.MenuItem;
import model.Ingredient;

public class Demo {
    public static void main(String[] args) {
        // Create a food truck
        Truck myTruck = new Truck("Tasty Wheels", 1000.0);
        
        // Create some ingredients
        Ingredient bread = new Ingredient("Bread", true, 150);
        Ingredient cheese = new Ingredient("Cheese", false, 100);
        Ingredient lettuce = new Ingredient("Lettuce", true, 5);
        Ingredient tomato = new Ingredient("Tomato", true, 10);
        Ingredient beef = new Ingredient("Beef Patty", false, 250);
        Ingredient chicken = new Ingredient("Chicken", false, 200);
        Ingredient bacon = new Ingredient("Bacon", false, 150);
        
        // Create menu items
        MenuItem burger = new MenuItem("Classic Burger", 8.99);
        burger.ingredients.add(bread);
        burger.ingredients.add(beef);
        burger.ingredients.add(cheese);
        burger.ingredients.add(lettuce);
        burger.ingredients.add(tomato);
        
        System.out.println(burger.ingredients.size());
    }
}