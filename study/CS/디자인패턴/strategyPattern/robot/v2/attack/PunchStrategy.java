package strategyPattern.robot.v2.attack;

public class PunchStrategy implements AttackStrategy{
    @Override
    public void attack() {
        System.out.println("I have strong punch.");
    }
}
