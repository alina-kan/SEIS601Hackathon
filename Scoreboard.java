public class Scoreboard {
    public ArrayList<Long> highScores = new ArrayList<Long>();

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
        
        highScores.add(index, time);
    }
}
