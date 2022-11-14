package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

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
    static boolean[][] marked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // map 배열 선언 및 초기화
        map = new char[N][M];
        marked = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            String s = br.readLine();
            for (int c = 0; c < M; c++) {
                char character = s.charAt(c);
                map[r][c] = character;
                // 다 만들었나 마지막에 체크하는 배열
                if (character == '*') {
                    marked[r][c] = true;
                }
            }
        }

        search();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (marked[r][c]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
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
                        // marked배열 처리
                        marked[r][c] = false;
                        changeMarked(r, c, len);
                        res++;
                        sb.append((r + 1) + " " + (c + 1) + " " + len + "\n");
                        len++;
                    }
                }
            }
        }
    } // exit search

    private static void changeMarked(int r, int c, int len) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i] * len;
            int nc = c + dc[i] * len;
            marked[nr][nc] = false;
        }
    }

    private static boolean isNotRange(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= M;
    }
}
