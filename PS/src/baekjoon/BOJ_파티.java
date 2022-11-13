package baekjoon;

import java.util.*;

/**
 * N(노드 수), M(간선 수), X(도착점) <br/>
 * N명의 학생들 중 오고 가는데 가장 많은 시간을 소비하는 학생은 누구일지 구하여라.
 * 단방향 간선의 정보와 가중치가 주어질 때, 각 노드에서 X에 도착하기 위해 필요한 값이 가장 큰 노드를 구하는 문제
 * dijkstra algorithm 사용하자.
 */
public class BOJ_파티 {
    public static void main(String[] args) {
        // 입력받기
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int X = sc.nextInt();

        final int INF = Integer.MAX_VALUE;
        // 간선 정보를 저장할 리스트 선언
        graph = new List[V+1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // 최단거리를 저장하는 테이블(distances)을 만들고, 최대값으로 초기화
        distances = new int[V+1][V+1];
        for (int i = 1; i < V+1; i++) {
            for (int j = 1; j < V+1; j++) {
                distances[i][j] = INF;
            }
        }
        // 간선 정보 입력받기
        for (int i = 0; i < E; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            graph[start].add(new Node(end,weight));
        }
        for (int i = 1; i <= V; i++) {
            dijkstra(i);
        }

        int answer = 0;
        for (int i = 1; i <= V; i++) {
            answer = Math.max(answer, distances[i][X] + distances[X][i]);
        }
        System.out.println(answer);
    }
    static int[][] distances;
    static List<Node>[] graph;
    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start));
        distances[start][start] = 0;
        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int dist = pq.poll().dist;
            if(distances[start][node] < dist) continue;
            for(Node n : graph[node]){
                int cost = dist+n.dist;
                if(cost < distances[start][n.node]){
                    distances[start][n.node] = cost;
                    pq.add(new Node(n.node, cost));
                }
            }
        }

    }

    private static class Node implements Comparator<Node> {
        int node;
        int dist;
        Node(int node){
            this(node,0);
        }
        Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compare(Node o1, Node o2) {
            return 0;
        }
    }
}
