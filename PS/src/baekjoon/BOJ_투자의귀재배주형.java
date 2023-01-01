package baekjoon;

import java.util.*;
import java.lang.*;

public class BOJ_투자의귀재배주형 {

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int Y = sc.nextInt();

        int[] dp = new int[Y+1];
        dp[0] = H;
        for(int i = 1; i<dp.length; i++) {
            dp[i] = (int)(dp[i-1] * 1.05);
            if(i >=3 ) {
                dp[i] = Math.max(dp[i], (int)(dp[i-3] * 1.2));
            }
            if( i >= 5) {
                dp[i] = Math.max(dp[i], (int)(dp[i-5] * 1.35));
            }
        }
        System.out.println(dp[Y]);
    }
}
