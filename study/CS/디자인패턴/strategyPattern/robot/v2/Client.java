package strategyPattern.robot.v2;

import strategyPattern.robot.v2.attack.MissileStrategy;
import strategyPattern.robot.v2.domain.Atom;
import strategyPattern.robot.v2.domain.Robot;
import strategyPattern.robot.v2.move.WalkStrategy;

public class Client {
    public static void main(String[] args) {
        Robot atom = new Atom("Atom");

        atom.setAttackStrategy(new MissileStrategy());
        atom.setMoveStrategy(new WalkStrategy());

        atom.attack();
        atom.move();

    }
}
