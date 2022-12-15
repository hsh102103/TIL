package baekjoon;// Don't place your source in a package
import java.util.*;
import java.lang.*;

// Please name your class Main
class BOJ_인구이동 {
    static class Node{
        int r;
        int c;
        int point;
        public Node(int r, int c, int point){
            this.r = r;
            this.c =c ;
            this.point = point;
        }
    }
    static int N, L, R;
    static int[][] map;
    static boolean[][] marked;
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        map = new int[N][N];
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                map[r][c] = sc.nextInt();
            }
        }

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                marked = new boolean[N][N];
                bfs(r,c);
            }
        }
        System.out.println(res);
    }
    static int res = 0;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static void bfs(int r, int c){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r,c,map[r][c]));
        int cnt = 1;
        int sum = q.peek().point;
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(int d=0;d<4;d++){
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];
                if(isNotRange(nr,nc)) continue;
                if(marked[nr][nc]) continue;
                if(!ConfirmToPopulationDiff(curr.point, map[nr][nc])) continue;
                marked[nr][nc] = true;
                q.add(new Node(nr,nc,map[nr][nc]));
                cnt++;
                sum += map[nr][nc];
            }
        }
        boolean flag = false;
        for(int i = 0 ; i<N;i++) {
            for(int j = 0; j<N; j++) {
                if(marked[i][j]) {
                    flag = true;
                    map[i][j] = sum/cnt;
                }
            }
        }
        if(flag) res ++;
    }
    static boolean ConfirmToPopulationDiff(int curr, int next){
        int diff = (int)Math.abs(curr-next);
        return L <= diff && diff <= R;
    }
    static boolean isNotRange(int r, int c){
        return r<0 || c<0|| r>=N || c>=N;
    }
}