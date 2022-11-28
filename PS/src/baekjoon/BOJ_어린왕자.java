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
        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            Center start = new Center(sc.nextInt(), sc.nextInt());
            Center end = new Center(sc.nextInt(), sc.nextInt());

            int N = sc.nextInt();
            int res = 0;
            for (int i = 0; i < N; i++) {
                Center curr = new Center(sc.nextInt(), sc.nextInt());
                int diameter = sc.nextInt();
                if (confirmDistance(start, end, curr, diameter)) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }

    static boolean confirmDistance(Center start, Center end, Center curr, int diameter) {
        boolean flag = false;
        // 두 점 사이의 거리가 반지름보다 작으면 true
        // 밑변^2 + 높이^2
        int distanceToStart = (int)Math.sqrt(Math.pow((start.x - curr.x), 2) + Math.pow((start.y - curr.y), 2));
        int distanceToEnd = (int)Math.sqrt(Math.pow((end.x - curr.x), 2) + Math.pow((end.y - curr.y), 2));

        if(distanceToStart < diameter){
            flag = true;
        }
        if(distanceToEnd < diameter){
            if(flag){
                flag = false;
                // start, end 모두 반지름보다 작으면 false
            }else{
                flag = true;
            }
        }
        return flag;
    }
}
