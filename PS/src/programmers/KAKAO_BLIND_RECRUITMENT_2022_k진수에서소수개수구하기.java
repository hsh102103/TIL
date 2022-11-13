package programmers;

public class KAKAO_BLIND_RECRUITMENT_2022_k진수에서소수개수구하기 {
    static boolean[] isNotPrime;

    public static void main(String[] args) {

        int n = 110011;
        int k = 10;
        System.out.println(solution(n, k));
    }

    /**
     * 진수 변환 시 생성되는 수 p 중, 왼쪽 또는 오른쪽에 0이 있는 소수 p의 개수를 구하는 문제<br/>
     *
     * @param n 입력받은 정수
     * @param k n을 k진수로 변환
     * @return 변환된 수 안에서 찾을 수 있는 조건에 맞는 소수의 개수를 return
     * <p>
     * 가장 왼쪽 0을 처리해주어야한다. -> 정규식으로 처리해주자.
     */
    static private int solution(int n, int k) {
        int answer = 0;
        // 진수 변환했을 때 값을 저장할 String 변수 선언

        String[] sArr = new StringBuilder(conversion(n, k)).reverse().toString().split("0+");
        for (String s : sArr) {
            if (checkPrime(s)) {
                answer++;
            }
        }
        return answer;
    }

    static private String conversion(int n, int k) {
        String s = "";
        // 진수 변환하여 저장. 역순으로 저장됨.
        while (n > 0) {
            s += n % k;
            n /= k;
        }
        return s;
    }

    private static boolean checkPrime(String s) {
        long num = Long.parseLong(s);
        if (num == 0 || num == 1) return false;
        if (num == 2 || num == 3) return true;
        boolean isPrime = true;
        for (long i = 3; i < Math.sqrt(num)+1; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
