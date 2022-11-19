package strategyPattern.example2.v2.move;

public class WalkStrategy implements MoveStrategy{
    @Override
    public void move() {
        System.out.println("I can only walk.");
    }
}
