# Bubble Sort (거품 정렬)
[정의](#정의)  
[과정](#과정ascending)  
[시간복잡도](#시간-복잡도)  
[특징](#특징)
## 정의
Bubble sort는 `서로 인접한 두 원소를 비교하고, 조건에 맞지 않다면 자리를 교환하며 정렬하는 알고리즘`이다.  
정렬하는 과정에서 원소가 이동하는 모습이 거품이 수면으로 올라오는 모습과 비슷하여 Bubble sort라 부른다고 한다.

## 과정(ascending)
![bubble-sort](https://raw.githubusercontent.com/GimunLee/tech-refrigerator/master/Algorithm/resources/bubble-sort-001.gif)
2중 for문을 이용하여 맨 끝 원소부터 정렬해간다.

```java
    void bubbleSort(int[] arr) {
        int temp = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 1; j < arr.length-i; j++) {
                if(arr[j-1] > arr[j]) {
                    // swap(arr[j-1], arr[j])
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
```
1. i만큼 마지막 인덱스에서 i번쨰 위치까지 정렬이 완료된다. (제외될 원소의 갯수)  


## 시간 복잡도
**O(n^2)**  
(n-1) + (n-2) + (n-3) + ... + 2 + 1 => n(n-1)/2  
일반적인 Bubble Sort의 경우 정렬여부에 관계없이 N에 따라 정해진 횟수를 반복하기 때문에 최선, 평균, 최악의 경우에서 시간복잡도가 동일하다.

## 특징
### 장점
- 구현이 간단하다. 코드가 직관적이다.
- 주어진 배열 안에서 교환을 통해 정렬이 수행되므로 추가적인 메모리 공간을 필요로 하지 않는다. -> 제자리 정렬(in-place sorting)
- 안정 정렬(Stable Sort)이다.
### 단점
- 시간 복잡도 기준으로 매우 비효율적이다.
- 교환 연산(swap)이 많이 발생된다. (index 1칸씩 이동)

