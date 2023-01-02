package baekjoon;

import java.util.Scanner;

public class BOJ_AB {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int res = 1;
        while(A!=B && B>A){
            if(B%2==0){
                B /= 2;
                res++;
            }else if(B%10 == 1){
                B /= 10;
                res++;
            }else{
                break;
            }
        }

        if(B!=A) res = -1;
        System.out.println(res);
    }
}
