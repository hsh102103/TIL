package programmers;

import java.util.*;

/**
 * 명령어 기반으로 표의 행을 선택, 삭제, 복구
 *
 */
public class KAKAO_채용연계형_인턴십_2021_표편집 {

    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        System.out.println(solution(n, k, cmd));
    }

    static private String solution(int n, int k, String[] cmd) {
        String answer = "";

        // 작업하는 표
        List<Integer> beforeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            beforeList.add(i);
        }

        List<Integer> afterList = program(k, beforeList, cmd);

        boolean[] checkArray = new boolean[n];
        for (Integer value : afterList) {
            checkArray[value] = true;
        }

        for (int i = 0; i < n; i++) {
            if(checkArray[i]) answer+= "O";
            else answer+="X";
        }

        return answer;
    }
    static class Node{
        int row,value;
        public Node(int row,int value){
            this.row = row;
            this.value = value;
        }
    }
    static private List<Integer> program(int pointer, List<Integer> list, String[] cmd){
        // 삭제한 행을 저장할 Stack. 삭제된 행과 값을 저장
        Stack<Node> stack = new Stack<>();

        for (String s : cmd) {
            char c = s.charAt(0);
            switch (c) {
                case 'U' -> // 포인터 위로 이동
                        pointer -= s.charAt(2) - '0';
                case 'D' -> // 포인터 아래로 이동
                        pointer += s.charAt(2) - '0';
                case 'C' -> { // 가리키는 행 제거
                    Integer value = list.remove(pointer);
                    stack.add(new Node(pointer, value));
                    if (pointer == list.size() - 1)
                        pointer--;
                }
                case 'Z' -> { // 삭제 행 복구
                    Node popNode = stack.pop();
                    list.add(popNode.row, popNode.value);
                }
            }
        }

        return list;
    }
}
