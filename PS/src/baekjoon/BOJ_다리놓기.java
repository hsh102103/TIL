package baekjoon;


// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
public class BOJ_다리놓기 {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[31][31];

        for(int i=1;i<31;i++){
            dp[i][i] = 1;
        }

        for(int i = 1; i< 31; i++) {
            for(int j = i+1; j<31; j++) {
                if(i==1) {
                    dp[i][j] = j;
                    continue;
                }
                dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
            }
        }

        while(T-->0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            sb.append(dp[N][M]+"\n");
        }

        System.out.println(sb);
    }
}
