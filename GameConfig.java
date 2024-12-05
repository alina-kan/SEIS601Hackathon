// Configuration Manager (also the text file)

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GameConfig {
    private static final String RESULTS_FILE = "game_results.txt";

    // Method to add new game result
    public void saveGameRun(String playerName, String bowName, int score) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(RESULTS_FILE, true))) {
            writer.printf("Player Name: %s | Bow Name: %s | Score: %d%n", playerName, bowName, score);
        } catch (IOException e) {
            System.err.println("Error saving game results: " + e.getMessage());
        }
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
