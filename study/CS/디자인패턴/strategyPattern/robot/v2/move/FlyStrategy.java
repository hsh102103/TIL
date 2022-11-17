package strategyPattern.robot.v2.move;

public class FlyStrategy implements MoveStrategy{
    @Override
    public void move() {
        System.out.println("I can fly.");
    }
}
