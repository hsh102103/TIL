package baekjoon;

import java.util.Scanner;

/**
 * 입력범위 String, int 순으로
 * A 입력 split해서 int로 배열에 넣기
 * permutation 해서 B보다 작은 가장 큰값 저장
 * 다 담으면 합쳐서 숫자로 만들고 비교
 * 인자로 가지고 원래값*10+arr[i]
 */
public class BOJ_숫자재배치 {
    static int[] arr;
    static int B;
    static int output = -1;
    static boolean[] marked;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        B = sc.nextInt();

        marked = new boolean[A.length()];
        arr = new int[A.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = A.charAt(i) - '0';
        }

        permutation(0, 0);
        System.out.println(output);
    }

    static void permutation(int cnt, int res) {
        if (cnt == arr.length) {
            if (res < B) {
                output = Math.max(output, res);
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (marked[i]) continue;
            if(cnt == 0 && arr[i] == 0) continue;
            marked[i] = true;

            permutation(cnt + 1, res * 10 + arr[i]);
            marked[i] = false;
        }
    }
}
