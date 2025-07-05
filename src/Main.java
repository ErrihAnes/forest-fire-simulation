//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Début Simulation de Feu de Forêt  : ");
        Config config = new Config("config.txt");
        config.display();

        Forest forest = new Forest(config.getWidth(), config.getHeight());
        for (int[] fire : config.getInitialFires()) {
            forest.setFire(fire[0], fire[1]);
        }

        System.out.println("État initial");
        forest.display();

        Simulation simulation = new Simulation(forest, config.getProbability());
        simulation.simulate();
    }
}