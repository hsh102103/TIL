package baekjoon;

import java.util.*;

class BOJ_양한마리양두마리 {
    static class Node{
        int r;
        int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static boolean[][] map;
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            H = sc.nextInt();
            W = sc.nextInt();

            map = new boolean[H][W];
            for(int i =0; i<H; i++){
                String s = sc.next();
                for(int j = 0; j < W; j++){
                    char c = s.charAt(j);
                    if(c == '.'){
                        map[i][j] = true;
                    }
                }
            }
            int res=0;
            for(int i = 0; i < H; i++){
                for(int j = 0 ; j < W; j ++){
                    if(!map[i][j]){
                        res++;
                        bfs(i,j);
                    }
                }
            }
            sb.append(res+"\n");
        }

        System.out.println(sb);
    }
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static void bfs(int r, int c){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        map[r][c] = true;
        while(!q.isEmpty()) {
            Node curr = q.poll();
            for(int i = 0 ; i < 4; i++){
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];
                if(isNotRange(nr,nc)) continue;
                if(map[nr][nc]) continue;
                map[nr][nc] = true;
                q.add(new Node(nr, nc));

            }
        }
    }
    static int H,W;
    static boolean isNotRange(int r, int c) {
        return r <0 || c<0 || r>=H || c >=W;
    }
}

















