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

/*

import java.util.Scanner;

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
        if (answer.equals("y")) {
            System.out.print("Enter player name: ");
            String playerName = scanner.nextLine();
            player = config.loadGame(playerName);
            if (player == null) {
                System.out.println("No save found. Starting a new game.");
                player = new Player(playerName, 0, true);
            }
        } else {
            System.out.print("Please enter your name: ");
            String playerName = scanner.nextLine();
            player = new Player(playerName, 0, true);
        }

        Bow bow = new Bow(100);

        while (gameContinue) {
            System.out.println(player.report());
            System.out.println(bow.report());
            System.out.print("Which area would you like to hunt in?\n1. The small animal grove\n2. The big animal forest\nYour Choice (number, or type \"quit\" to finish): ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("1")) {
                int groveScore = huntInLot("Grassland", bow, player);
                player.updateScore(groveScore);
            } else if (choice.equals("2")) {
                int forestScore = huntInLot("Forest", bow, player);
                player.updateScore(forestScore);
            } else if (choice.equals("save")) {
                config.saveGameRun(player.PlayerName, player);
            } else if (choice.equals("quit")) {
                System.out.println("\nGame Over! Your final score: " + player.score);
                System.out.print("Enter your bow name: ");
                String bowName = scanner.nextLine();
                config.saveGameRun(player.PlayerName + "'s " + bowName, player);
                System.out.println("Your run has been saved!");
                gameContinue = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

            if (bow.isBroken()) {
                System.out.println("Your bow has broken! Game over.");
                gameContinue = false;
            }
        }

        System.out.println("Final Leaderboard:");
        config.savedGames.forEach((name, savedPlayer) -> {
            System.out.println(name + " - Score: " + savedPlayer.score);
        });

        scanner.close();
    }

    public static int huntInLot(String lotName, Bow bow, Player player) {
        Lot lot = new Lot(lotName);
        Scanner scanner = new Scanner(System.in);
        int pointsEarned = 0;

        while (true) {
            System.out.println("You are hunting in the " + lotName + ".");
            Animal animal = lot.spawnAnimal();
            System.out.println("You encountered a " + animal.getName() + "! It requires " + animal.getHealth() + " strikes to kill.");

            while (animal.getHealth() > 0) {
                System.out.print("Roll to strike (type \"roll\" or \"leave\" to exit): ");
                String action = scanner.nextLine().trim().toLowerCase();

                if (action.equals("roll")) {
                    int roll = (int) (Math.random() * 20) + 1;
                    if (roll >= animal.getHitRequirement()) {
                        System.out.println("You hit the " + animal.getName() + "!");
                        animal.reduceHealth();
                        if (roll == 20) {
                            System.out.println("Critical hit! You deal an extra strike.");
                            animal.reduceHealth();
                        }
                    } else if (roll == 1) {
                        System.out.println("Critical fail! Your bow takes damage.");
                        bow.useBow(10);
                    } else {
                        System.out.println("You missed!");
                        bow.useBow(5);
                    }

                    if (bow.isBroken()) {
                        System.out.println("Your bow broke mid-hunt! Returning to camp.");
                        return pointsEarned;
                    }
                } else if (action.equals("leave")) {
                    System.out.println("You left the " + lotName + ".");
                    return pointsEarned;
                } else {
                    System.out.println("Invalid action. Try again.");
                }
            }
        if (animal.getHealth() <= 0) {
            System.out.println("You killed the " + animal.getName() + "! You earn " + animal.getPoints() + " points.");
            pointsEarned += animal.getPoints();
        }
    }
}

 */

 // 12/10, maybe this will work for the intergartion rather than jupiter?