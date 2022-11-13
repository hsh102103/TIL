package programmers;

import java.util.*;

public class KAKAO_BLIND_RECRUITMENT_2022_주차요금계산 {
    public static void main(String[] args) {

        int[] fees = {1, 461, 1, 10};
        String[] records = {
                "00:00 1234 IN"};
        System.out.println(solution(fees, records));
    }

    /**
     * @param fees    {기본시간, 기본요금, 단위시간, 단위요금}
     * @param records {"시각 차량번호 IN/OUT"}
     * @return
     */
    static private int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        Map<String, String> enteredTime = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();

        // enteredTime
        for (int i = 0; i < records.length; i++) {
            String[] divides = records[i].split(" "); // {시각, 차번호, IN/OUT}
            // divides[2]에 따라 나눠서 처리
            if (divides[2].equals("IN")) {
                enteredTime.put(divides[1], divides[0]);
            } else { // OUT이면
                String[] outTime = divides[0].split(":");
                String[] inTime = enteredTime.get(divides[1]).split(":");

                int minute = (Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0])) * 60 + Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);
                result.put(divides[1], result.getOrDefault(divides[1], 0) + minute);
                enteredTime.put(divides[1], "23:59");
            } // else
        } // for(i)

        // 마지막으로 들어있는 시간 모두 체크
        for (Map.Entry<String, String> entry : enteredTime.entrySet()) {
            String[] inTime = enteredTime.get(entry.getKey()).split(":");
            String[] outTime = {"23", "59"};
            int minute = (Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0])) * 60 + Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);
            result.put(entry.getKey(), result.getOrDefault(entry.getKey(),0) + minute);
        }
        // 정렬할 차번호
        String[] cars = result.keySet().toArray(new String[0]);
        Arrays.sort(cars);


        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            String nKey = cars[i];
            int time = result.get(nKey);
            answer[i] = fees[1];
            time -= fees[0];
            if (time > 0) {
                answer[i] += (int) (Math.ceil((double) time / fees[2]) * fees[3]);
            }
        }
        return answer;
    }
}
