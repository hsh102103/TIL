package strategyPattern.example1.v1;

/**
 * 만약 버스를 선로를 통해 이동시키고싶다면? <br/>
 * 구현된 메서드를 직접 변경해야한다. -> OCP 위배
 */
public class Client {
    public static void main(String[] args) {
        Movable train = new Train();
        Movable bus = new Bus();

        train.move();
        bus.move();
    }
}
