package strategyPattern.example2.v1;

/**
 * taekwonV가 날게하고 싶다면? <br/>
 * 구현된 메서드를 모두 일관성있게 수정해야한다.<br/>
 * 새로운 Robot을 만들어 기존의 공격 또는 이동 방법을 추가/수정하는 경우? <br/>
 * TaekwonV와 메서드의 내용이 중복된다.
 *  => OCP에 위배된다. <br/>
 */
public class Client {
    public static void main(String[] args) {
        Robot taekwonV = new TaekwonV("TaekwonV");
        Robot atom = new Atom("Atom");

        System.out.println("My name is " + taekwonV.getName());
        taekwonV.move();
        taekwonV.attack();

        System.out.println();
        System.out.println("My name is" + atom.getName());
        atom.move();
        atom.attack();

    }
}
