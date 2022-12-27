package baekjoon;

import java.util.Scanner;

// bruteforce로 찾자.

public class BOJ_큰수구성하기 {
    static int[] data;
    static int len, res, N, M;

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        data = new int[M];
        for (int i = 0; i < data.length; i++) {
            data[i] = sc.nextInt();
        }

        len = (N + "").length();
        duplecatePermutation(0, 0);

        System.out.println(res);
    }

    static void duplecatePermutation(int idx, int sum) {
        if (sum <= N && res < sum) res = sum;
        if (idx == len) return;

        for (int i = 0; i < M; i++) {
            duplecatePermutation(idx + 1, sum * 10 + data[i]);
        }
    }
}

