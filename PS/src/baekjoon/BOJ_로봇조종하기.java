package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1초, 512MB
 * dfs 알고리즘을 사용할 경우, N과 M의 크기 제한 때문에 시간초과가 발생한다.
 * 각 지점을 기준으로 좌, 우, 상 방향 중 가치의 합이 최고인 값을 찾아야 하기때문에 0행 -> N행 방향으로 한 행씩 채우면서 확인해야한다.
 *
 * 현재 지점에서 좌, 우를 비교해서 최고가치를 찾으려고할 때 좌, 우의 최고값을 어떻게 확인할 것인지에 대한 고민이 생겼는데,
 * 추가적인 배열을 2개 사용하여 좌, 상 방향을 비교하여 최고값을 담는 배열과 우,상 방향을 비교하여 최고값을 담는 배열을 비교하여 최종적으로 값을 알 수 있었다.
 *
 */
public class BOJ_로봇조종하기 {
    static int[][] map;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][M];
        dp[0][0] = map[0][0];
        for (int c = 1; c < M; c++) { // 첫번째줄 완성
            dp[0][c] = dp[0][c-1] + map[0][c];
        }

        for (int r = 1; r < N; r++) {
            // 상, 좌 비교
            int[] temp1 = new int[M];
            temp1[0] = dp[r-1][0] + map[r][0]; // 열만 확인하는 임시 dp
            for (int c = 1; c < M; c++) {
                temp1[c] = map[r][c] + Math.max(temp1[c-1], dp[r-1][c]);
            }

            // 상, 우 비교
            int[] temp2 = new int[M];
            temp2[M-1] = dp[r-1][M-1] + map[r][M-1];
            for (int c = M-2; c >= 0; c--) {
                temp2[c] = map[r][c] + Math.max(temp2[c+1], dp[r-1][c]);
            }

            for (int i = 0; i < M; i++) {
                dp[r][i] = Math.max(temp1[i], temp2[i]);
            }
        }

        System.out.println(dp[N-1][M-1]);
    }
}
