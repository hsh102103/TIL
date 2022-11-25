package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int M = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(arr, sc.nextInt()) +"\n");
        }
        System.out.println(sb);
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        int mid;

        while (left <= right) {
            mid =(left + right) / 2;
            if(arr[mid] < target){
                left = mid+1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            }else
                return 1;
        }
        return 0;
    }
}
