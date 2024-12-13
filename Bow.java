import java.util.Random;

public class Bow {
    private String bowName = "";
    private int bowHealth = 100; // base health
    private int score = 0; // inital score
    private Random random = new Random();
    
    public int getBowHealth() {
        return bowHealth;
    }

    public int getScore() {
        return score;
    }

    public String getBowName() { return bowName; }

    public void setBowName(String name) { this.bowName = name; }

    public int attackAnimal(Animal animal) {
        if (bowHealth <= 0) {
            System.out.println("Bow is broken! You can't fire anymore arrows!");
            return 0;
        }

        // roll a d20
        int roll = random.nextInt(20) + 1; // 1 to 20
        System.out.println("You rolled a " + roll + "!");

        switch (roll) {
            case 20 -> {
                // Critical hit
                System.out.println("Critical hit! You deal 2 strikes.");
                animal.reduceStrikeCount();
                animal.reduceStrikeCount();
            }
            case 1 -> {
                // Critical fail
                System.out.println("Bow Mishap! Your bow's durability falls by 10.");
                bowHealth -= 10;
            }
            default -> {
                // Normal hit
                if (roll >= animal.getMinHit() && roll <= animal.getMaxHit()) {
                    System.out.println("Hit! You deal 1 strike.");
                    animal.reduceStrikeCount();
                } else {
                    System.out.println("Miss! Your bow takes minor damage.");
                    bowHealth -= random.nextInt(2) + 2; // Random damage 2-3
                }
            }
        }

        // check if animal is downed
        if (animal.isKilled()) {
            System.out.println("You killed the " + animal.getName() + " and earned " + animal.getPoints() + " points!");
            score += animal.getPoints();
            return animal.getPoints();
        }

        // bow health
        if (bowHealth <= 0) {
            System.out.println("Your bow is broken!");
        }

        return 0;
    }
}
