// package simulation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;

// import model.Player;
// import model.Truck;

public class GameLoop {
    
    private String currentPlayer; //The file name 
    // private Truck truck;
    // private ArrayList<Player> customersInLine;
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
        createSaveFile(); //Makes a new CSV to save the start info of this session
    }



    //     while (running) {
    //     }
    // }


    public void tick() {

    }


    // src/data/saves/game_save.csv
    public void createSaveFile() {
        Scanner scan = new Scanner(System.in);
        File savesFolder = new File("../../src/data/saves/");

        System.out.println("Welcome to the Food Truck sim");
        System.out.println("Enter your username (caps matter). If your username is already taken you can choose to override");

        String username = scan.nextLine().strip();

        //Make sure the username is NOT _base
        while (username.equalsIgnoreCase("_base")) {
            System.out.println("Error: '_base' is a reserved system name. GET A NEW NAME.");
            username = scan.nextLine().strip();
        }

        //add file type
        username = username + ".csv";

        //List of all the files
        File[] allFiles = savesFolder.listFiles();

        if (savesFolder.exists()) { //check it exsists
            for (File f : allFiles) {        
                while (username.equals(f.getName())) { //If the chosen username already has a folder
                    System.out.println("This username already exsists! Would you like to override that save? (Y/N)");

                    String overrideChoice = scan.nextLine().trim();

                    //Just set currentPlayer to the one you chose
                    if (overrideChoice.equalsIgnoreCase("y")) {
                        System.out.println("Override");
                        this.currentPlayer = username;
                        break;
                    }
                    else { //Pick a new username, make a new folder and copy everything from _base
                        System.out.println("Enter your username (caps do not matter). If your username is already taken you can choose to override");

                        username = scan.nextLine().strip();

                        username = username + ".csv";

                        String finalPath = "../../src/data/saves/" + username;

                        Path source = Paths.get("../../src/data/saves/_base.csv");
                        Path destination = Paths.get(finalPath);

                        try {
                            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                        }
                        catch (IOException e) {
                            System.out.println(e);
                        }
                        this.currentPlayer = username;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        GameLoop instance = new GameLoop();
        instance.createSaveFile();
    }
}
