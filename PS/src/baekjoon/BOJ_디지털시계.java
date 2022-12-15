package baekjoon;// Don't place your source in a package
import java.util.*;
import java.lang.*;

// Please name your class Main
public class BOJ_디지털시계 {
    static int ans;
    static int[] res, resArr;
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int T = 3;
        while(T-->0) {
            String[] startTime = sc.next().split(":");
            String[] endTime = sc.next().split(":");

            int startSec = Integer.parseInt(startTime[0]) * 60 * 60 + Integer.parseInt(startTime[1]) * 60 + Integer.parseInt(startTime[2]);
            int endSec = Integer.parseInt(endTime[0]) * 60 * 60 + Integer.parseInt(endTime[1]) * 60 + Integer.parseInt(endTime[2]);


            resArr = new int[86400];
            res = new int[]{0,0,0};
            for(int i = 0 ; i<86400; i++){
                int tmp = res[0] + res[1] + res[2];
                if(tmp%3==0) resArr[i]++;
                res[0]++;
                check();
            }
            ans=0;
            if(startSec < endSec) {
                TimeCount(startSec, endSec+1);
            }else {
                TimeCount(startSec, 86400);
                TimeCount(0, endSec+1);
            }
            System.out.println(ans);
        }
    }
    static void TimeCount(int start, int end){
        for(int i = start; i < end; i++){
            ans += resArr[i];
        }
    }
    static void check() {
        if(res[0] == 60){
            res[0] = 0;
            res[1]++;
        }
        if(res[1] == 60){
            res[1] = 0;
            res[2]++;
        }

    }
}
