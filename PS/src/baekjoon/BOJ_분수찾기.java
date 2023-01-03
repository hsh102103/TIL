package baekjoon;

import java.util.*;

public class BOJ_분수찾기 {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        /*
        N*(N+1)/2 = 10_000_000
        N^2+N = 20_000_000
        N이 최대 4472
        */
        int[] arr = new int[4473];
        
        int plus =1;
        arr[1] = 1;
        for(int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-1] + ++plus;
        }
        
        int idx = 0;
        for(int i=1; i<arr.length; i++) {
            if(N <= arr[i]){
                idx = i;
                break;
            }
        }
        
        int top = 0;
        int bottom = 0;
        int move = N - (arr[idx-1]+1);
        // idx % 2 == 0 이면 아래방향, else면 위방향
        if(idx%2==0) {
            top = 1 + move;
            bottom = idx - move;
        }else {
            top = idx - move;
            bottom = 1 + move;
        }
        System.out.println(top+"/"+bottom);
	}
}