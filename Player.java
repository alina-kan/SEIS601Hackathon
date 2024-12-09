public class Player {
    public String playerName;
    public Bow playerBow;
    public int score = 0;
    public boolean undo = true; // Placeholder: Modify or remove if not used in gameplay
    public String currentLocation = "main"; // Tracks location, update during gameplay

    public Player(String playerName, String bowName, int score, String location){
        this.playerBow = new Bow();
        playerBow.setBowName(bowName);
        this.playerName = playerName;
        this.score = playerBow.getScore();
        this.undo = true;
        this.currentLocation = location;
    }

    public Bow getPlayerBow(){ return playerBow; }

    /*
    public String report() {
        return String.format(
                "Player %s:\n  Score: %d\n  Current Bow Health: %d\n  Undo Available: %b\n  Current Location: %s",
                playerName, score, bowHealth, undo, currentLocation
        );
    } */

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