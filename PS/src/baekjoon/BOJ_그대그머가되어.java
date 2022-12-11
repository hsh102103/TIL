package baekjoon;

import java.util.*;

public class BOJ_그대그머가되어 {

    static class Node{
        int next;
        int cnt;
        public Node(int next, int cnt) {
            this.next = next;
            this.cnt = cnt;
        }
    }

    static List<Node>[] graph;
    static int A, B, N, M;
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();

        N = sc.nextInt();
        M = sc.nextInt();
        if(A==B){
            System.out.println(0);
            return;
        }

        graph = new List[N+1];
        for(int i = 1; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            int str = sc.nextInt();
            int end = sc.nextInt();

            graph[str].add(new Node(end, 1));
            graph[end].add(new Node(str, 1));
        }
        int res = bfs(A);
        System.out.println(res);
    }
    static int bfs(int A){
        Queue<Node> q = new LinkedList<>();
        for(Node n : graph[A]) {
            q.add(n);
        }

        boolean[] marked = new boolean[N+1];
        marked[A] = true;

        while(!q.isEmpty()){
            Node curr = q.poll();

            if(curr.next == B){
                return curr.cnt;
            }
            if(marked[curr.next]) continue;
            marked[curr.next] = true;
            for(Node n : graph[curr.next]) {
                q.add(new Node(n.next, curr.cnt+1));
            }
        }

        return -1;
    }
}
