package strategyPattern.example1.v2;

public class RailStrategy implements MovableStrategy{
    @Override
    public void move() {
        System.out.println("선로를 통해 이동");
    }
}
