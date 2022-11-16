package baekjoon;

import java.util.Scanner;

/**
 * 조합으로 2개 뽑아서
 * 가로의 합, 세로의 합 만들어서 비교
 */
public class BOJ_두스티커 {
    static int H, W, N, data[][], sel[][];
    static int maxValue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        N = sc.nextInt();
        sel = new int[2][2];
        data = new int[N][2];
        for (int i = 0; i < N; i++) {
            data[i] = saveData(sc);
        }
        combination(0, 0);
        System.out.println(maxValue);
    }

    static void combination(int sidx, int idx) {
        if (sidx == sel.length) {
            int length = checkRange();
            maxValue = Math.max(maxValue, length);
            return;
        }
        for (int i = idx; i < N; i++) {
            sel[sidx] = data[i];
            combination(sidx + 1, i + 1);

        }
    }

    static int checkRange() {
        int length = 0;
        int area = sel[0][0] * sel[0][1] + sel[1][0] * sel[1][1];
        for (int i = 0; i < sel.length; i++) {
            if (sel[0][i] + sel[1][0] <= W && Math.max(sel[0][(i + 1) % 2], sel[1][1]) <= H
                    || sel[0][i] + sel[1][0] <= H && Math.max(sel[0][(i + 1) % 2], sel[1][1]) <= W) {
                length = area;
                break;
            }
            if (Math.max(sel[0][i], sel[1][0]) <= W && sel[0][(i + 1) % 2] + sel[1][1] <= H
                    || Math.max(sel[0][i], sel[1][0]) <= H && sel[0][(i + 1) % 2] + sel[1][1] <= W) {
                length = area;
                break;
            }
        }
        return length;
    }

    static int[] saveData(Scanner sc) {
        int[] data = new int[2];
        for (int i = 0; i < data.length; i++) {
            data[i] = sc.nextInt();
        }
        return data;
    }
}