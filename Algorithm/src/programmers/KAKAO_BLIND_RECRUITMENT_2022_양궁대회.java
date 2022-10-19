package programmers;

import java.util.Arrays;

public class KAKAO_BLIND_RECRUITMENT_2022_양궁대회 {
    static int[] score = new int[12];
    static int[] resultArr = new int[12];
    static int scoreDifference = 0;

    public static void main(String[] args) {

        int[] info = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
        int n = 10;
        System.out.println(solution(n, info));
    }

    /**
     * tc 8, 18 왜 틀리는걸까 -> '가장 낮은점수가 많은' 조건을 놓침. <br/>
     * compareScore() 추가하니,  예제tc3이 틀림 -> scoreDifference가 같을때와 다를때를 분기해서 처리함. 처리방식이 다르기때문
     */
    static private int[] solution(int n, int[] info) {
        // 화살 갯수를 가지고 조합
        combination(0, 0, n, info);

        return scoreDifference == 0 ? new int[]{-1} : resultArr;
    }

    static private void combination(int sidx, int idx, int targetCount, int[] info) {
        // 화살을 모두 쐈을 때
        if (idx == targetCount) {
            // 라이언과 어피치의 점수 차이를 확인하는 메서드
            check(info);
            return;
        }

        // 조합-재귀
        for (int i = sidx; i < 11; i++) {
            score[i]++;
            combination(i, idx + 1, targetCount, info);
            score[i]--;
        }

    }

    static private void check(int[] info) {
        int apeachScore = 0;
        int lionScore = 0;

        // 과녁을 돌면서 확인
        for (int i = 0; i < info.length; i++) {
            // 둘다 못맞춘 점수는 continue. 나머지는 각각 점수 계산
            if (info[i] == 0 && score[i] == 0) continue;
            if (info[i] < score[i]) {
                lionScore += 10 - i;
            } else {
                apeachScore += 10 - i;
            }
        }
        // 점수 차이가 기존의 차이보다 크다면 바로 대체.
        if (scoreDifference < (lionScore - apeachScore)) {
            scoreDifference = lionScore - apeachScore;
            resultArr = Arrays.copyOf(score, 11);
            //기존의 차이와 점수 차이가 같다면, 가장 낮은 점수가 더 많아졌는지 확인.
        } else if (scoreDifference == (lionScore - apeachScore)) {
            if (compareScore()) {
                // 낮은 점수가 더 많아졌다면 대체.
                resultArr = Arrays.copyOf(score, 11);
            }
        }

    }

    static private boolean compareScore() {
        // 뒤부터 확인한다. (0점 부터)
        for (int i = 10; i >= 0; i--) {
            // 똑같은 횟수를 맞춘 과녁은 넘어간다.
            // 먼저 차이가 나는 과녁의 결과에 따라 return
            if (score[i] > resultArr[i]) {
                return true;
            } else if (score[i] < resultArr[i]) {
                return false;
            }
        }
        // 끝까지 같은 횟수로 맞췄다면 변경할필요없음. 요기 올 일이 있나?
        return false;
    }
}
