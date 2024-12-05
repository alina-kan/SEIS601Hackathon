public class Animal {
    // This will take precedence of two lots, two animal types each, with strike counts
    // Lets go Rabbits and Geese in small categories, and deer and boar in the large
    // Rabbits will have 1 strike counter, Geese 2, deer and boar have 3 respectively
    private String name;
    private int strikeCount;
    private int minHit; // Minimum roll to hit
    private int maxHit; // Maximum roll to hit
    private int points; // Points awarded for killing

    public Animal(String name, int strikeCount, int minHit, int maxHit, int points) {
        this.name = name;
        this.strikeCount = strikeCount;
        this.minHit = minHit;
        this.maxHit = maxHit;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getMinHit() {
        return minHit;
    }

    public int getMaxHit() {
        return maxHit;
    }

    public int getPoints() {
        return points;
    }

    public void reduceStrikeCount() {
        if (strikeCount > 0) {
            strikeCount--;
        }
    }

    public boolean isKilled() {
        return strikeCount <= 0;
    }

    @Override
    public String toString() {
        return name + "(Strikes left: " + strikeCount + ")";
    }
}
