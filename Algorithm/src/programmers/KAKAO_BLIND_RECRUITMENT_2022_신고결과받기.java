package programmers;

import java.util.*;

public class KAKAO_BLIND_RECRUITMENT_2022_신고결과받기 {

    public static void main(String[] args) {

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        System.out.println(solution(id_list, report, k));
    }

    static private int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // (신고당한 사람: 신고한사람)을 가지는 map 타입 변수 생성
        Map<String, List<String>> users = new HashMap<>();

        // report split 후 users에 담아주기
        for (String s : report) {
            // report를 reporter와 reported로 스플릿
            String reporter = s.split(" ")[0];
            String reported = s.split(" ")[1];
            // reporter 추가하여 users 추가하기.
            List<String> reporterList = users.getOrDefault(reported,null);
            if(reporterList == null) reporterList = new ArrayList<>();
            // 중복제거
            if(!reporterList.contains(reporter)) {
                reporterList.add(reporter);
                users.put(reported, reporterList);
            }
        }

        Map<String, Integer> reportCount = new HashMap<>();
        for (List<String> reporterList : users.values()) {
            // 신고자의 수가 k이상이라면
            if (reporterList.size() >= k) {
                for (String reporter : reporterList) {
                    reportCount.put(reporter, reportCount.getOrDefault(reporter,0)+1);
                }
            }
        }
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = reportCount.getOrDefault(id_list[i],0);
        }


        return answer;
    }
}
