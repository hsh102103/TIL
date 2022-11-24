package baekjoon;

import java.util.*;

public class BOJ_배열합치기 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        for (int i = 0; i < N; i++) {
            pq.add(sc.nextInt());
        }

        for (int i = 0; i < M; i++) {
            pq.add(sc.nextInt());
        }
        int tmp = pq.size();
        for (int i = 0; i < tmp; i++) {
            System.out.print(pq.poll()+" ");
        }

    }
}
