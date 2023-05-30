package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * N을 m으로 나눈 나머지가 R이 되도록하는
 * 모든 m의 합을 구하고 없다면 0을 출력하라.
 * 1 <= N <= 10^12; 0 <= R < N
 *
 * 기본적인 아이디어
 * N 이하의 모든 자연수에 대해 나머지를 확인하는 방법
 * 이 경우에 N의 범위가 1조이하이기 때문에 시간초과가 발생한다.
 *
 * 16 4의 경우
 * 12(16-4)의 약수이면서 16의 약수가 아닌 것
 * 12의 약수 = 1,2,3,4,6,12
 * 16의 약수 = 1,2,4,8,16
 * 차집합 => 3,6,12 -> 답과 다르다.
 *
 * 그렇다면 (N-R)의 약수 중 N을 나눈 나머지가 R인 것을 찾아내자.
 * 이렇게하면 최대 갯수가 몇개가 나오지
 * 출력문을 통해 최대 갯수 확인하고, 1억개 이하면 이 방법을 사용하자
 *
 */
public class BOJ_28138_재밌는나머지연산 {
    static List<Long> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long R = sc.nextLong();

        list = new ArrayList<>();

        int sqrt = (int)Math.sqrt(N-R);
        약수구하기(N-R, sqrt);
        long answer =0;
        for (long i: list) {
            if (N % i == R) {
                answer += i;
            }
        }
        System.out.println(answer);
    }

    static void 약수구하기(long N, int sqrt) {
        for (long i = 1; i <= sqrt; i++) {
            if (N % i == 0) {
                list.add(i);
            }
            if( N/ i != i) {
                list.add(N/i);
            }
        }
    }
}
