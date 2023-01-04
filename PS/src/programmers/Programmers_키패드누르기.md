# 2020 카카오 인턴십 - 키패드 누르기 (프로그래머스)

# [문제](https://school.programmers.co.kr/learn/courses/30/lessons/67256)

## 문제설명

이 문제는 스마트폰 전화 키패드에서 주어지는 숫자배열(numbers)을 차례대로 누를 때, 조건에 따라 왼손으로 누를지 오른손으로 누를지를 차례대로 담아 문자열로 반환해주는 문제입니다.

```
1 2 3
4 5 6
7 8 9
* 0 #
```

## 제한 조건

- 1<= numbers <= 1000 (순서대로 누를 번호가 담긴 배열)
- numbers 배열의 원소 값은 0이상 9이하의 정수

## 특이사항

맨 처음 각 손은 \*과 #에 위치합니다.
특이 사항으로는 좌측 열의 `1,4,7`은 반드시 왼손으로, 우측 열의 `3,6,9`는 오른손으로 눌러야합니다.  
가운데의 `2,5,8,0`의 경우 가까운 손으로 눌러야합니다. 이때, 거리가 같다면 매개변수로 들어오는 hand값에 따라 "left"면 왼손으로, "right"라면 오른손으로 눌러야합니다.

## 풀이 설명

문제를 읽어보았을 때, 좌측 열과 우측 열의 경우에는 예외없이 정해진 손으로 누르면 된다고 생각했습니다.  
그래서 가운데 열의 숫자를 어떻게 해결할 지에 대해 중점적으로 생각하며 문제를 풀었습니다.  
그렇기 때문에 문제에서 주어지는 첫번째 규칙은 거리를 표현하는 데에만 사용하고, 따로 배열을 만들거나 그래프 탐색을 할 필요는 없다고 판단하였습니다.

관찰해보니 손의 행에서 다음 숫자의 행의 차이가 이동 거리가 되었고, 손이 정해진 열(좌측 열, 우측 열)에서 가운데 열의 숫자를 누르기 위해서는 가운데 열로의 추가적인 이동거리 1이 필요하다는 것을 알 수 있었습니다.  
위의 생각을 활용하기 위해 숫자가 들어올 때 움직인 손의 최종 행을 변수에 담아주었습니다. 또한, 손이 중앙에 있는지 없는지를 참/거짓형 배열에 담아주어 손의 마지막위치가 중앙 열이라면 거리를 -1 해주었습니다.

단순한 구현문제라고 생각이 들어서 문제에 주어진 조건만 잘 체크하여 문제를 풀었다.

## 시간 복잡도

하나의 반복문을 사용하여 numbers 배열을 탐색하고 결과를 도출하기 때문에 O(N)의 시간 복잡도를 가지게 됩니다.

## 공간 복잡도

탐색할 떄, 주어진 배열과 isCenter[2]배열을 사용하기 떄문에 O(N)의 공간 복잡도를 가지게 됩니다.

## 어려웠던 부분

손이 가운데로 가게되었을 때, 그 다음 수와의 거리를 어떻게 처리할 지가 어려웠습니다. 가운데있다면 거리가 1 줄어드는 것을 생각한 이후에 쉽게 처리할 수 있었습니다.

### 소요시간

80분.

## 소스코드

```java
import java.util.*;
class Solution {
    // 각 손의 행을 저장할 변수, 처음에는 *과 #이기 때문에 3으로 초기화
    int leftHand = 3;
    int rightHand = 3;

    /**
     * @param numbers 순서대로 눌러야하는 번호가 들어있는 배열
     * @param hand 왼손잡이라면 "left", 오른손잡이라면 "right"
     * @return 각 번호를 누른 엄지손가락이 왼손인지 오른손인지를 차례대로 담은 문자열
     */
    public String solution(int[] numbers, String hand) {
        String answer = "";

        // {왼손,오른손}으로 중앙의 숫자에 손이 올라가있는지 체크
        int[] isCenter = new int[2]; // true라면 가운데 열에 손이 올라가있는 상태를 의미

        for(int number: numbers) { // 배열을 차례대로 확인한다.

            if(number == 1 || number == 4 || number == 7) { // 좌측 열의 숫자가 들어왔을 때
                answer += "L";
                leftHand = number/3; // 몫으로 행을 구분하기 위해
                isCenter[0] = 0; // 왼손이 좌측 열로 이동했기 때문에 isCenter[0] = false
                continue;
            }
            if(number == 3 || number == 6 || number == 9) { // 우측 열의 숫자가 들어왔을 때
                answer += "R";
                rightHand = (number-1)/3; // 다른 열일 때와 행을 맞춰주기 위해 -1후에 /3
                isCenter[1] = 0;
                continue;
            }
            // number가 2,5,8,0 중 하나일 때 (즉, 가운데 열)
            if(number == 0) number = 10; // 행을 맞춰주기 위하여 0을 10으로 변경하여 저장
            number /= 3; // number값이 위치한 행으로 바뀌어 저장된다.

            // 가까운 손 찾기 -> (왼손과의 거리) - (오른손과의 거리)
            int distance = getDistance(leftHand, rightHand, number, isCenter);

            // 거리 비교
            if(distance < 0) { // 음수라면 왼손이 더 가까운 경우
                answer += "L";
                leftHand = number; // 위에서 number값을 행의 값으로 변경했기 때문에 바로 담아준다.
                isCenter[0] = 1;
            } else if(distance > 0) { // 양수라면 오른손이 더 가까운 경우
                answer += "R";
                rightHand = number;
                isCenter[1] = 1;
            } else { // 거리가 같을경우 주손 사용
                if(hand.equals("left")){ // 주손이 "left"일 경우
                    answer += "L";
                    leftHand = number;
                    isCenter[0] = 1;
                }else{
                    answer += "R";
                    rightHand = number;
                    isCenter[1] = 1;
                }
            }

        }
        return answer;
    }
    private int getDistance(int leftHand, int rightHand, int number, int[] isCenter) {
        // 왼손거리 - 오른손거리
        return Math.abs(leftHand - number) - isCenter[0] - (Math.abs(rightHand - number) - isCenter[1]);
    }
}
```
