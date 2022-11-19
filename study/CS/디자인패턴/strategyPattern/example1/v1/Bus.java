package strategyPattern.example1.v1;

public class Bus implements Movable {

    @Override
    public void move() {
        System.out.println("도로를 통해 이동");
    }
}
