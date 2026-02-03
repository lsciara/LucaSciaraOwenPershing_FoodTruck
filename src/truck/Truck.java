package truck;

import java.util.ArrayList;
import java.util.HashMap;
import model.MenuItem;
import model.Ingredient;

public class Truck {
    private String name;                     
    private double cash;                    
    private ArrayList<MenuItem> menu;             
    private HashMap<Ingredient, Integer> inventory;  //temp dictionary
    
    private boolean isOpen;                   
    // public int reputation;                   
    // public String location;                  

    
    public static void main(String[] args) {}

    public Truck(String name, double startingCash) {
        this.name = name;
        this.cash = startingCash;
        this.menu = new ArrayList<>();
        this.inventory = new HashMap<Ingredient, Integer>(); //Temp dictionary
        this.isOpen = false;
    }

    public void addIngredient(Ingredient ingredient, Integer amount) {
        this.inventory.put(ingredient, amount);
    }

    public void cookAndPrepare(ArrayList<Ingredient> initialIngredients) {
        Integer fryCookTime = 0;
        Integer toastCookTime = 0;
        Integer bakeCookTime = 0;
        Integer boilCookTime = 0;

        for (Ingredient i : initialIngredients) {
            if (i.getCookType().equals("FRY")) { //if this is fried
                if (i.getCookTime() > fryCookTime) { //
                    fryCookTime = i.getCookTime();
                }
            }
            if (i.getCookType().equals("TOAST")) {
                if (i.getCookTime() > toastCookTime) { 
                    toastCookTime = i.getCookTime();
                }
            }
            if (i.getCookType().equals("BAKE")) {
                if (i.getCookTime() > bakeCookTime) { 
                    bakeCookTime = i.getCookTime();
                }
            }
            if (i.getCookType().equals("BOIL")) {
                if (i.getCookTime() > boilCookTime) { 
                    boilCookTime = i.getCookTime();
                }
            }
        }
        System.out.println("Fry cook time: " + fryCookTime + " minutes");
        System.out.println("Toast cook time: " + toastCookTime + " minutes");
        System.out.println("Bake cook time: " + bakeCookTime + " minutes");
        System.out.println("Boil cook time: " + boilCookTime + " minutes");
    }
}