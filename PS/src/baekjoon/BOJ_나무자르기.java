package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_나무자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans += sc.nextInt();
        }
        long[] growTree = new long[N];
        for (int i = 0; i < N; i++) {
            growTree[i] = sc.nextInt();
        }
        Arrays.sort(growTree);

        for (int i = 0; i < N; i++) {
            ans += growTree[i]*i;
        }
        System.out.println(ans);
    }
}
