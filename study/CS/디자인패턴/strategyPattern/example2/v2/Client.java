package strategyPattern.example2.v2;

import strategyPattern.example2.v2.attack.MissileStrategy;
import strategyPattern.example2.v2.domain.Atom;
import strategyPattern.example2.v2.domain.Robot;
import strategyPattern.example2.v2.move.WalkStrategy;

public class Client {
    public static void main(String[] args) {
        Robot atom = new Atom("Atom");

        atom.setAttackStrategy(new MissileStrategy());
        atom.setMoveStrategy(new WalkStrategy());

        atom.attack();
        atom.move();

    }
}
