package simulation;

import model.Truck;
import model.MenuItem;
import model.Player;


import model.Ingredient;

public class Demo {
    public static void main(String[] args) {
        //TYPE can be FRY, TOAST, BAKE, BOIL
        Ingredient Bacon = new Ingredient("Bacon", true, 150, 10, 350, "FRY");
        Ingredient Eggs  = new Ingredient("Eggs",  true,  80,  5, 200, "FRY");
        Ingredient Toast = new Ingredient("Toast", false, 70,  3, 180, "TOAST");

        Truck owensTruck = new Truck("Owens food truck", 500.0, 10, 20, 8, 6);
        Truck billsTruck = new Truck("Bills truck", 195, 0, 3, 1, 3);
        
        Player bill = new Player("Bill", 2, 27, true, 18);
        Player luca = new Player("Luca", 1, 23, true, 8);

        
    }
}
