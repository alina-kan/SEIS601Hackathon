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
        /*System.out.print("Are you a returning player? (Y/N): ");
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
        } */
        System.out.print("Please enter your name: ");
        pName = scanner.nextLine();
        System.out.print("You have received a bow! Enter your bow's name: ");
        bowName = scanner.nextLine();
        player = new Player(pName, bowName, 0, "main");
        playerBow = player.getPlayerBow();
        playerBow.setBowName(bowName);
        Lot grassland = new Lot("grasslands");
        Lot forest = new Lot("forest");
        while (gameContinue){
            player.currentLocation = "main";
            //config.saveGameRun(player.playerName, bowName, player.score, player.currentLocation, player.undo);
            System.out.println("Your current score: " + player.score);
            System.out.print("Which area would you like to hunt in?\n1. The small animal grassland\n2. The big animal forest\nYour Choice (number, or type \"quit\" to finish): ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                player.currentLocation = "grassland";
                grassGame(player, config, scanner, grassland);
            } else if (choice.equals("2")) {
                player.currentLocation = "forest";
                forestGame(player, config, scanner, forest);
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
            System.out.print("You have received a bow! Enter your bow's name: ");
            player.playerBow.setBowName(scanner.nextLine());
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

    public static void grassGame(Player player, GameConfig config, Scanner scanner, Lot grassland){
        boolean grassContinue = true;
        while(grassContinue) {
            System.out.println("You are currently in the grassland. Current score: " + player.score);
            //implement game mechanics here
            System.out.print("Enter your action (leave, hunt, report, quit): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("report")) {
                System.out.println(player.report());
            } else if (answer.equals("hunt")){
                //System.out.println("Land: " + grassland.getLand());
                hunt(player, grassland, scanner, config);
                //System.out.println("Current Animals: " + grassland.getAnimals().toString());
            }else if (answer.equalsIgnoreCase("quit")){
                grassContinue = false;
                quit(player, config, scanner);
            } else if (answer.equals("leave")) {
                System.out.println("Leaving area...");
                grassContinue = false;
            } else {
                System.out.println("Invalid choice. Please enter one of the provided choices.");
            }
        }
    }


    public static void forestGame(Player player, GameConfig config, Scanner scanner, Lot forest){
        boolean forestContinue = true;
        while(forestContinue){
            System.out.println("You are currently in the forest. Current score: " + player.score);
            //implement game mechanics here
            System.out.print("Enter your action (leave, hunt, report, quit): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("report")) {
                System.out.println(player.report());
            } else if (answer.equals("hunt")){
                //System.out.println("Land: " + grassland.getLand());
                hunt(player, forest, scanner, config);
                //System.out.println("Current Animals: " + grassland.getAnimals().toString());
            }else if (answer.equalsIgnoreCase("quit")){
                forestContinue = false;
                quit(player, config, scanner);
            } else if (answer.equals("leave")) {
                System.out.println("Leaving area...");
                forestContinue = false;
            } else {
                System.out.println("Invalid choice. Please enter one of the provided choices.");
            }
        }
    }

    public static void hunt(Player player, Lot lot, Scanner scanner, GameConfig config){
        //take in list of animals from land and shoot them
        boolean hunting = true;
        while (hunting) {
            if (lot.getAnimals().size() == 0){
                System.out.println("All animals have been killed!");
                break;
            }
            System.out.println("You are currently hunting. Score: " + player.score);

            System.out.println("Current animals: ");
            for (int i = 0; i < lot.getAnimals().size(); i++){
                System.out.println(i + ": " + lot.getAnimals().get(i));
            }

            boolean notHunting = true;
            while (notHunting){
                System.out.print("Enter your action (stop, hunt, report, quit): ");
                String answer = scanner.nextLine().trim().toLowerCase();
                if (answer.equals("hunt")){
                    notHunting = false;
                } else if (answer.equals("report")) {
                    System.out.println(player.report());
                } else if (answer.equalsIgnoreCase("quit")){
                    quit(player, config, scanner);
                } else if (answer.equals("stop")) {
                    System.out.println("Stopping hunt...");
                    notHunting = false;
                    hunting = false;
                    return;
                } else {
                    System.out.println("Try again");
                }
            }

            System.out.print("Which animal do you want to shoot? Enter list number: ");
            int choice = scanner.nextInt();
            Animal chosen = lot.getAnimals().get(choice);
            scanner.nextLine();

            player.score += player.playerBow.attackAnimal(chosen);
            if (chosen.isKilled()){
                lot.getAnimals().remove(choice);
            }

            System.out.print("Would you like to keep hunting? (Y/N): ");
            String leave = scanner.nextLine();
            if (leave.equals("n")){//answer.equals("n")){
                hunting = false;
            } else if (!leave.equals("y")&&!leave.equals("n")){
                System.out.println("Invalid choice. Please enter the number of which area you'd like to explore.");
            } else {
                hunting = true;
            }
        }
    }

}