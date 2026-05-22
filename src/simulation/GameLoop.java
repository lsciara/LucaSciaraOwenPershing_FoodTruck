// package simulation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.*;
import java.util.*;



// import model.Player;
// import model.Truck;

public class GameLoop {
    
    private String currentPlayer; //The file name WITHOUT .csv
    private final String savesFilePath = "../../src/data/saves/";
    private final String dataFilePath = "../../src/data/";
    private String filePath;
    private final String savesBase = "../../src/data/saves/_base.csv";
    

    // private Truck truck;
    // private ArrayList<Player> customersInLine;
    private double startingCash;
    private double currentTime;   // in minutes
    private double tickRate;      // how many minutes pass per tick
    private boolean running;
    // private ArrayList<ArrayList<MenuItem>> totalMenuItems;

    private int amountOfIngredients;
    
    // public GameLoop() {
    //     //this.truck = truck;
    //     //this.customersInLine = new ArrayList<>();
    //     this.currentTime = 0;
    //     this.tickRate = 10;
    //     this.running = false;
    // }


     public void start() {
        this.running = true;

        try {
            validateName(); //Makes a new CSV to save the start info of this session
        }
        catch (IOException e) {

        }
    }





    public void tick() {

    }





    /**This method will take user input, make sure name is valid then call createFileFromName()  */
    public void validateName() throws IOException{
        Scanner scan = new Scanner(System.in);
        File savesFolder = new File(savesFilePath);
        
        System.out.println("Welcome to the Food Truck sim");
        System.out.println("Enter your username (caps matter). If your username is already taken you can choose to override");

        String username = scan.nextLine().strip();

        //Make sure the username is NOT _base
        while (username.equalsIgnoreCase("_base")) {
            System.out.println("Error: '_base' is a reserved system name. GET A NEW NAME.");
            username = scan.nextLine().strip();
        }

        File userFile = new File(savesFolder, username + ".csv");

        if (userFile.exists()) {
            System.out.println("Would you like to overwrite " + username + "? (Y/N)");
            String r = scan.nextLine().trim();
            while (!r.equalsIgnoreCase("y") && !r.equalsIgnoreCase("n")) {
                System.out.println("Please enter Y or N:");
                r = scan.nextLine().trim();
            }

            if (r.equalsIgnoreCase("y")) {
                this.currentPlayer = username;
                this.filePath = savesFilePath + username + ".csv";
            }

            if (r.equalsIgnoreCase("n")) {
                System.out.println();
                validateName();
            }
        }
        else { //File does not exsist yet
            this.currentPlayer = username;
            this.filePath = savesFilePath + username + ".csv";
            createFileFromName();
        }
    }

    //create new user file from just the name
    public void createFileFromName() throws IOException {


        String fullFilePath = savesFilePath + currentPlayer + ".csv";
        Path src = Paths.get(savesBase);

        Path filePath = Paths.get(fullFilePath);

        Files.createFile(filePath);

        Files.copy(src, filePath, StandardCopyOption.REPLACE_EXISTING);


        ArrayList<ArrayList<String>> rows = csvToList(savesFilePath + currentPlayer);

        System.out.println(savesFilePath + currentPlayer);

        ArrayList<String> nameInfo = new ArrayList<>();
        nameInfo.add(currentPlayer);
        nameInfo.add(String.valueOf(startingCash));

        if (rows.size() > 1) {
            rows.set(1, nameInfo);
        } else {
            rows.add(nameInfo);  
        }

        listToCSV(rows);
        createAndPopulateTruck();
    }

    //gives 5 random menu items from each cat
    public void populateTotalMenuItems() throws IOException {
        ArrayList<ArrayList<String>> menuItems = csvToList(dataFilePath + "MenuOptions");

        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).get(0).substring(0, 1).equals("B")) {
                
                System.out.println(menuItems.get(i) + " is breakfast item");
            }
        }
    }

    public void createAndPopulateTruck() throws IOException {
        Scanner scan = new Scanner(System.in);
        boolean valid = false;

        // System.out.println("Enter a name for your food truck: ");
        // String truckName = scan.nextLine().trim();

        // appendToCSV(1, truckName);

        while (!valid) {
            System.out.println("Build your menu! Here you can pick menu items! Enter R if you want some random menu items or P if you want to pick them!");
            String ingredientChoice = scan.nextLine().trim();

            if (ingredientChoice.equalsIgnoreCase("r") || ingredientChoice.equalsIgnoreCase("p")) {
                valid = true;
                if (ingredientChoice.equalsIgnoreCase("r")) {
                    


                }
                else {

                }
            }
        } 
    }


//HELPFUL METHODS 
    public ArrayList<ArrayList<String>> csvToList(String name) throws IOException {
        Path filePath = Paths.get(name + ".csv");
        List<String> lines = Files.readAllLines(filePath);

        ArrayList<ArrayList<String>> rows = new ArrayList<>();
        for (String line : lines) {
            ArrayList<String> row = new ArrayList<>(Arrays.asList(line.split(",")));
            rows.add(row);
        }

        return rows;
    }

    public void listToCSV(ArrayList<ArrayList<String>> rows) throws IOException {
        Path filePath = Paths.get(savesFilePath + currentPlayer + ".csv");

        List<String> newLines = new ArrayList<>();
        newLines.add(String.join(",", rows.get(0)));  // Keep header
        for (int i = 1; i < rows.size(); i++) {
            newLines.add(String.join(",", rows.get(i)));
        }

        Files.write(filePath, newLines);
    }

    public void appendToCSV(int row, String toAdd) throws IOException {
        ArrayList<ArrayList<String>> userInfo = csvToList(currentPlayer);

        userInfo.get(row).add(toAdd);

        listToCSV(userInfo);
    }

    public int getCSVLength(String name) throws IOException {

        ArrayList<ArrayList<String>> userInfo = csvToList(name);

        return userInfo.size() - 1; //-1 for the header
    }

    public static void main(String[] args) throws IOException {
        GameLoop instance = new GameLoop();
        // instance.validateName();
        instance.populateTotalMenuItems();
    }
}


