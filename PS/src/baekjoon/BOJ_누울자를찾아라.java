package baekjoon;

import java.util.Scanner;

public class BOJ_누울자를찾아라 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] answer = new int[2];
        int N = sc.nextInt();
        char[][] map = new char[N][N];
        for (int r = 0; r < N; r++) {
            String s = sc.next();
            for (int c = 0; c < N; c++) {
                map[r][c] = s.charAt(c);
            }
        }

        // 가로 확인
        for (int r = 0; r < N; r++) {
            int cnt = 0;
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 'X') {
                    if (cnt > 1) answer[0]++;
                    cnt = 0;
                } else cnt++;
            }
            if (cnt > 1) answer[0]++;
        }

        // 세로 확인
        for (int c = 0; c < N; c++) {
            int cnt = 0;
            for (int r = 0; r < N; r++) {
                if (map[r][c] == 'X') {
                    if (cnt > 1) answer[1]++;
                    cnt = 0;
                } else cnt++;
            }
            if (cnt > 1) answer[1]++;
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
