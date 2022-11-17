package strategyPattern.movable.v2;

public class Client {
    public static void main(String[] args) {
        Moving bus = new Bus();
        Moving train = new Train();

        bus.setMovableStrategy(new LoadStrategy());
        train.setMovableStrategy(new RailStrategy());
        bus.move();
        train.move();

        train.setMovableStrategy(new LoadStrategy());
        train.move();
    }
}
