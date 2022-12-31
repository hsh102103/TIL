package baekjoon;

import java.util.Scanner;

public class BOJ_2차원배열의합 {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[N+1][M+1];
        for(int i = 1; i<arr.length; i++) {
            for(int j = 1; j <arr[i].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        StringBuilder sb = new StringBuilder();
        int K = sc.nextInt();
        int[][] target = new int[2][2];
        while(K-- > 0) {
            for(int i =0; i<2; i++) {
                for(int j = 0; j<2; j++) {
                    target[i][j] = sc.nextInt();
                }
            }
            int prefixSum = 0;
            for(int i = target[0][0]; i <= target[1][0]; i++ ) {
                for(int j = target[0][1]; j <= target[1][1]; j++) {
                    prefixSum += arr[i][j];
                }
            }
            sb.append(prefixSum+"\n");
        }
        System.out.println(sb);


    }
}
