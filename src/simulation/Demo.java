package simulation;

import truck.Truck;
import model.MenuItem;

import model.Ingredient;

public class Demo {
    public static void main(String[] args) {
        Truck owensTruck = new Truck("Owens food truck", 500);
        //TYPE can be FRY, TOAST, BAKE, BOIL
        Ingredient Bacon = new Ingredient("Bacon", true, 150, 10, 350, "FRY");
        Ingredient Eggs  = new Ingredient("Eggs",  true,  80,  5, 200, "FRY");
        Ingredient Toast = new Ingredient("Toast", false, 70,  3, 180, "TOAST");

        owensTruck.addIngredient(Eggs, 13);
        owensTruck.addIngredient(Bacon, 12);
        owensTruck.addIngredient(Toast, 20);

        MenuItem fullBreakfast = new MenuItem("Full Breakfast", 12.00, Eggs, Eggs, Bacon, Toast);

        owensTruck.cookAndPrepare(fullBreakfast.getIngredients());


                
    }
}