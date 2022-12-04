package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_스타트링크 {
    static int F, S, G, U, D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        int res = bfs(S);
        if (res == Integer.MAX_VALUE) {
            System.out.println("use the stairs");
        } else {
            System.out.println(res);
        }
    }

    private static int bfs(int S) {
        int res = Integer.MAX_VALUE;
        Queue<Node> q = new LinkedList<>();
        boolean[] marked = new boolean[F + 1];
        q.add(new Node(S, 0));
        marked[S] = true;


        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.floor == G){
                res = curr.cnt;
                break;
            }

            if (isRange(curr.floor + U) && !marked[curr.floor + U]) {
                marked[curr.floor+U] = true;
                q.add(new Node(curr.floor + U, curr.cnt+1));
            }
            if (isRange(curr.floor - D) && !marked[curr.floor - D]) {
                marked[curr.floor-D] = true;
                q.add(new Node(curr.floor - D, curr.cnt + 1));
            }
        }
        return res;
    }

    static boolean isRange(int curr) {
        return curr > 0 && curr <= F;
    }

    private static class Node {
        int floor;
        int cnt;

        public Node(int floor, int cnt) {
            this.floor = floor;
            this.cnt = cnt;
        }
    }
}
