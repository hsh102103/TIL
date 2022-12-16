package baekjoon;

// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class BOJ_합구하기 {
    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // dp로 풀어서 누적합 구해놓은 다음 i, j 주어질 때 PrefixSum[j] - PrefixSum[i-1]
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < dp.length; i++){
            dp[i] = dp[i-1] + Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            sb.append(dp[j] - dp[i-1]+"\n");
        }
        System.out.println(sb);
    }
}