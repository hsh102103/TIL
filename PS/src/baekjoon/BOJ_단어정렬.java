package baekjoon;

import java.util.*;
import java.lang.*;

public class BOJ_단어정렬 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }else{
                    return o1.length() - o2.length();
                }
            }
        });
        System.out.println(arr[0]);
        for (int i = 1; i < N; i++) {
            if(arr[i].equals(arr[i-1])) continue;
            System.out.println(arr[i]);
        }
    }
}
