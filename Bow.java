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

    // 12/10 update
    public void setBowHealth(int health) {
        this.bowHealth = health;
    }
    
    // 12/10 update
    public void setScore(int score) {
        this.score = score;
    }

    public String getBowName() { return bowName; }

    public void setBowName(String name) { this.bowName = name; }

    public boolean attackAnimal(Animal animal) {
        if (bowHealth <= 0) {
            System.out.println("Bow is broken! You can't fire anymore arrows!");
            return false;
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
            return true;
        }

        // bow health
        if (bowHealth <= 0) {
            System.out.println("Your bow is broken!");
        }

        return false;
    }
}


/*
 * public class Bow {
    private int durability;

    public Bow(int durability) {
        this.durability = durability;
    }

    public boolean isBroken() {
        return durability <= 0;
    }

    public void useBow(int damage) {
        this.durability -= damage;
        if (this.durability < 0) this.durability = 0;
    }

    public int getDurability() {
        return durability;
    }

    public String report() {
        return "Bow Durability: " + durability;
    }
}
 */

 // I don't know if this is necessary