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
    
    // private String currentPlayer //The file name 
    // private Truck truck;
    // private ArrayList<Player> customersInLine;
    // private double currentTime;   // in minutes
    // private double tickRate;      // how many minutes pass per tick
    // private boolean running;

    // public GameLoop(Truck truck, double tickRate) {
    //     this.truck = truck;
    //     this.customersInLine = new ArrayList<>();
    //     this.currentTime = 0;
    //     this.tickRate = tickRate;
    //     this.running = false;
    // }


    // public void start() {
    //     this.running = true;



    //     while (running) {
    //     }
    // }


    public void tick() {

    }


    // src/data/saves/game_save.csv
    public String createSave() {
        Scanner scan = new Scanner(System.in);
        File savesFolder = new File("../../src/data/saves/");

        System.out.println("Welcome to the Food Truck sim");
        System.out.println("Enter your username (caps do not matter). If your username is already taken you can choose to override");

        String username = scan.nextLine().strip();

        while (username.equalsIgnoreCase("_base")) {
            System.out.println("Error: '_base' is a reserved system name. GET A NEW NAME.");
            username = scan.nextLine().strip();
        }

        username = username + ".csv";

        File[] allFiles = savesFolder.listFiles();

        if (savesFolder.exists()) {
            for (File f : allFiles) {        
                while (username.equals(f.getName())) {
                    System.out.println("This username already exsists! Would you like to override that save? (Y/N)");

                    String overrideChoice = scan.nextLine().trim();

                    if (overrideChoice.equalsIgnoreCase("y")) {
                        System.out.println("Override");
                        // this.currentPlayer = username;
                        break;
                    }
                    else {
                        System.out.println("Enter your username (caps do not matter). If your username is already taken you can choose to override");

                        username = scan.nextLine().strip();

                        username = username + ".csv";
                    }
                }
            }
            String finalPath = "../../src/data/saves/" + username;

            System.out.println(finalPath);

            Path source = Paths.get("../../src/data/saves/_base.csv");
        Path destination = Paths.get(finalPath);
        }

        return "temp";
    }


    //         String finalPath = "../../src/data/saves/" + username; 

    //         try {

    //             Path source = Paths.get("../../src/data/saves/_base.csv");
    //             Path destination = Paths.get(finalPath);


    //             Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                
    //             System.out.println("Success! Save created at: " + finalPath);
    //         } catch (IOException e) {
    //             System.out.println("Error: Could not copy base file. Check if _base.csv exists.");
    //             e.printStackTrace();
    //         }


    //     return "t";
    // }

    public static void main(String[] args) {
        GameLoop instance = new GameLoop();
        instance.createSave();
    }
}
