package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_나3곱2 {
    static long[] data, sel;
    static int N;
    static boolean[] marked;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sel = new long[N];
        data = new long[N];
        for (int i = 0; i < N; i++) {
            data[i] = sc.nextLong();
        }

        marked = new boolean[N];
        permutation(0);

    }

    static void permutation(int cnt) {
        if (cnt == N) {
            System.out.println(Arrays.toString(sel));
            return;
        }
        for (int i = 0; i < N; i++) {
            if (marked[i]) continue;
            if (cnt != 0) {
                if (sel[cnt - 1] * 2 != data[i] && (sel[cnt - 1] / 3 != data[i] || sel[cnt - 1] % 3 != 0)) {
                    continue;
                }
            }
            marked[i] = true;
            sel[cnt] = data[i];
            permutation(cnt + 1);
            marked[i] = false;
        }

    }
}
