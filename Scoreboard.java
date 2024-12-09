import java.util.ArrayList;

public class Scoreboard {
    public ArrayList<Integer> highScores = new ArrayList<Integer>();

    public void update(int score){
        System.out.println("--Current Leaderboard-- ");
        int index = 0;
        for(int i = 0; i < highScores.size(); i++) {
            //loop through the array list of current times
            if (score < highScores.get(i)) {
                //if the time is smaller than the time in the leaderboard being checked
                index = i;
                //put the smaller time in that position and 
                //then break the loop so it doesn't check any other times
                break;
            } else {
                index = highScores.size();
                //else, just put the time at the end of the list
            }
        }
        
        highScores.add(index, Integer.valueOf(score));
    }
}

/*
import java.util.ArrayList;

public class Scoreboard {
    private ArrayList<Integer> highScores = new ArrayList<>();

    // Add a score to the leaderboard and maintain descending order
    public void update(int score) {
        int index = 0;

        // Find the correct position to insert the score
        for (int i = 0; i < highScores.size(); i++) {
            if (score > highScores.get(i)) {
                index = i;
                break;
            } else {
                index = highScores.size();
            }
        }

        // Add the score to the list
        highScores.add(index, score);

        // Print updated leaderboard
        System.out.println("\n-- Current Leaderboard --");
        printLeaderboard();
    }

    // Display all scores in the leaderboard
    public void printLeaderboard() {
        for (int i = 0; i < highScores.size(); i++) {
            System.out.println((i + 1) + ". " + highScores.get(i));
        }
    }
}
 * 
 */
