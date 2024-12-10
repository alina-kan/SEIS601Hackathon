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

    public Bow getPlayerBow(){ 
        return playerBow; 
    }

    // 12/10 update
    public String report() {
        return String.format(
               // "Player %s:\n  Score: %d\n  Current Bow Health: %d\n  Undo Available: %b\n  Current Location: %s",
               // playerName, score, playerBow.getBowHealth(), undo, currentLocation
               
               // 12/10 update
               "Player %s:\n  Score: %d\n  Current Bow Health: %d\n  Undo Available: %s\n  Current Location: %s",
               playerName, score, playerBow.getBowHealth(), undo ? "Yes" : "No", currentLocation
        );
    }

}

/*
 * public class Player {
    public String PlayerName;
    public int score;
    public boolean undo;
    public String currentLocation;
    public int bowHealth;

    public Player(String PlayerName, int score, boolean undo) {
        this.PlayerName = PlayerName;
        this.score = score;
        this.undo = undo;
        this.currentLocation = "main";
        this.bowHealth = 100;
    }

    public void resetState(String location, int health, int score) {
        this.currentLocation = location;
        this.bowHealth = health;
        this.score = score;
    }

    public void updateScore(int points) {
        this.score += points;
    }

    public void damageBow(int damage) {
        this.bowHealth -= damage;
        if (this.bowHealth < 0) this.bowHealth = 0;
    }

    public String report() {
        return "Player " + PlayerName + ":\nScore: " + score + ", Current Bow Health: " + bowHealth + ", Undo Available: " + undo + ", Current Location: " + currentLocation;
    }
}
 */

// 12/10 update, check it out