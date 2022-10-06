public class KAKAO_TECH_INTERNSHIP_코딩테스트공부 {
    public static void main(String[] args) {

        int alp = 0;
        int cop = 0;

        int[][] problems = {{0, 0, 2, 1, 2},
                {4, 5, 3, 1, 2},
                {4, 11, 4, 0, 2},
                {10, 4, 0, 4, 2}};
        System.out.println(solution(alp, cop, problems));
    }

    static private int solution(int alp, int cop, int[][] problems) {
        int answer = 0;

        int alp_goal = 0;
        int cop_goal = 0;

        // 목표 정하기
        for (int i = 0; i < problems.length; i++) {
            alp_goal = Math.max(alp_goal, problems[i][0]);
            cop_goal = Math.max(cop_goal, problems[i][1]);
        }

        if (alp >= alp_goal) alp = alp_goal;
        if (cop >= cop_goal) cop = cop_goal;

        // goal+1 까지 값을 넣어야하기 때문에 크기는 goal+2
        int[][] dp = new int[alp_goal + 2][cop_goal + 2];

        for (int i = alp; i <= alp_goal; i++) {
            for (int j = cop; j <= cop_goal; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[alp][cop] = 0;

        for (int i = alp; i <= alp_goal; i++) {
            for (int j = cop; j <= cop_goal; j++) {
                dp[i][j + 1] = Math.min(dp[i][j] + 1, dp[i][j + 1]);
                dp[i + 1][j] = Math.min(dp[i][j] + 1, dp[i + 1][j]);

                for (int[] p : problems) {
                    if (i >= p[0] && j >= p[1]) {
                        if (i + p[2] > alp_goal && j + p[3] > cop_goal) {
                            dp[alp_goal][cop_goal] = Math.min(dp[alp_goal][cop_goal], dp[i][j] + p[4]);
                        } else if (i + p[2] > alp_goal) {
                            dp[alp_goal][j + p[3]] = Math.min(dp[alp_goal][j + p[3]], dp[i][j] + p[4]);
                        } else if (j + p[3] > cop_goal) {
                            dp[i + p[2]][cop_goal] = Math.min(dp[i + p[2]][cop_goal], dp[i][j] + p[4]);
                        } else {
                            dp[i + p[2]][j + p[3]] = Math.min(dp[i][j] + p[4], dp[i + p[2]][j + p[3]]);
                        }
                    }
                }
            }
        }

        answer = dp[alp_goal][cop_goal];
        return answer;
    }
}