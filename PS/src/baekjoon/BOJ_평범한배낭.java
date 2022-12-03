package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 0-1 Knapsack problem. <br>
 * N개의 물건이 각각 무게(W)와 가치(V)를 가질 때,
 * 최대 무게 K를 넘지않는 선에서 넣을 수 있는 가치의 최대값을 구하는 문제.
 */
public class BOJ_평범한배낭 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        arr = new Object[N];
        for (int i = 0; i < arr.length; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();
            arr[i] = new Object(weight, value);
        }
        dfs(K, 0,0,0);
        System.out.println(res);
    }
    static int res;
    static Object[] arr;

    static void dfs(int K, int depth, int weight, int value) {
        if (depth == arr.length) {
            res = Math.max(res, value);
            return;
        }
        if (weight + arr[depth].weight <= K) {
            dfs(K, depth + 1, weight + arr[depth].weight, value + arr[depth].value);
        }
        if (weight <= K) {
            dfs(K, depth+1, weight, value);
        }
    }

    static class Object {
        int weight;
        int value;

        public Object(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
