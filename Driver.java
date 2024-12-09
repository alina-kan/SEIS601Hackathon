import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Driver {

    public static void main(String[] args) {
        GameConfig config = new GameConfig();
        Scanner scanner = new Scanner(System.in);
        boolean gameContinue = true;
        String pName = "";
        Player player = null;
        Bow playerBow = null;
        String bowName = "";
        System.out.println("Welcome to Hunting Around!");
        System.out.println("This game auto saves, so feel free to quit at any time.");
        System.out.print("Are you a returning player? (Y/N): ");
        String answer = scanner.nextLine().trim().toLowerCase();
        if (answer.equals("y")){
            System.out.print("Enter player name: ");
            pName = scanner.nextLine();
            System.out.print("Enter bow name: ");
            bowName = scanner.nextLine();
            player = new Player(pName, bowName, 0, "main");
            playerBow = player.getPlayerBow();
            playerBow.setBowName(bowName);
        } else if (!answer.equals("y")&&!answer.equals("n")){
            System.out.println("Invalid choice. Please enter the number of which area you'd like to explore.");
        } else {
            System.out.print("Please enter your name: ");
            pName = scanner.nextLine();
            System.out.print("You have received a bow! Enter your bow's name: ");
            bowName = scanner.nextLine();
            player = new Player(pName, bowName, 0, "main");
            playerBow = player.getPlayerBow();
            playerBow.setBowName(bowName);
        }

        while (gameContinue){
            player.currentLocation = "main";
            config.saveGameRun(player.playerName, bowName, player.score, player.currentLocation, player.undo);
            System.out.println("Your current score: " + player.score);
            System.out.print("Which area would you like to hunt in?\n1. The small animal grove\n2. The big animal forest\nYour Choice (number, or type \"quit\" to finish): ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                player.currentLocation = "grove";
                groveGame(player, config, scanner);
            } else if (choice.equals("2")) {
                player.currentLocation = "forest";
                forestGame(player, config, scanner);
            } else if (choice.equalsIgnoreCase("quit")) {
                quit(player, config, scanner);
            } else {
                System.out.println("Invalid choice. Please enter the number of which area you'd like to explore.");
            }
        }
    }

    public static void quit(Player player, GameConfig config, Scanner scanner) {
        System.out.println("Quitting...\nGame Over! Your final score: " + player.score);
        config.saveGameRun(player.playerName, player.getPlayerBow().getBowName(), player.score, player.currentLocation, player.undo);
        System.out.println("Your run has been saved!"); // Display all previous results

        boolean gameRestart = endRound();
        if (gameRestart){
            System.out.print("Please enter your name: ");
            player.playerName = scanner.nextLine();
            player.score = 0;
            player.undo = true;
        } else {
            config.printGameResults();
            scanner.close();
            System.exit(0);
        }
    }

    public static boolean endRound(){
        Scanner endScanner = new Scanner(System.in);
        System.out.print("Would you like to play again? (Y/N): ");
        String answer = endScanner.nextLine().trim().toLowerCase();
        if (answer.equals("n")){//answer.equals("n")){
            assertTrue(answer.equals("n"));
            return false;
        } else if (!answer.equals("y")&&!answer.equals("n")){
            System.out.println("Invalid choice. Please enter the number of which area you'd like to explore.");
        }
        return true;
    }

    public static void groveGame(Player player, GameConfig config, Scanner scanner){
        boolean groveContinue = true;
        boolean gStay = true;
        while(groveContinue){
            System.out.println("You are currently in the grove. Current score: " + player.score);
            //implement game mechanics here
            while(gStay){
                System.out.print("Would you like to stay in the grove? (Y/N): ");
                String answer = scanner.nextLine().trim().toLowerCase();
                if (answer.equals("n")){
                    groveContinue = false;
                    gStay = false;
                } else if (answer.equalsIgnoreCase("quit")){
                    groveContinue = false;
                    quit(player, config, scanner);
                } else if (!answer.equals("y")&&!answer.equals("n") && !answer.equalsIgnoreCase("quit")){
                    System.out.println("Invalid choice. Please enter one of the provided choices.");
                } else {
                    break;
                }
            }
        }
    }


    public static void forestGame(Player player, GameConfig config, Scanner scanner){
        Scanner forestScanner = new Scanner(System.in);
        boolean forestContinue = true;
        boolean fStay = true;
        while(forestContinue){
            System.out.println("You are currently in the forest. Current score: " + player.score);
            
            while(fStay){
                System.out.print("Would you like to stay in the forest? (Y/N): ");
                String answer = forestScanner.nextLine().trim().toLowerCase();
                if (answer.equals("n")){
                    forestContinue = false;
                    fStay = false;
                } else if (answer.equalsIgnoreCase("quit")){
                    forestContinue = false;
                    quit(player, config, scanner);
                } else if (!answer.equals("y")&&!answer.equals("n") && !answer.equalsIgnoreCase("quit")){
                    System.out.println("Invalid choice. Please enter one of the provided choices.");
                } else {
                    break;
                }
            }
            //groveContinue = false;
        }
    }

}