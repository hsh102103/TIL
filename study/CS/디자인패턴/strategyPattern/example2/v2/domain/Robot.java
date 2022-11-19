package strategyPattern.example2.v2.domain;

import strategyPattern.example2.v2.attack.AttackStrategy;
import strategyPattern.example2.v2.move.MoveStrategy;

public class Robot {
    private AttackStrategy attackStrategy;
    private MoveStrategy moveStrategy;
    private String name;
    public Robot(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }
    public void attack(){
        attackStrategy.attack();
    }
    public void move(){
        moveStrategy.move();
    }
}
