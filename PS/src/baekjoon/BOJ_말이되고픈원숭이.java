package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_말이되고픈원숭이 {
    static int K, W, H;
    static int[][] monkey = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] horse = {
            {-2, -1}, {-2, 1},
            {-1, 2}, {1, 2},
            {2, 1}, {2, -1},
            {1, -2}, {-1, 2}
    };
    static boolean[][] marked;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        W = sc.nextInt();
        H = sc.nextInt();

        int[][] map = new int[H][W];
        marked = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    marked[i][j] = true;
                }
            }
        }

        int res = bfs();
        System.out.println(res);

    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        marked[0][0] = true;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if(curr.col == W-1 && curr.row == H -1){
                return curr.moving;
            }
            for (int i = 0; i < horse.length; i++) {
                if(curr.cnt == K) break;
                int nr = curr.row + horse[i][0];
                int nc = curr.col + horse[i][1];
                if (isNotRange(nr, nc)) continue;
                if(marked[nr][nc]) continue;

                marked[nr][nc] = true;
                q.add(new Node(nr, nc, curr.cnt + 1, curr.moving + 1));
            }
            for (int i = 0; i < monkey.length; i++) {
                int nr = curr.row + monkey[i][0];
                int nc = curr.col + monkey[i][1];
                if (isNotRange(nr, nc)) continue;
                if(marked[nr][nc]) continue;
                marked[nr][nc] = true;
                q.add(new Node(nr, nc, curr.cnt, curr.moving + 1));
            }

        }
        return -1;
    }

    static boolean isNotRange(int r, int c) {
        return r < 0 || c < 0 || r >= H || c >= W;
    }

    static class Node {
        int row;
        int col;
        int cnt;
        int moving;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
        public Node(int row, int col, int cnt, int moving) {
            this.row = row;
            this.col = col;
            this.moving = moving;
            this.cnt = cnt;
        }
    }
}
