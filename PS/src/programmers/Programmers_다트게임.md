# 2018 KAKAO BLIND RECRUITMENT - [1차]다트게임 (프로그래머스)

# [문제](https://school.programmers.co.kr/learn/courses/30/lessons/17682)

## 문제설명

매개변수로 들어오는 dartResult 문자열을 확인하여, 3회의 다트게임의 총점을 구하는 문제입니다.  
다트게임 한판은 점수|보너스|[옵션]으로 이루어집니다.  

## 제한 조건

주어진 입력이 정해져있기 때문에 별도의 제한 조건은 없습니다.

## 특이사항

점수는 0 ~ 10 사이의 정수입니다. (그렇기 때문에 숫자가 2자리가 될 수 있습니다.)  
보너스는 S,D,T 중 하나입니다.  
    S는 Single, 해당 게임의 점수를 *1 해줍니다.  
    D는 Double, 해당 게임의 점수를 *2 해줍니다.  
    T는 Triple, 해당 게임의 점수를 *3 해줍니다.  
옵션은 *나 # 중 하나이며, 없을 수도 있습니다.  
    *는 해당 게임과 직전 게임의 점수를 각각 *2 해줍니다.  
    #은 해당 게임의 점수를 * -1 해줍니다.

## 풀이 설명

문자열 문제입니다.  
입력의 문자열을 인덱싱하여 문자 단위로 확인하여 처리해주었습니다.

## 시간 복잡도

처리해야하는 문자열의 최대 길이가 12입니다.  
O(N)의 시간 복잡도를 가지게 됩니다.

## 공간 복잡도

O(N)의 공간 복잡도를 가지게 됩니다.  

## 어려웠던 부분

처음 문제를 보았을 때는 매개변수로 들어오는 dartResult를 3개의 게임(3개의 문자열)으로 나누려고 했습니다.  
그러다보니 각 문자열의 길이가 달라질 수 있고, 조건문이 많이 들어가게되어 깔끔해보이지 못했습니다.  
문자열을 switch문을 사용하여 처리를 해주니 훨씬 쉽게 문제를 해결할 수 있었습니다.


### 소요시간

80분.

## 소스코드

```java
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        int[] score = new int[3]; // 각 점수를 저장할 배열
        String temp = ""; // 숫자를 임시적으로 저장할 변수
        int idx = 0; // score index를 가르킬 변수
        
        for(int i =0 ; i<dartResult.length(); i++) {
            switch(dartResult.charAt(i)) {
                case 'S': // 해당 게임의 점수 * 1
                    score[idx] = (int)Math.pow(Integer.parseInt(temp), 1);
                    idx++; // 옵션은 없을 수도 있기 때문에 다음 게임으로 넘어갑니다.
                    temp=""; // 임시로 사용하는 변수를 초기화 시켜줍니다.
                    break;
                case 'D': // 해당 게임의 점수 * 2
                    score[idx] = (int)Math.pow(Integer.parseInt(temp), 2);
                    idx++;
                    temp="";
                    break;
                case 'T': // 해당 게임의 점수 * 3
                    score[idx] = (int)Math.pow(Integer.parseInt(temp), 3);
                    idx++;
                    temp="";
                    break;
                case '*': // 해당 게임과 직전 게임의 점수를 각각 *2 해줍니다.
                    score[idx-1] *= 2; // 보너스 단계에서 인덱스를 증가 시켰기 때문에 옵션이 나오면 (idx-1)번째에 *2를 해줍니다.
                    if(idx > 1) { // 첫 게임에서도 *가 나올 수 있기 때문에 현재 진행중인 게임이 2번째 이상일 때 
                        score[idx-2] *= 2; // 직전의 게임도 2배를 해줍니다.
                    }
                    break;
                case '#':
                    score[idx-1] *= -1;
                    break;
                default: // 해당 문자가 숫자일 경우
                    temp+=String.valueOf(dartResult.charAt(i)); // 문자열로 변환하여 temp에 저장해줍니다.
                    break;  
            }
        }
        // 저장된 게임점수 배열의 값들을 모두 answer 변수에 더해줍니다.
        for(int i =0; i<arr.length; i++) {
            answer += score[i];
        }
        
        return answer;
    }
}
```
