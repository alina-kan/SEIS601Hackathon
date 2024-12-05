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
