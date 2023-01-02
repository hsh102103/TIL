# 그리디 알고리즘
**현재 상황에서 가장 좋아 보이는 것만을 선택하는 알고리즘**  
그리디 알고리즘 유형은 창의력, 문제를 풀기 위한 최소한의 아이디어를 떠올릴 수 있는 능력을 요구한다.

Greedy(탐욕스러운)는 **현재상황에서 지금 당장 좋은 것만 고르는 방법**이라는 의미이다.  
즉, 여러 경우 중 하나를 결정해야 할 때마다 
최적이라고 생각되는 것을 선택해 나가는 방식으로 진행하여 최종적인 해답에 도달하는 방식이다.
따라서, 매 순간 가장 좋아보이는 것을 선택하며, 현재의 선택이 나중에 미칠 영향에 대해서는 고려하지 않는다.

### 사용 시기  
보통 greedy choice property와 optimal substructure property를 만족할 때 사용하는 것이 좋다.  
`greedy choice property(탐욕적 선택 속성)`: 전의 선택이 후의 선택에 영향을 주지 않는다.  
`optimal substructure property(최적 부분 구조 속성)`: 문제에 대한 최종 해결 방법은 부분 문제에 대한 최적 문제 해결 방법으로 구성된다.

### 적용 방식
1. `선택 절차(Selection Procedure)`: 현재 상태에서의 최적의 해답을 선택한다.
2. `적절성 검사(Feasibility Check)`: 선택된 해가 문제의 조건을 만족하는지 검사한다.
3. `해답 검사(Solution Check)`: 원래의 문제가 해결되었는지 검사하고, 해결되지 않았다면 선택 절차로 돌아가 위의 과정을 반복한다.

### 대표적인 문제
- Fractional Knapsack Problem(분할 가능한 배낭 채우기 문제)
- Coin Exchange Problem(동전 교환 문제)
  - 동전의 액면가가 커지면서 바로 아래 단위의 액면가의 배수로 구성되어야만 Greedy한 방법으로 최적해를 도출할 수 있다.
    500원, 400원, 100원, 75원과 같이 배수 관계가 보이지 않는 경우, Optimal Substructure를 보이고 있어, DP 기법을 적용하여 계산해내야 한다.
- Meeting Room Scheduling Problem(회의실 배정 문제)
### 응용
- Minimum Spanning Tree (최소 신장 트리)
  - Prim's Algorithm(프림 알고리즘)
  - Kruskal's Algorithm(크루스칼 알고리즘)
- Dijkstra's Shortest Path Algorithm(다익스트라 최단 경로 알고리즘)
- Huffman Coding Algorithm(허프만 암호화 알고리즘)
- A* Algorithm(A* 알고리즘)

## Reference
https://hanamon.kr/알고리즘-탐욕알고리즘-greedy-algorithm/  
https://dad-rock.tistory.com/663