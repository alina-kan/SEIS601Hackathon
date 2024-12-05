import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lot {
    private String land; // Grassland OR Forest
    private List<Animal> animals;

    public Lot(String land) {
        this.land = land;
        this.animals = new ArrayList<>();
        populateLot();
        addRareSpawn(); // attempt rare spawn when lot is created
    }

    public String getLand() {
        return land;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void populateLot() {
        if (land.equals("Grasslands")) {
            // Animal, StrikeCount, minHit, maxHit, Points
            animals.add(new Animal("Rabbit", 1, 3, 20, 1));
            animals.add(new Animal("Goose", 2, 5, 20, 3));
        } else if (land.equals("Forest")) {
            animals.add(new Animal("Deer", 3, 8, 20, 5));
            animals.add(new Animal("Boar", 3, 10, 20, 10));
        }
    }

    private void addRareSpawn() {
        Random random = new Random();
        // 10% chance of spawning the Killer Rabbit from that Monty Python movie
        if (random.nextInt(10) == 0) {
            // Animal, StrikeCount, minHit, maxHit, Points
            animals.add(new Animal("Rabbit of Caerbannog", 10, 15, 20, 50));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(land + " contains:\n");
        for (Animal animal : animals) {
            sb.append("- ").append(animal).append("\n");
        }
        return sb.toString();
    }
}
