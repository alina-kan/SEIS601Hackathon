public class Player {
    public String PlayerName;
    public int score;
    public boolean undo;
    public String currentLocation;
    public int bowHealth;

    public Player(String PlayerName, int score, boolean undo){
        this.PlayerName = PlayerName;
        this.score = 0;
        this.undo = true;
        this.currentLocation = "main";
        this.bowHealth = 100;
    }

    public String report() {
        return "Player " + PlayerName + ":\nScore: " + score + ", Current Bow Health: " + bowHealth + ", Undo Available: " + undo + ", Current Location: " + currentLocation;
    }

}

/*
 * public class Player {
    public String playerName;
    public int score = 0;
    public boolean undo = true; // Placeholder: Modify or remove if not used in gameplay
    public String currentLocation = "main"; // Tracks location, update during gameplay
    public int bowHealth = 100; // Default starting bow health

    // Constructor
    public Player(String playerName, int score, boolean undo) {
        this.playerName = playerName;
        this.score = score;
        this.undo = undo;
    }

    // Report player status
    public String report() {
        return String.format(
            "Player %s:\n  Score: %d\n  Current Bow Health: %d\n  Undo Available: %b\n  Current Location: %s",
            playerName, score, bowHealth, undo, currentLocation
        );
    }
}
 */

 // Again, use whatever resources to try and adjust the code, I'll be looking through all this
 // again and again when I have the time before the next class