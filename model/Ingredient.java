public class Ingredient {
    private String name;
    private boolean isVegan;
    private long calories;

    public static void main(String[] args) {}

    public Ingredient(String name, boolean isVegan) {
        this.name = name;
        this.isVegan = isVegan;
    }
    public Ingredient(String name, boolean isVegan , long calories) {
        this.name = name;
        this.isVegan = isVegan;
        this.calories = calories;
    }


}
