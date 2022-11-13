package programmers;

public class KAKAO_BLIND_RECRUITMENT_2021_신규아이디추천 {
    public static void main(String[] args) {
        String new_id = "z-+.^.";
        System.out.println(solution(new_id));
    }
    static private String solution(String new_id) {
        String answer = new_id;

        // 1단계
        answer = new_id.toLowerCase();

        // 2단계
        answer = answer.replaceAll("[^a-z0-9._-]","");

        // 3단계
        answer = answer.replaceAll("\\.{2,}", ".");

        // 4단계
        answer = answer.replaceAll("^\\.","");
        answer = answer.replaceAll("\\.$","");

        // 5단계
        if(answer.length()==0) answer+= "a";

        // 6단계
        if(answer.length()>15) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("\\.$", "");
        }
        // 7단계

        while(answer.length()<3){
            answer += answer.charAt(answer.length()-1);
        }
        return answer;
    }
}
