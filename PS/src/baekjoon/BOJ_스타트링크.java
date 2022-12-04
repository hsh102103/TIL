package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_스타트링크 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        arr = new int[F+1];
        Arrays.fill(arr, -1);
        bfs(S);
        if (arr[G] == -1) {
            System.out.println("use the stairs");
        }else {
            System.out.println(arr[G]);
        }
    }
    static int F,S,G,U,D;
    static int[] arr;
    private static void bfs(int S) {
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        arr[S] = 0;
        while (!q.isEmpty()) {
            if(arr[G] != -1) break;
            Integer curr = q.poll();
            if(arr[curr] == -1) continue;
            if(isRange(curr+U) && (arr[curr+U] == -1 ||arr[curr+U] > arr[curr]+1)) {
                arr[curr + U] = arr[curr] + 1;
                q.add(curr+U);
            }
            if(isRange(curr-D) && (arr[curr-D] == -1 ||arr[curr-D] > arr[curr]+1)) {
                arr[curr - D] = arr[curr] + 1;
                q.add(curr-D);
            }

        }
    }

    static boolean isRange(int curr) {
        return curr>0 && curr <=F;
    }
}
