package baekjoon;

import java.util.Scanner;

public class BOJ_태상이의훈련소생활 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] result = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            result[i] = sc.nextInt();
        }

        int[] arr = new int[N + 2];
        for (int i = 0; i < M; i++) {
            int startIndex = sc.nextInt();
            int endIndex = sc.nextInt();
            int value = sc.nextInt();
            arr[startIndex] += value;
            arr[endIndex + 1] -= value;
        }

        StringBuilder sb = new StringBuilder();
        int curr = 0;
        for (int i = 1; i < N + 1; i++) {
            curr += arr[i];
            sb.append(result[i] + curr + " ");
        }
        System.out.println(sb);
    }
}
