package baekjoon;

import java.util.*;
import java.lang.*;

public class BOJ_리모컨 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if (N == 100) {
            System.out.println(0);
            return;
        }

        int M = sc.nextInt();
        boolean[] check = new boolean[1_000_000];

        boolean[] breakButton = new boolean[10];
        for (int i = 0; i < M; i++) {
            breakButton[sc.nextInt()] = true;
        }

        for (int i = 0; i < check.length; i++) {
            char[] charArr = (i + "").toCharArray();
            for (int j = 0; j < charArr.length; j++) {
                int button = charArr[j]-'0';
                if (breakButton[button]) {
                    check[i] = true;
                    break;
                }
            } // exit for(j)
        } // exit for(i)

        int res = 987_654_321;
        int numLength = 0;
        for (int i = 0; i < check.length; i++) {
            if (check[i]) continue;
            if (res > Math.abs(i - N)) {
                res = Math.abs(i - N);
                numLength = (i + "").length();
            }
        }
        System.out.println(Math.min(res + numLength, Math.abs(100 - N)));
    }
}
