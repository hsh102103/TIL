package baekjoon;

import java.util.Scanner;

public class BOJ_문어숫자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = "-\\(@?>&%";

        StringBuilder sb = new StringBuilder();
        while(true){
            String input = sc.next();
            if(input.equals("#")) break;

            int ans =0;
            for(int i=0; i<input.length(); i++) {
                char c = input.charAt(i);
                ans += s.indexOf(c)* (int)Math.pow(8, input.length()-1-i);
            }
            sb.append(ans+"\n");
        } // exit while()

        System.out.print(sb);
    }
}
