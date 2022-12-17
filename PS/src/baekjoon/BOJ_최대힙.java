package baekjoon;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_최대힙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int X = sc.nextInt();

            if (X == 0) {
                if (pq.size() > 0) {
                    sb.append(pq.poll() + "\n");
                    continue;
                }
                sb.append(0 + "\n");
            }
            pq.add(X);
        }
        System.out.println(sb);
    }
}
