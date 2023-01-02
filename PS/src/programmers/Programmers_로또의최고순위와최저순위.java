package programmers;

import java.util.Arrays;

public class Programmers_로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int sameNumber = 0;
        int cnt0 = 0;
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int pointer1 = 0;
        int pointer2 = 0;
        while(pointer1 != 6 && pointer2 != 6) {
            if(lottos[pointer1] == 0) {
                cnt0++;
                pointer1++;
                continue;
            }
            if(lottos[pointer1] == win_nums[pointer2]){
                sameNumber++;
                pointer1++;
                pointer2++;
                continue;
            }
            if(lottos[pointer1] > win_nums[pointer2]) {
                pointer2++;
                continue;
            }
            if(lottos[pointer1] < win_nums[pointer2]) {
                pointer1++;
                continue;
            }

        }
        int[] rank = {6,6,5,4,3,2,1};
        answer[0] = rank[sameNumber+cnt0];
        answer[1] = rank[sameNumber];

        return answer;
    }
}
