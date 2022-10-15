package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * x에서 출발했을때 도착할 수 있는 노드 중 최소거리가 k인 노드를 찾아 출력하시오.
 * 없으면 -1 출력.
 */
public class BOJ_특정거리의도시찾기 {
    static boolean[] marked;
    static List<Integer>[] info;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        // 인접행렬 초기화
        info = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            info[i] = new ArrayList<>();
        }

        // 간선 정보 저장
        for (int i = 1; i <= M; i++) {
            String[] edge = br.readLine().split(" ");
            int start = Integer.parseInt(edge[0]);
            int end = Integer.parseInt(edge[1]);
            info[start].add(end);
        }

        // x에서 출발해서 마킹하며 거리정보 저장
        marked = new boolean[N + 1];
        result = new int[N + 1];
        bfs(x);
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < result.length; i++) {
            if (result[i] == k) {
                flag = true;
                sb.append(i).append("\n");
            }
        }
        if (!flag) System.out.println(-1);
        else System.out.println(sb);

    }

    private static void bfs(int idx) {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{idx, 0});

        while (!q.isEmpty()) {
            int node = q.peek()[0];
            int dist = q.poll()[1];

            if (marked[node]) continue;
            marked[node] = true;
            result[node] = dist;

            for (int i : info[node]) {
                if (marked[i]) continue;
                q.add(new Integer[]{i, dist + 1});
            }

        }

    }
}
