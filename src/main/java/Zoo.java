package CollectionsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Zoo {

    private final List<String> animals = new ArrayList<>(Arrays.asList("lion", "tiger", "bear"));

    public List<String> getAnimals() {
        return Collections.unmodifiableList(animals);
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        List<String> readOnlyAnimals = zoo.getAnimals();

        System.out.println("Animals: " + readOnlyAnimals);

        try {
            readOnlyAnimals.add("flamingo");
        } catch (UnsupportedOperationException e) {
            System.out.println("Caught expected exception: " + e);
        }

        System.out.println("Animals after attempted add: " + readOnlyAnimals);
    }
}