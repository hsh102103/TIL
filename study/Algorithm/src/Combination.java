import java.util.Arrays;
import java.util.Scanner;

public class Combination {
    static int N, R; // N 중에 R개 선택하여 조합
    static int[] data, sel;

    private static void comb1(int sidx, int idx) {
        if (sidx == R) {
            System.out.println(Arrays.toString(sel));
            return;
        }
        for (int i = idx; i < N; i++) {
            sel[sidx] = data[i];
            comb1(sidx + 1, i + 1);
        }
    }

    private static void comb2(int sidx, int idx) {
        if (sidx == R) {
            System.out.println(Arrays.toString(sel));
            return;
        }
        if (idx == N) {
            return;
        }
        sel[sidx] = data[idx];
        comb2(sidx + 1, idx + 1);
        comb2(sidx, idx + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = 6;
        R = 2;
        data = new int[]{1, 2, 3, 4, 5, 6};
        sel = new int[R];

        print("반복+재귀를 이용한 조합");
        comb1(0, 0);

        print("재귀를 이용한 조합");
        comb2(0, 0);
    }

    private static void print(String msg) {
        System.out.println("----------");
        System.out.println(msg);
        System.out.println("----------");

    }
}
