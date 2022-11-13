package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 그래프 문제<br/>
 * 깊이가 5가 되면 1, 아니면 0을 출력<br/>
 * 경로의 특성이 중요하므로 DFS로 풀자.
 */
public class BOJ_ABCDE {
    static List<List<Integer>> adjacents;
    static boolean[] marked;
    static boolean isFriend;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 사람 수 (노드 수)
        int M = sc.nextInt(); // 친구 관계 수 (간선 수)

        // 인접 행렬
        adjacents = new ArrayList<>();

        // 리스트 초기화
        for (int i = 0; i < N; i++) {
            adjacents.add(new ArrayList<>());
        }

        // 리스트에 간선값 업데이트
        for (int i = 0; i < M; i++) {
            int friendA = sc.nextInt();
            int friendB = sc.nextInt();

            adjacents.get(friendA).add(friendB);
            adjacents.get(friendB).add(friendA);
        }

        marked = new boolean[N];
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (isFriend) break;
        }

        if (isFriend) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    static private void dfs(int idx, int depth) {
        if (depth == 5) {
            isFriend = true;
            return;
        }

        marked[idx] = true;
        for (int list :adjacents.get(idx)){
            if (isFriend) break;
            if(!marked[list]){
                dfs(list, depth+1);
            }
        }
        marked[idx] = false;

    }
}
