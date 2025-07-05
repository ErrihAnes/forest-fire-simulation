public class Cell {
    private State state;

    // constructeur par défaut :
    public Cell() {
        this.state = State.VEGETATION;
    }

    //constructeur avec param :
    public Cell(State _state) {
        this.state = _state;
    }

    // getter
    public State getState() {
        return state;
    }
    // setter
    public void setState(State _state) {
        this.state = _state;
    }
    // verification :

    public boolean isVegetation() {
        return state == State.VEGETATION;
    }

    public boolean isFire() {
        return state == State.FIRE;
    }

    public boolean isAsh() {
        return state == State.ASH;
    }

    // methods :

    public Boolean setOnFire(){
        if(isVegetation()){
            setState(State.FIRE);
            return true;
        }
        return false;
    }
    public void setOnAsh(){
        if(isFire()){
            setState(State.ASH);
        }

    }

}
