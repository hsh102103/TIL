package baekjoon;
import java.util.*;

public class BOJ_최단경로 {
    static List<Node>[] graph;
    static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 노드, 간선의 갯수 입력받기
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        // 시작번호 입력 받기
        st = new StringTokenizer(sc.nextLine());
        int k = Integer.parseInt(st.nextToken());

        // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트 만들기
        graph = new List[V + 1];
        // 리스트 초기화
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // 최단 거리 테이블 최대값으로 초기화
        distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 모든 간선 정보 입력받기
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(sc.nextLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            // start노드에서 end노드에 가기 위한 가중치는 weight
            graph[start].add(new Node(end, weight));
        }
        // 시작번호에서 다익스트라 알고리즘 수행
        dijkstra(k);
        // 최단거리가 저장된 배열을 출력
        for (int i = 1; i< distance.length; i++) {
            // 처리한 적 없다면 INF 출력
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }else System.out.println(distance[i]);
        }

    }

    static private void dijkstra(int start) {
        // 힙 자료구조를 사용하기 위한 pq 선언 및 초기화
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작노드를 가중치 0으로 pq에 추가
        pq.add(new Node(start, 0));
        distance[start] = 0;
        while (!pq.isEmpty()) { // 큐가 비어있지 않다면
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            int dist = pq.peek().weight;
            int now = pq.poll().node;
            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (distance[now] < dist) continue;
            //현재 노드와 연결된 다른 인접한 노드들을 확인
            for (Node n : graph[now]) {
                int cost = dist + n.weight;
                // 저장된 거리보다 현재 노드를 거쳐서 이동하는 경우가 더 짧은 경우
                if (cost < distance[n.node]) {
                    distance[n.node] = cost;
                    pq.add(new Node(n.node, cost));
                }
            }
        }


    }

    static class Node implements Comparable<Node> {
        int node;
        int weight;

        Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
