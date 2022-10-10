package programmers;

import java.util.HashMap;

public class KAKAO_TECH_INTERNSHIP_성격유형검사하기 {
    public static void main(String[] args) {

        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(solution(survey, choices));
    }

    static private String solution(String[] survey, int[] choices) {
        String answer = "";
        char[] category = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};

        // 포인트 저장용 맵 생성 및 초기화
        HashMap<Character, Integer> points = new HashMap<>();
        for (int i = 0; i < category.length; i++) {
            points.put(category[i], 0);
        }

        for (int i = 0; i < survey.length; i++) {
            int idx = choices[i] / 4;
            int point = idx == 0 ? 4 - choices[i] % 4 : choices[i] % 4;
            char tendency = survey[i].charAt(idx);

            points.put(tendency, point + points.get(tendency));
        }

        for (int i = 0; i < points.size(); i += 2) {
            answer += points.get(category[i]) > points.get(category[i + 1])
                    ? category[i] : points.get(category[i]) < points.get(category[i + 1])
                    ? category[i + 1] : category[i];
        }

        return answer;
    }
}