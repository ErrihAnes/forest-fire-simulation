import java.util.Random;

public class Simulation {
    private Forest forest;
    private double probability;
    private Random random;

    // constructeur
    public Simulation(Forest _forest, double _probability) {
        this.forest = _forest;
        this.probability = _probability;
        this.random = new Random();

    }
    // verifier si il y'a encore du feu
    private boolean hasFire(){
        for (int y = 0; y< forest.getHeight(); y++){
            for (int x = 0; x< forest.getWidth(); x++){
                if(forest.getCell(x, y).isFire()){
                    return true;
                }
            }
        }
        return false;
    }
    // cloner la matrice (foret) :
    private Forest copyForest(Forest _forest){
        Forest copy = new Forest(forest.getWidth(), forest.getHeight());
        for (int y = 0; y< forest.getHeight(); y++){
            for (int x = 0; x< forest.getWidth(); x++){
                copy.getCell(x,y).setState(forest.getCell(x,y).getState());
            }
        }
        return copy;
    }
    // Propager le feu aux voisines
    private void Propagate(int x, int y, Forest newForest) {

        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        int randomPercent = random.nextInt(100);
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];


            if (forest.isPositionValid(newX, newY) &&
                    newForest.getCell(newX, newY).isVegetation() &&
                    random.nextDouble() < probability) {

                newForest.setFire(newX, newY);
            }
        }
    }

    public void simulate() {
        int step = 1;

        while (hasFire()){
            step++;
            System.out.println("Étape " + step + " :");

            Forest newForest = copyForest(forest);

            for(int y = 0; y < newForest.getHeight(); y++){
                for(int x = 0; x < newForest.getWidth(); x++){

                    if(forest.getCell(x, y).isFire()){
                        newForest.getCell(x,y).setOnAsh();

                        Propagate(x, y, newForest);
                    }
                }
            }
            this.forest = newForest;
            forest.display();

        }
        System.out.println("étape " + step + " terminée:");
    }

}
