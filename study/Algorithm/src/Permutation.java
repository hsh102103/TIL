import java.util.Arrays;

public class Permutation {
    static boolean[] marked;
    static int[] select, data;
    static int N, R; // N개 중에 R개 선택

    /**
     * 하나뽑기, 방문처리
     */
    private static void perm1(int cnt) {
        if (cnt == R) {
            System.out.println(Arrays.toString(select));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (marked[i]) continue;
            select[cnt] = data[i];
            marked[i] = true;
            perm1(cnt + 1);
            marked[i] = false;
        }

    }

    private static void perm2(int sidx, int visited) {
        if (sidx == R) {
            System.out.println(Arrays.toString(select));
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((visited & 1 << i) > 0) continue;
            select[sidx] = data[i];
            perm2(sidx + 1, visited | 1 << i);
        }
    }

    public static void main(String[] args) {
        data = new int[]{1, 2, 3, 4};

        N = data.length;
        R = 2;

        marked = new boolean[N];
        select = new int[R];

        System.out.println("방문처리를 이용한 순열");
        perm1(0);
        System.out.println("----------");
        System.out.println("방문처리 비트마스킹 순열");
        perm2(0, 0);
        System.out.println("----------");


    }


}
