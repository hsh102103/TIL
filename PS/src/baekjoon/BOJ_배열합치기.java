package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_배열합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[N];
        int[] arr2 = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb =new StringBuilder();

        int pointer1 = 0;
        int pointer2 = 0;
        for (int i = 0; i < N+M; i++) {
            if (pointer1 >= arr1.length) {
                sb.append(arr2[pointer2]+" ");
                pointer2++;
                continue;
            }if (pointer2 >= arr2.length) {
                sb.append(arr1[pointer1]+" ");
                pointer1++;
                continue;
            }
            if (arr1[pointer1] < arr2[pointer2]) {
                sb.append(arr1[pointer1]+" ");
                pointer1++;
                continue;
            }
            if (arr1[pointer1] >= arr2[pointer2]) {
                sb.append(arr2[pointer2]+" ");
                pointer2++;
                continue;
            }
        }
            System.out.println(sb);
    }
}
