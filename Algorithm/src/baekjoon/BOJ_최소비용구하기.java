package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 시작노드에서 목표노드로 이동할때 최소비용을 구하는 문제.<br/>
 * 가중치를 가지고 있는 간선을 이동하며 최소비용을 구한다(dijstra)<br/>
 * 메모리초과를 겪었는데, 입력을 Scanner에서 BufferedReader로 변경해서 해결했다.
 *
 */
public class BOJ_최소비용구하기 {
    private static final int MAX = 1000000000;
    static List<Node>[] graph;
    static int[] distances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int V = Integer.parseInt(br.readLine()); // 노드 갯수
        int E = Integer.parseInt(br.readLine()); // 간선 갯수
        // 그래프정보를 담을 리스트
        graph = new List[V + 1];

        // 간선 정보 리스트에 추가
        for (int i = 0; i < E; i++) {
            // 입력 스플릿
            String[] str = br.readLine().split(" ");
            int from = Integer.parseInt(str[0]);
            int to = Integer.parseInt(str[1]);
            int weight = Integer.parseInt(str[2]);

            if(graph[from] == null) graph[from] = new ArrayList<>();
            // 연결 추가
            graph[from].add(new Node(to, weight));
        }
        // 출발노드, 도착노드 변수에 저장
        String[] nodeInfo = br.readLine().split(" ");
        int startIdx = Integer.parseInt(nodeInfo[0]);
        int endIdx = Integer.parseInt(nodeInfo[1]);

        // 최소거리를 저장한 배열 distances 최대값으로 초기화
        distances = new int[V + 1];
        Arrays.fill(distances, MAX);

        dijkstra(startIdx);
        bw.write(String.valueOf(distances[endIdx]));
        bw.close();
        br.close();
    }

    private static void dijkstra(int startIdx) {
        // 힙 자료구조를 사용하기 위한 pq 선언 및 초기화
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 출발노드 pq에 추가
        pq.add(new Node(startIdx, 0));

        // pq 비울때까지 반복
        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int weight = pq.poll().weight;

            if(distances[node] < weight) continue;
            if(graph[node] == null) continue;
            for (Node n : graph[node]) {
                int cost = n.weight + weight;
                if (cost < distances[n.node]) {
                    distances[n.node] = cost;
                    pq.add(new Node(n.node, cost));
                }
            }

        }

    }

    static class Node implements Comparable<Node> {
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        // 가중치 오름차순 정렬
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
