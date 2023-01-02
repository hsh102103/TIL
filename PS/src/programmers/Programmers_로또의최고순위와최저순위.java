package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer;

        int cnt0 = 0;
        List<Integer> list = new ArrayList<>();
        for (int lotto : lottos) {
            if (lotto == 0) {
                cnt0++;
                continue;
            }
            list.add(lotto);
        }
        int sameNumber = 0;
        for (int win_num : win_nums) {
            if (list.contains(win_num)) {
                sameNumber++;
            }
        }
        int highRank = 7 - (sameNumber + cnt0);
        int lowRank = 7 - sameNumber;
        if (highRank > 6) highRank = 6;
        if (lowRank > 6) lowRank = 6;
        answer = new int[]{highRank, lowRank};
        return answer;
    }
}
