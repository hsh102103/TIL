package strategyPattern.robot.v1;

public class TaekwonV extends Robot {
    TaekwonV(String name) {
        super(name);
    }

    public void attack() { System.out.println("I have Missile."); }
    public void move() { System.out.println("I can only walk."); }
}
