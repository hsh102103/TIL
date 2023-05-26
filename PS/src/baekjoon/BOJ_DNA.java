package baekjoon;

import java.util.Scanner;

/**
 * TAAGATAC
 * <p>
 * TATGATAC
 * TAAGCTAC
 * AAAGATCC
 * TGAGATAC
 * TAAGATGT
 * 11101021
 * 열별로 가장 많은 알파벳 선택
 * 사전순이기 때문에 값이 있다면 char로 비교해서 더 작은 값을 answer 문자열에 붙여주자
 * 가장 많은 알파벳과 다른 알파벳의 수를 파악하여 distance 변수에 더해주자.
 */
public class BOJ_DNA {
    public static void main(String[] args) {
        StringBuilder answer = new StringBuilder();
        int distance = 0;

        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        char[][] map = new char[row][col];
        for (int r = 0; r < row; r++) {
            String s = sc.next();
            for (int c = 0; c < col; c++) {
                map[r][c] = s.charAt(c);
            }
        } // 입력 종료
        
        int[] alphabet;
        // 열별 확인 시작
        for (int c = 0; c < col; c++) {
            char choice = 0;
            alphabet = new int[26];
            for (int r = 0; r < row; r++) {
                alphabet[map[r][c] - 'A']++;
            }

            int max = -1;
            // 가장 많은 알파벳 찾기
            for (int i = 0; i < 26; i++) {
                if (alphabet[i] > max) {
                    choice = (char) ('A' + i);
                    max = alphabet[i];
                } else if (alphabet[i] == max) {
                    if (choice > (char) ('A' + i)) {
                        choice = (char) ('A' + i);
                        max = alphabet[i];
                    }
                }
            }
            for (int r = 0; r < row; r++) {
                if(map[r][c] != choice){
                    distance++;
                }
            }
            answer.append(choice);
        }

        System.out.println(answer);
        System.out.println(distance);
    }
}
