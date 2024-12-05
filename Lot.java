import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random;

public class Lot {
    private String land; // Grassland OR Forest
    private List<Animal> animals;

    public Lot(String land) {
        this.land = land;
        this.animals = new ArrayList<>();
        addRareSpawn(); // attempt rare spawn when lot is created
    }

    public String getLand() {
        return land;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    private void addRareSpawn() {
        Random random = new Random();
        // 10% chance of spawning the Killer Rabbit from that Monty Python movie
        if (random.nextInt(10) == 0) {
            animals.add(new Animal("Rabbit of Caerbannog", 10));
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
