package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 두 큐의 합 구한 뒤,
 * 두 큐중 합이 더 큰 쪽에서 pop
 * 두 큐의 길이의 합만큼 반복해도 안끝나면 종료 <- 여기가 조금 맞나? 싶음
 * tc1에서 두 큐의 길이 합만큼 돌리면 실패. 최대길이인 600_000으로하면 성공
 */
public class KAKAO_TECH_INTERNSHIP_두큐합같게만들기 {
    public static void main(String[] args) {

        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        System.out.println(solution(queue1, queue2));
    }

    static private int solution(int[] queue1, int[] queue2) {
        int answer = -1;

        long sumOf1 = 0;
        long sumOf2 = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sumOf1 += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            q2.add(queue2[i]);
            sumOf2 += queue2[i];
        }

        if ((sumOf1 + sumOf2) % 2 != 0) {
            return answer;
        }

        int res = 0;
        for (int i = 0; i <= 600_000; i++) {
            if (sumOf1 == sumOf2) break;

            if (sumOf1 > sumOf2) {
                int pop = q1.poll();
                q2.add(pop);
                sumOf1 -= pop;
                sumOf2 += pop;
                res++;
            } else {
                int pop = q2.poll();
                q1.add(pop);
                sumOf2 -= pop;
                sumOf1 += pop;
                res++;
            }
        }
        answer = res;
        if (sumOf1 != sumOf2) answer = -1;

        return answer;
    }
}
