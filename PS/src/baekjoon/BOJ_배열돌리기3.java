package baekjoon;

import java.util.Scanner;

public class BOJ_배열돌리기3 {
    static int[][] arr;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        int R = sc.nextInt();

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        while (R-- > 0) {
            switch (sc.nextInt()) {
                case 1:
                    type1();
                    continue;
                case 2:
                    type2();
                    continue;
                case 3:
                    type3();
                    continue;
                case 4:
                    type4();
                    continue;
                case 5:
                    type5();
                    continue;
                case 6:
                    type6();
                    continue;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void type1() {
        int[] tmp;

        for (int i = 0; i < N / 2; i++) {
            tmp = arr[i];
            arr[i] = arr[N - i - 1];
            arr[N - i - 1] = tmp;
        }
    }

    public static void type2() {
        int tmp;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                tmp = arr[i][j];
                arr[i][j] = arr[i][M - j - 1];
                arr[i][M - j - 1] = tmp;
            }
        }
    }

    public static void type3() {
        int[][] transArr = new int[M][N];
        int C = N-1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                transArr[j][C] = arr[i][j];
            }
            C--;
        }
        int tmp = N;
        N = M;
        M = tmp;

        arr = transArr;
    }

    public static void type4() {
        int[][] transArr = new int[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                transArr[M-j-1][i] = arr[i][j];
            }
        }
        int tmp = N;
        N = M;
        M = tmp;

        arr = transArr;
    }

    public static void type5() {
        int[][] transArr = new int[N][M];
        int N_mid = N/2;
        int M_mid = M/2;

        // 1 -> 2
        for (int i = 0; i < N_mid; i++) {
            for (int j = 0; j < M_mid; j++) {
                transArr[i][j+M_mid] = arr[i][j];
            }
        }
        // 2 -> 3
        for (int i = 0; i < N_mid; i++) {
            for (int j = M_mid; j < M; j++) {
                transArr[i+N_mid][j] = arr[i][j];
            }
        }
        // 3 -> 4
        for (int i = N_mid; i < N; i++) {
            for (int j = M_mid; j < M; j++) {
                transArr[i][j-M_mid] = arr[i][j];
            }
        }
        // 4 -> 1
        for (int i = N_mid; i < N; i++) {
            for (int j = 0; j < M_mid; j++) {
                transArr[i-N_mid][j] = arr[i][j];
            }
        }
        arr = transArr;
    }
    public static void type6() {
        int[][] transArr = new int[N][M];

        int N_mid = N/2;
        int M_mid = M/2;

        // 1 -> 4
        for (int i = 0; i < N_mid; i++) {
            for (int j = 0; j < M_mid; j++) {
                transArr[i+N_mid][j] = arr[i][j];
            }
        }
        // 4 -> 3
        for (int i = N_mid; i < N; i++) {
            for (int j = 0; j < M_mid; j++) {
                transArr[i][j+M_mid] = arr[i][j];
            }
        }
        // 3 -> 2
        for (int i = N_mid; i < N; i++) {
            for (int j = M_mid; j < M; j++) {
                transArr[i-N_mid][j] = arr[i][j];
            }
        }
        // 2 -> 1
        for (int i = 0; i < N_mid; i++) {
            for (int j = M_mid; j < M; j++) {
                transArr[i][j-M_mid] = arr[i][j];
            }
        }
        arr = transArr;
    }
}
