package baekjoon;

import java.util.*;

public class BOJ_숨바꼭질3 {
    static int[] distances;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 누나의 위치를 입력받음
        int K = sc.nextInt(); // 동생의 위치를 입력받음

        // 최단거리를 저장할 배열 선언, 최대거리로 초기화
        distances = new int[100_001];
        Arrays.fill(distances, Integer.MAX_VALUE);

        dijkstra(N, K);
        System.out.println(distances[K]);

    }
    private static void dijkstra(int start, int end) {
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        distances[start] = 0;

        while (!q.isEmpty()) {
            int node = q.peek().node;
            int weight = q.poll().weight;
            // 목표에 도착하면 반복문을 빠져나감.
            if (node == end) break;

            if (distances[node] < weight) continue;
            if (node * 2 <= 100_000 && distances[node * 2] >  weight) {
                q.add(new Node(node * 2, 0 + weight));
                distances[node * 2] = 0 + weight;
            }
            if (node + 1 <= 100_000 && distances[node + 1] > 1+ weight) {
                q.add(new Node(node + 1, 1 + weight));
                distances[node + 1] = 1 + weight;
            }
            if (node - 1 >= 0 && distances[node - 1] > 1+ weight) {
                q.add(new Node(node - 1, 1 + weight));
                distances[node - 1] = 1 + weight;
            }
        }

    }
    private static class Node implements Comparable<Node> {
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}