// Configuration Manager (also the text file)

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.PrintWriter;

public class GameConfig {
    private static final String SAVE_FILE = "game_save.txt";
    private static final String RESULTS_FILE = "game_results.txt";

    // Method to add new game result
    public void saveGameRun(String playerName, String bowName, int score, String location, boolean undo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(RESULTS_FILE, true))) {
            writer.printf("Player Name: %s | Bow Name: %s | Score: %d | Location: %s | Undo Available: %s | Save Time: %s%n" , playerName, bowName, score, location, undo, currentTime());
        } catch (IOException e) {
            System.err.println("Error saving game results: " + e.getMessage());
        }
    }

    //method to grab current time
    public String currentTime() {
        String formattedDateTime = "";
        try {
            // Get the current date and time
            LocalDateTime now = LocalDateTime.now();

            // Format the date and time
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            formattedDateTime = now.format(formatter);

            //System.out.println("Time saved to file: " + formattedDateTime);
        } catch (Exception e) {
            formattedDateTime = "TIME ERROR";
            System.out.println("An error occurred while saving the time: " + e.getMessage());
        }
        return formattedDateTime;
    }

    //method to read last save
    public Player findLastSave(String name) {
        try (BufferedReader reader = new BufferedReader(new FileReader(RESULTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("No results found yet!");
        }
        return new Player(name, "", 0, "main");
    }

    // Method to display all saved results
    public void printGameResults() {
        System.out.println("\n--- Game Results ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(RESULTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("No results found yet!");
        }
    }
}
