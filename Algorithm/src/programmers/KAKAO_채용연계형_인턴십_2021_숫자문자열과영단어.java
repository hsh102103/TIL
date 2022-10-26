package programmers;

/**
 * 문자열 문제
 * 0 <= s.charAt <= 9이면 그대로 숫자를 추가. (answer*10 + s.charAt)
 * 아니라면 다음으로 숫자가 나올때까지 알파벳확인하여 저장한다음, 대응되는 인덱스를 answer에 추가.
 */
public class KAKAO_채용연계형_인턴십_2021_숫자문자열과영단어 {
    public static void main(String[] args) {
        String s = "one4seveneight";
        System.out.println(solution(s));
    }
    static StringBuilder makeNumber = new StringBuilder();
    static private int solution(String s) {
        int answer = 0;
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

       outer: for (int i = 0; i < s.length(); i++) {
           // 나온 문자열을 numbers에서 찾은 뒤, 인덱스를 저장
           answer = fineNum(answer, numbers, makeNumber);

           char index = s.charAt(i);
            // 알파벳이라면 makeNumber에 추가
            if (index-'0' > 10) {
                makeNumber.append(index+"");
                continue;
            }
            // 인덱스의 문자가 숫자인지 확인
            if (index -'0' <= 9) {
                // 그냥 숫자라면 바로 저장
                answer = answer * 10 + (index-'0');
            }
        }
        answer = fineNum(answer, numbers, makeNumber);
        return answer;
    }

    private static int fineNum(int answer, String[] numbers, StringBuilder makeNumber) {
        for (int j = 0; j< numbers.length; j++) {
            if (numbers[j].equals(makeNumber.toString())) {
                answer = answer * 10 + j;
                makeNumber.setLength(0);
            }
        }
        return answer;
    }

}
