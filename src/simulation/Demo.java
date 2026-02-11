package simulation;

import truck.Truck;
import model.MenuItem;
import model.Player;

import java.io.FileWriter;
import java.io.IOException;

import model.Ingredient;

public class Demo {
    public static void main(String[] args) {
        Truck owensTruck = new Truck("Owens food truck", 500.0, 10, 20, 8, 6);
        Truck billsTruck = new Truck("Bills truck", 195, 0, 3, 1, 3);
        Player bill = new Player("Bill", 2, 27, true, 18);
        Player luca = new Player("Luca", 1, 23, true, 8);

        String owensJson = String.format("{\"name\":\"%s\",\"startingCash\":%.1f,\"xLoc\":%d,\"yLoc\":%d,\"length\":%d,\"width\":%d}",
            owensTruck.getName(), owensTruck.getStartingCash(), owensTruck.getXLoc(), owensTruck.getYLoc(), owensTruck.getLength(), owensTruck.getWidth());

        String billsJson = String.format("{\"name\":\"%s\",\"startingCash\":%.1f,\"xLoc\":%d,\"yLoc\":%d,\"length\":%d,\"width\":%d}",
            billsTruck.getName(), billsTruck.getStartingCash(), billsTruck.getXLoc(), billsTruck.getYLoc(), billsTruck.getLength(), billsTruck.getWidth());

        String billJson = String.format("{\"name\":\"%s\",\"hungrinessIndex\":%d,\"cashOnHand\":%.2f,\"cashOnly\":%b,\"maxWillingnessToPay\":%.2f}",
            bill.getName(), bill.getHungrinessIndex(), bill.getCashOnHand(), bill.isCashOnly(), bill.getMaxWillingnessToPay());

        String lucaJson = String.format("{\"name\":\"%s\",\"hungrinessIndex\":%d,\"cashOnHand\":%.2f,\"cashOnly\":%b,\"maxWillingnessToPay\":%.2f}",
            luca.getName(), luca.getHungrinessIndex(), luca.getCashOnHand(), luca.isCashOnly(), luca.getMaxWillingnessToPay());

        // Truck JSON array
        String trucksJsonArray = String.format("[%s,%s]", owensJson, billsJson);

        // Player JSON array  
        String playersJsonArray = String.format("[%s,%s]", billJson, lucaJson);

        try (FileWriter writer = new FileWriter("trucks.json")) {
            writer.write(trucksJsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter("players.json")) {
            writer.write(playersJsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
