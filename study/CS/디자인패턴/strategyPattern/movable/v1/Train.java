package strategyPattern.movable.v1;

public class Train implements Movable {
    @Override
    public void move() {
        System.out.println("선로를 통해 이동");
    }
}
