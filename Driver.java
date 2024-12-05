import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Driver {
    public static void main(String[] args) {
        GameConfig config = new GameConfig();
        Scanner scanner = new Scanner(System.in);
        boolean gameContinue = true;
        Player player = null;
        System.out.println("Welcome to Hunting Around!");
        System.out.println("If at any point during the game you would like to save, type \"save\", and feel free to quit.");
        System.out.print("Are you a returning player? (Y/N): ");
        String answer = scanner.nextLine().trim().toLowerCase();
        if (answer.equals("y")){
            System.out.print("Enter player name: ");
            player = new Player(scanner.nextLine(), 0, true);
        } else if (!answer.equals("y")&&!answer.equals("n")){
            System.out.println("Invalid choice. Please enter the number of which area you'd like to explore.");
        } else {
            System.out.print("Please enter your name: ");
            player = new Player(scanner.nextLine(), 0, true);
        }

        //let game start and continue on until player wants to quit
        while(gameContinue){
            System.out.println("Your current score: " + player.score);
            System.out.print("Which area would you like to hunt in?\n1. The small animal grove\n2. The big animal forest\nYour Choice (number, or type \"quit\" to finish): ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")){
                int groveScore = groveGame();
                player.score += groveScore;
            } else if (choice.equals("2")){
                int forestScore = forestGame();
                player.score += forestScore;
            } else if (choice.toLowerCase().equals("quit")){
                
                System.out.println("\nGame Over! Your final score: " + player.score);
                System.out.print("Enter your name: "); 
                String playerName = scanner.nextLine(); 
                System.out.print("Enter your bow name: "); 
                String bowName = scanner.nextLine(); 
                config.saveGameRun(playerName, bowName, player.score); 
                System.out.println("Your run has been saved!"); // Display all previous results 
                
                gameContinue = endRound();
                if (gameContinue){
                    System.out.print("Please enter your name: ");
                    player.PlayerName = scanner.nextLine();
                    player.score = 0;
                    player.undo = true;
                } else {
                    config.printGameResults(); 
                    scanner.close();
                }
            } else {
                System.out.println("Invalid choice. Please enter the number of which area you'd like to explore.");
            }
        }

    }

    public static boolean endRound(){
        Scanner endScanner = new Scanner(System.in);
        while(true){
            System.out.print("Would you like to play again? (Y/N): ");
            String answer = endScanner.nextLine().trim().toLowerCase();
            if (assertEquals("n", answer)){
                return false;
            } else if (!answer.equals("y")&&!answer.equals("n")){
                System.out.println("Invalid choice. Please enter the number of which area you'd like to explore.");
            } else {
                return true;
            }
        }
        
    }

    public static int groveGame(){
        Scanner groveScanner = new Scanner(System.in);
        int currentGScore = 0;
        boolean groveContinue = true;
        boolean gStay = true;
        while(groveContinue){
            System.out.println("You are currently in the grove. Current score: " + currentGScore);

            
            while(gStay){
                System.out.print("Would you like to stay in the grove? (Y/N): ");
                String answer = groveScanner.nextLine().trim().toLowerCase();
                if (answer.equals("n")){
                    groveContinue = false;
                    gStay = false;
                } else if (!answer.equals("y")&&!answer.equals("n")){
                    System.out.println("Invalid choice. Please enter the number of which area you'd like to explore.");
                } else {
                    break;
                }
            }
            //groveContinue = false;
        }
        return currentGScore;
    }


    public static int forestGame(){
        Scanner forestScanner = new Scanner(System.in);
        int currentFScore = 0;
        boolean forestContinue = true;
        boolean fStay = true;
        while(forestContinue){
            System.out.println("You are currently in the forest. Current score: " + currentFScore);
            
            while(fStay){
                System.out.print("Would you like to stay in the forest? (Y/N): ");
                String answer = forestScanner.nextLine().trim().toLowerCase();
                if (answer.equals("n")){
                    forestContinue = false;
                    fStay = false;
                } else if (!answer.equals("y")&&!answer.equals("n")){
                    System.out.println("Invalid choice. Please enter the number of which area you'd like to explore.");
                } else {
                    break;
                }
            }
            //groveContinue = false;
        }
        return currentFScore;
    }

}