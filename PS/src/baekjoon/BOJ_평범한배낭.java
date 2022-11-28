package baekjoon;

import java.util.Scanner;

public class BOJ_평범한배낭 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] items = new int[N + 1][2]; // [0]무게, [1]가치

        for (int i = 1; i < items.length; i++) {
            items[i][0] = sc.nextInt();
            items[i][1] = sc.nextInt();
        }

        int[][] dp = new int[N + 1][K + 1]; // [물건번호][무게] = 가치
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j < items[i][0]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - items[i][0]] + items[i][1]);
                }
            }
        } // exit for(i)

        System.out.println(dp[N][K]);
    }
}
