package baekjoon;

import java.util.Scanner;

public class BOJ_UCPC는무엇의약자일까 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        char[] arr = new char[]{'U', 'C', 'P', 'C'};
        int idx = 0;
        for (char c : s.toCharArray()) {
            if(c==arr[idx]) {
                idx++;
            }
            if(idx==4) break;
        }
        if(idx == 4 ){
            System.out.println("I love UCPC");
        }else{
            System.out.println("I hate UCPC");
        }

    }
}
