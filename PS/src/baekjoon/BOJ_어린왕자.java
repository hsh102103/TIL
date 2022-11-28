package baekjoon;

import java.util.Scanner;

public class BOJ_어린왕자 {
    static class Center {
        int x;
        int y;

        public Center(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            Center start = new Center(sc.nextInt(), sc.nextInt());
            Center end = new Center(sc.nextInt(), sc.nextInt());

            int N = sc.nextInt();
            int res = 0;
            for (int i = 0; i < N; i++) {
                Center curr = new Center(sc.nextInt(), sc.nextInt());
                int diameter = sc.nextInt();
                if (confirmDistance(start, end, curr, diameter) == 1) {
                    res++;
                }
            }
            sb.append(res+"\n");
        }
        System.out.println(sb);
    }

    static int getDistance(Center circle1, Center circle2) {
        return (int)Math.sqrt(Math.pow((circle1.x - circle2.x), 2) + Math.pow((circle1.y - circle2.y), 2));
    }
    static int confirmDistance(Center start, Center end, Center curr, int diameter) {
        // 밑변^2 + 높이^2
        int distanceToStart = getDistance(start, curr);
        int distanceToEnd = getDistance(end, curr);

        // 두 점 사이의 거리가 반지름보다 작으면 cnt++;
        int cnt = 0;
        if(distanceToStart < diameter){
            cnt++;
        }
        if(distanceToEnd < diameter){
            cnt++;
        }
        return cnt;
    }
}
