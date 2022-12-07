package softeer;

import java.util.Arrays;
import java.util.Scanner;

public class Softeer_슈퍼컴퓨터클러스터 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long B = sc.nextLong();

        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        long ans = binarySearch(arr, B);
        System.out.println(ans);
    }

    static long binarySearch(int[] arr, long B) {
        long ans = 0;
        long left = arr[0];
        long right = arr[arr.length - 1] + (long) Math.sqrt(B);
        long mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (calulator(mid, arr, B)) {
                left = mid +1;
                ans = mid;
            }else{
                right = mid -1;
            }
        }
        return ans;
    }

    static boolean calulator(long mid, int[] arr, long B) {
        long cost = 0;
        for (int i : arr) {
            if (i < mid) {
                cost += (mid - i) * (mid - i);
                if(cost > B) return false;
            }
        }
        return true;
    }
}