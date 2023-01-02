package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_단어수학 {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] alphabet = new int[26];

        for(int i = 0 ; i< N; i++) {
            String s = sc.next();
            char[] cArr = s.toCharArray();
            int index = cArr.length-1;
            for(int j = 0; j < cArr.length; j++) {
                alphabet[cArr[j]-'A'] += (int)Math.pow(10, index--);
            }
        }
        Arrays.sort(alphabet);

        int value = 9;
        int sum = 0;
        for(int i =alphabet.length-1 ; i>=0; i--){
            if(alphabet[i] ==0) continue;
            sum += alphabet[i] * value--;
        }

        System.out.println(sum);
    }
}
