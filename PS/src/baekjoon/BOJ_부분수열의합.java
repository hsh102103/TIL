package baekjoon;

import java.util.Scanner;

/**
 * 시간복잡도: 2^N
 */
public class BOJ_부분수열의합 {
    static int N,S;
    static int res = 0;
    static int[] arr;
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();

        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        comb(0,0);
        if(S == 0) res--;
        System.out.println(res);
    }
    static void comb(int idx, int sum) {
        if(idx == N) {
            if(S == sum) res++;
            return;
        }
        comb(idx+1,sum);
        comb(idx+1,sum+arr[idx]);
    }
}
