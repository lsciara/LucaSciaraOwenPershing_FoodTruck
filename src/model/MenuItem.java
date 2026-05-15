public class MenuItem {
    private String itemID;
    private String name;
    private int price;
    private String category;
    private String description;
    private boolean isAvailable;


    public MenuItem(String itemID, String name, int price, String category, String description, boolean isAvailable) {
        this.itemID = itemID;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.isAvailable = isAvailable;
    }


    public String getItemID() {
        return itemID;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
    public String getDescription() {
        return description;
    }


    public boolean isAvailable() {
        return isAvailable;
    }
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }


    public static void main(String[] args) {}
}

