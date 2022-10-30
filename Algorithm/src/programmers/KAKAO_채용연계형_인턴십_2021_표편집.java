package programmers;

import java.util.*;

/**
 * 명령어 기반으로 표의 행을 선택, 삭제, 복구
 */
public class KAKAO_채용연계형_인턴십_2021_표편집 {

    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
        System.out.println(solution(n, k, cmd));
    }

    static private String solution(int n, int k, String[] cmd) {
        String answer = "";

        // 삭제한 행을 저장할 Stack
        Stack<Integer> stack = new Stack<>();
        int size = n;

        for (String s : cmd) {
            char c = s.charAt(0);
            switch (c) {
                case 'U': // 포인터 위로 이동
                    k -= Integer.parseInt(s.substring(2));
                    break;
                case 'D': // 포인터 아래로 이동
                    k += Integer.parseInt(s.substring(2));
                    break;
                case 'C': // 가리키는 행 제거
                    stack.add(k);
                    size--;
                    if (k == size) k--;
                    break;
                case 'Z': // 삭제 행 복구
                    int value = stack.pop();
                    if (value <= k) k++;
                    size++;
                    break;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append('O');
            }
            // 차례로 채워준다
            while (!stack.isEmpty()) {
                sb.insert(stack.pop().intValue(), 'X');
            }

            answer = sb.toString();
            return answer;
        }
    }
