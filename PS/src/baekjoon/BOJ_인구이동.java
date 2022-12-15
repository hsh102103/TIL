package baekjoon;
// Don't place your source in a package

import java.util.*;
import java.lang.*;

// Please name your class Main
public class BOJ_인구이동 {
    static int N, L, R;
    static int[][] map;
    static boolean[][] marked;
    static List<Node> list;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = sc.nextInt();
            }
        }
        System.out.println(move());
    }

    static int move() {
        int result = 0;
        while (true) {
            boolean isMove = false;
            marked = new boolean[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (marked[r][c]) continue;
                    int sum = bfs(r, c);
                    if (list.size() > 1) {
                        changePopulation(sum);
                        isMove = true;
                    }
                }
            }
            if (!isMove) return result;
            result++;
        }
    }

    static void changePopulation(int sum) {
        int avg = sum / list.size();
        for (Node n : list) {
            map[n.r][n.c] = avg;
        }
    }

    static int bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        list = new ArrayList<>();

        q.add(new Node(r, c, map[r][c]));
        list.add(new Node(r, c, map[r][c]));
        marked[r][c] = true;

        int sum = map[r][c];
        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];
                if (isNotRange(nr, nc)) continue;
                if (marked[nr][nc]) continue;
                if (!ConfirmToPopulationDiff(curr.point, map[nr][nc])) continue;
                marked[nr][nc] = true;
                q.add(new Node(nr, nc, map[nr][nc]));
                list.add(new Node(nr, nc, map[nr][nc]));
                sum += map[nr][nc];
            }
        }
        return sum;
    }

    static boolean ConfirmToPopulationDiff(int curr, int next) {
        int diff = Math.abs(curr - next);
        return L <= diff && diff <= R;
    }

    static boolean isNotRange(int r, int c) {
        return r < 0 || c < 0 || r >= N || c >= N;
    }

    static class Node {
        int r;
        int c;
        int point;

        public Node(int r, int c, int point) {
            this.r = r;
            this.c = c;
            this.point = point;
        }
    }
}