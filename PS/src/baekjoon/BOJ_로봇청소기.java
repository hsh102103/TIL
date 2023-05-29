package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_로봇청소기 {
    static class Pos{
        int r;
        int c;
        int dir;

        public Pos(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int N,M;
    static int answer =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int strR = Integer.parseInt(st.nextToken());
        int strC = Integer.parseInt(st.nextToken());
        int strDir = Integer.parseInt(st.nextToken());

        marked = new boolean[N][M];
        board = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        if(board[strR][strC] == 0){
            marked[strR][strC] = true;
        }
        search(strR, strC, strDir);

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (marked[i][j]) answer++;
            }
        }
        System.out.println(answer);

    }
    static int[][] board;
    static boolean[][] marked;
    static void search(int strR, int strC, int strDir) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(strR, strC, strDir));

        while(!q.isEmpty()) {
            Pos cur = q.poll();
            // 주변 확인
            if (areSurroundDirty(cur.r, cur.c)) {
                while (true) {
                    // 반시계방향 90도 회전
                    int newDir = rotDir(cur.dir);
                    // 앞칸 확인
                    int nr = cur.r + dr[newDir];
                    int nc = cur.c + dc[newDir];
                    // 앞이 더럽다면 전진
                    if (isFrontDirty(nr, nc, newDir)) {
                        marked[nr][nc] = true;
                        q.add(new Pos(nr, nc, newDir));
                        break;
                    }
                    cur.dir = newDir;
                }
            } else { // 사방에 더러운 구역이 없다면
                int newDir = cur.dir - 2;
                if (newDir < 0) newDir += 4;
                int nr = cur.r + dr[newDir];
                int nc = cur.c + dc[newDir];
                if (isPossibleRearguard(nr, nc, newDir)) {
                    q.add(new Pos(nr, nc, cur.dir));
                } else{
                    // 뒤로 이동 못하면 탈출
                    break;
                }
            }
        }
    }

    static boolean isPossibleRearguard(int r, int c, int dir) {
        return board[r][c] != 1;
    }

    static boolean isFrontDirty(int r, int c, int dir) {
        return !marked[r][c] && board[r][c] != 1;
    }

    static int rotDir(int dir) {
        int newDir = dir-1;
        if (newDir < 0) {
            newDir = 3;
        }
        return newDir;
    }

    static boolean areSurroundDirty(int r, int c) {
        for (int d = 0; d < 4; d++) {
            int nr = r+ dr[d];
            int nc = c+ dc[d];

            if(!marked[nr][nc] && board[nr][nc] != 1){
                return true;
            }
        }

        return false;
    }
}
