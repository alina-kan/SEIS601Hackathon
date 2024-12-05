public class Animal {
    // This will take precedence of two lots, two animal types each, with strike counts
    // Lets go Rabbits and Geese in small categories, and deer and boar in the large
    // Rabbits will have 1 strike counter, Geese 2, deer and boar have 3 respectively
    private String name;
    private int strikeCount;

    public Animal(String name, int strikeCount) {
        this.name = name;
        this.strikeCount = strikeCount;
    }

    public String getName() {
        return name;
    }

    public int getStrikeCount() {
        return strikeCount;
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