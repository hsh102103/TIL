package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 문제난이도 합이 L보다 크거나 같고, R보다 작거나 같아야한다.
 * 가장 어려운 문제와 가장 쉬운 문제의 난이도 차이는 X보다 크거나 가타야한다.
 * 부분 순열
 */
public class BOJ_캠프준비 {
    static List<Integer> list = new ArrayList<>();
    static int[] data;
static int N,L,R,X;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        X = sc.nextInt();

        data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = sc.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            comb(0, 0, i);

        }
        System.out.println(res);
    }

    static void comb(int sidx, int idx, int R) {
        if (sidx == R) {
            check();
            return;
        }

        for (int i = idx; i < data.length; i++) {
            list.add(data[i]);
            comb(sidx + 1, i + 1,R);
            list.remove(list.size() - 1);
        }
    }

    static void check() {
        int min = 9999999;
        int max = -9999999;
        int sum = 0;
        for (Integer in : list) {
            if (min > in) min = in;
            if (max < in) max = in;
            sum += in;
        }
        if (sum >= L && sum <= R) {
            if (max - min >= X) {
                res ++;
            }
        }
    }
    static int res;
}
