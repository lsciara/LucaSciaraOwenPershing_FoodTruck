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
    private String savesFilePath = "../../src/data/saves/";
    private String filePath;

    // private Truck truck;
    // private ArrayList<Player> customersInLine;
    private double startingCash;
    private double currentTime;   // in minutes
    private double tickRate;      // how many minutes pass per tick
    private boolean running;

     public GameLoop() {
         //this.truck = truck;
         //this.customersInLine = new ArrayList<>();
         this.currentTime = 0;
         this.tickRate = 10;
         this.running = false;
    }


     public void start() {
        this.running = true;
        try {
            validateName(); //Makes a new CSV to save the start info of this session
        }
        catch (IOException e) {

        }
    }



    //     while (running) {
    //     }
    // }


    public void tick() {

    }


    // src/data/saves/game_save.csv

    // ../../src/data/saves/

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
                boolean found = false;
                while (!found) {
                    System.out.println("Enter your username (caps matter). If your username is already taken you can choose to override");
                    String username_ = scan.nextLine().strip();

                    if (!username.equalsIgnoreCase("_base")) {
                        this.currentPlayer = username_;
                        this.filePath = savesFilePath + username + ".csv";
                        createFileFromName();
                        found = true;
                    }
                }
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
        String fullFilePath = "../../src/data/saves/" + currentPlayer + ".csv";
        Path src = Paths.get("../../src/data/saves/_base.csv");

        Path filePath = Paths.get(fullFilePath);

        Files.createFile(filePath);

        Files.copy(src, filePath, StandardCopyOption.REPLACE_EXISTING);

        //Add name and starting cash
        List<List<String>> rows = csvToList();

        List<String> nameInfo = new ArrayList<>();
        nameInfo.add(currentPlayer);
        nameInfo.add(String.valueOf(startingCash));

        rows.set(1, nameInfo);

        listToCSV(rows);

        createAndPopulateTruck();
    }

    public void createAndPopulateTruck() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a name for your food truck: ");
        String truckName = scan.nextLine().trim();

        System.out.println("Build your menu! First you have to pick ingredients? Enter R if you want some random ingredients or P if you want to pick them!");
        String ingredientChoice = scan.nextLine().trim();

        boolean valid = false;

        while (!valid) {
            System.out.println("Build your menu! First you have to pick ingredients? Enter R if you want some random ingredients or P if you want to pick them!");
            ingredientChoice = scan.nextLine().trim();
        }
        if (ingredientChoice.equalsIgnoreCase("r") || ingredientChoice.equalsIgnoreCase("p")) {
            valid = true;
            if (ingredientChoice.equalsIgnoreCase("r")) {
                //add stuff to randomly give x amount of ingredients to a player
            }
            else {
                //print out all ingredients and let em choose which ones they want
            }
        }

        //Build menuItems!

        
    }


//HELPFUL METHODS 
    public List<List<String>> csvToList() throws IOException{
        Path filePath = Paths.get(savesFilePath + currentPlayer + ".csv");
        List<String> lines = Files.readAllLines(filePath);

        List<List<String>> rows = new ArrayList<>();
        for (String line : lines) {
            rows.add(Arrays.asList(line.split(",")));
        }

        return rows;
    }

    public void listToCSV(List<List<String>> rows) throws IOException{
        Path filePath = Paths.get(savesFilePath + currentPlayer + ".csv");

        List<String> newLines = new ArrayList<>();
        newLines.add(String.join(",", rows.get(0)));  // Keep header
        for (int i = 1; i < rows.size(); i++) {
            newLines.add(String.join(",", rows.get(i)));
        }

        Files.write(filePath, newLines);
    }


        
    
    

    public static void main(String[] args) {
        GameLoop instance = new GameLoop();
        instance.start();
    }
}
