package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_123더하기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<String>[] list = new List[11];

        int targetPosition = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            list[i] = new ArrayList<>();
        }
        list[1].add("1");
        list[2].add("1+1"); list[2].add("2");
        list[3].add("1+1+1"); list[3].add("1+2"); list[3].add("2+1"); list[3].add("3");

        for (int i = 4; i <= N; i++) {
            for (int j = 1; j <= 3; j++) {
                for (String op : list[i-j]) {
                    list[i].add(op + "+" + j);
                }
            }
        }
        if(list[N].size() < targetPosition){
            System.out.println(-1);
        }else{
            Collections.sort(list[N]);
            System.out.println(list[N].get(targetPosition-1));
        }

    }
}
