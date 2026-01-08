package simulation;

import truck.Truck;
import model.MenuItem;


import model.Ingredient;

public class Demo {
    public static void main(String[] args) {
        Truck owensTruck = new Truck("Owens food truck", 500);
        
        Ingredient Bacon = new Ingredient("Bacon", true, 150);
        Ingredient Eggs = new Ingredient("Eggs", true, 5);
        Ingredient Sausage = new Ingredient("Sausage", true, 200);
        Ingredient HashBrowns = new Ingredient("Hash Browns", false, 75);
        Ingredient Toast = new Ingredient("Toast", false, 20);
        Ingredient Pancakes = new Ingredient("Pancakes", false, 100);
        Ingredient OrangeJuice = new Ingredient("Orange Juice", false, 50);

        owensTruck.addIngredient(Eggs, 13);
        owensTruck.addIngredient(Bacon, 12);
        owensTruck.addIngredient(Sausage, 10);
        owensTruck.addIngredient(HashBrowns, 8);
        owensTruck.addIngredient(Toast, 20);
        owensTruck.addIngredient(Pancakes, 15);
        owensTruck.addIngredient(OrangeJuice, 12);

        MenuItem EggsBaconAndToast = new MenuItem("Full Breakfast", 12.00, Eggs, Bacon, Toast);


        owensTruck.cookAndPrepare(EggsBaconAndToast.ingredients);




                
    }
}