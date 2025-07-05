import java.io.*;
import java.util.*;

public class Config {

    private int width;
    private int height;
    private double probability;

    private List<int[]> initialFires;

    public Config(String filename) {
        initialFires = new ArrayList<>();
        loadConfig(filename);
    }

    private void loadConfig(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();

                    switch (key) {
                        case "width":
                            width = Integer.parseInt(value);
                            break;
                        case "height":
                            height = Integer.parseInt(value);
                            break;
                        case "probability":
                            probability = Double.parseDouble(value);
                            break;
                        case "initial_fires":
                            parseInitialFires(value);
                            break;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
    private void parseInitialFires(String firesList) {
        String[] fires = firesList.split(";");
        for (String fire : fires) {
            String[] coords = fire.split(",");
            if (coords.length == 2) {
                int x = Integer.parseInt(coords[0].trim());
                int y = Integer.parseInt(coords[1].trim());
                initialFires.add(new int[]{x, y});
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getProbability() {
        return probability;
    }

    public List<int[]> getInitialFires() {
        return initialFires;
    }

    public void display() {
        System.out.println("Configuration :");
        System.out.println("- Dimensions : " + width + "x" + height);
        System.out.println("- Probabilité : " + probability);
        System.out.println("- Feux initiaux :");
        for (int[] fire : initialFires) {
            System.out.println("  (" + fire[0] + "," + fire[1] + ")");
        }
    }


}
