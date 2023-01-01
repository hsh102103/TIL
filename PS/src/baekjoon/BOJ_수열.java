package baekjoon;

import java.util.Scanner;

/**
 * N(전체 날짜의 수)과 K(연속된 날짜의 수)가 주어질 때, 
 */
public class BOJ_수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solve(arr));
    }

    static int N, K;
    static int solve(int[] arr) {
        int sum = 0;

        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        int temp = sum;
        for (int i = K; i < N; i++) {
            temp = temp - arr[i - K] + arr[i];
            sum = Math.max(sum, temp);
        }
        return sum;
    }
}