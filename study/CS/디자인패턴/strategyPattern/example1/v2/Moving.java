package strategyPattern.example1.v2;

public class Moving {
    private MovableStrategy movableStrategy;
    void move(){
        movableStrategy.move();
    }
    void setMovableStrategy(MovableStrategy movableStrategy){
        this.movableStrategy = movableStrategy;
    }

}
