package strategyPattern.example2.v2.attack;

public class MissileStrategy implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("I have Missile.");
    }
}
