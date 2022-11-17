package strategyPattern.robot.v1;

public class Atom extends Robot {
    public Atom(String name) {
        super(name);
    }

    public void attack() {
        System.out.println("I have strong punch.");
    }

    public void move() {
        System.out.println("I can fly.");
    }
}
