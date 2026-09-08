package CollectionsLab;

import java.util.HashMap;
import java.util.Map;

public class TreasureMap {

    public static void main(String[] args) {
        Map<String, Double> treasures = new HashMap<>();
        treasures.put("beach", 25.0);
        treasures.put("palm", 50.0);
        treasures.put("cove", 75.0);

        System.out.println("Initial map: " + treasures);

        int currentSize = treasures.size();
        double updatedPalm = treasures.get("palm") + currentSize;
        treasures.put("palm", updatedPalm);

        System.out.println("Map size used for update: " + currentSize);
        System.out.println("Updated map: " + treasures);

        double total = 0.0;
        for (double value : treasures.values()) {
            total += value;
        }

        System.out.println("Total treasure value: " + total);
    }
}