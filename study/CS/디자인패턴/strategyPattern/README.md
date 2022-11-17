# Strategy pattern(전략 패턴)
### 선행되면 좋은 개념
- Interface
- abstract method
- access modifier
- SOLID principle of OOP
- 4 basic concept of OOP
## 정의
policy pattern(정책 패턴)이라고도 하며, 객체의 행위를 바꾸고 싶은 경우 '직접' 수정하지 않고 
전략이라고 부르는 '캡슐화한 알고리즘'을 컨텍스트 안에서 바꿔주며서 상호 교체가 가능하게 만드는 패턴

## 사용하지 않는 경우
- 객체의 행위를 '직접' 수정하게 되는 경우, OOP 설계의 원칙인 SOLID의 원칙 중 
OCP(Open-Closed Principle, 개방-폐쇄 정책)에 위배됩니다.

- 시스템이 확장되었을 때, 메서드의 중복이 발생됩니다.
자동차, 택시, 버스 클래스가 있다면 모두 같은 move()를 사용하는 것입니다.

- 메서드에 변경이 필요한 경우, 유지보수가 어렵습니다.
예를 들어, 하늘을 나는 자동차가 생기면, 자동차 클래스의 move()는 변경되어야하지만, 
- 여러 클래스에서 똑같이 정의하고 있으므로, 수정이 어렵습니다.

**만약 Strategy pattern을 사용한다면, 위의 문제를 해결할 수 있습니다.**

## 구현 방법
1. 필요한 방식에대한 Strategy를 생성해줍니다. 다음으로, 이를 캡슐화하기 위해 Interface를 생성합니다.
2. 위에서 만든 Strategy를 사용한 클래스를 생성합니다. 이때, 클래스변수로 Strategy를 선언해주고, 
setter를 이용해 클라이언트가 직접 세팅해줄 수 있도록 구현합니다.
3. 클라이언트를 구현합니다. 생성한 객체의 setter를 이용하여 strategy를 선택하면 됩니다.

## 예제
v1의 경우, strategy pattern을 사용하지 않은 경우입니다. <br/>
v2의 경우, strategy pattern을 사용한 경우입니다.
- [movable](./movable)
- [robot](./robot)
