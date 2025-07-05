public class Forest {
    private  Cell[][] forest;
    private int width;
    private int height;

    // initialiser la foret
    // par defaut : végétation
    private void GreenForest(){
        for(int i = 0; i<height; i++){
            for(int j = 0; j<width; j++){
                forest[i][j] = new Cell();
            }
        }
    }
    public Forest(int _width, int _height){
        this.width = _width;
        this.height = _height;
        this.forest = new Cell[height][width];
        GreenForest();
    }
    // getteur :
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    // vérifier la position dans la matrice :
    private boolean isPositionValid(int x, int y){
        return (x>= 0 && x< width) && (y>=0 && y< height);
    }

    // enflamer une case :
    public boolean setFire(int x, int y){
        if(isPositionValid(x, y)){
            forest[x][y].setState(State.FIRE);
            return true;
        }
        return false;
    }
    // recuperer une case de la foret avec des coordonnée donnée:
    public Cell getCell(int x, int y){
        if(isPositionValid(x, y)){
            return forest[x][y];
        }
        return null;
    }

    //afichage temp de la matrice (foret) :

    public void display(){
        System.out.println("Forest : ");
        for(int i = 0; i<height; i++){
            for(int j = 0; j<width; j++){
                System.out.print(forest[i][j].stateToChar() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
