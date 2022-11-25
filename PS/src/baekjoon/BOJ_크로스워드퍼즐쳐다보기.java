package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_크로스워드퍼즐쳐다보기 {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();

        char[][] map = writeMap(R, C);
        PriorityQueue<String> words = findWord(R, C, map);

        System.out.println(words.peek());

    }

    static char[][] writeMap(int R, int C) {
        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        return map;
    }

    static String considerSave(StringBuilder sb) {
        if(sb.length() < 2)
            return "zzzzzzzzzzzzzzzzzzzzz";
        return sb.toString();
    }
    static PriorityQueue<String> findWord(int R, int C, char[][] map) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        // 가로 단어 확인
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                char c = map[i][j];

                if(c == '#') {
                    pq.add(considerSave(sb));
                    sb.setLength(0);
                    continue;
                }
                sb.append(c);
            }
            pq.add(considerSave(sb));
            sb.setLength(0);
        }
        // 세로 단어 확인
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                char c = map[j][i];

                if(c == '#'){
                    pq.add(considerSave(sb));
                    sb.setLength(0);
                    continue;
                }
                sb.append(c);
            }
            pq.add(considerSave(sb));
            sb.setLength(0);
        }

        return pq;
    }
}
