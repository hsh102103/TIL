package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 완전탐색 문제
 * (1,1)부터 (N-2,M-2)까지 *있으면(중심) 사방탐색하고 모두 *이면
 * res++, StringBuilder에 위치와 크기 저장
 */
public class BOJ_십자가찾기 {
    static int res, N, M;
    static char[][] map;
    static StringBuilder sb = new StringBuilder();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        // map 배열 선언 및 초기화
        map = new char[N][M];
        for (int r = 0; r < N; r++) {
            String s = sc.nextLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = s.charAt(c);
            }
        }

        search();
        System.out.println(res);
        System.out.println(sb);
    }

    private static void search() {
        for (int r = 1; r < N - 1; r++) {
            for (int c = 1; c < M - 1; c++) {
                // 중심 찾기
                if (map[r][c] == '*') {
                    int len = 1;
                    outer:
                    while (true) {
                        for (int i = 0; i < 4; i++) {
                            int nr = dr[i] * len + r;
                            int nc = dc[i] * len + c;
                            if (isNotRange(nr, nc)) break outer;
                            if (map[nr][nc] != '*') break outer;
                        }
                        // 사방이 *인 경우
                        res++;
                        sb.append((r + 1) + " " + (c + 1) + " " + len + "\n");
                        len++;
                    }
                }
            }
        }
    } // exit search

    private static boolean isNotRange(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= M;
    }
}
