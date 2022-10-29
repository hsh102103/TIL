package programmers;

import java.util.*;

/**
 * P는 응시자가 앉아있는 자리를 의미
 * O는 빈 테이블을 의미
 * X는 파티션을 의미
 * 대기실 별로 거리두기가 지켜지고 있으면 1, 아니라면 0을 담아서 출력하라.
 */
public class KAKAO_채용연계형_인턴십_2021_거리두기확인하기 {

    // 팔방탐색 12시방향부터 시계방향으로
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        System.out.println(solution(places));
    }

    static boolean bfs(String[] place, int row, int col) {
        boolean[][] marked = new boolean[5][5];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(row, col, 0));
        marked[row][col] = true;

        while (!q.isEmpty()) {
            Point curr = q.remove();

            if (curr.dist > 2) continue;
            if (curr.dist != 0 && place[curr.row].charAt(curr.col) == 'P') {
                return false;
            }
            for (int i = 0; i < 4; i++) {
                int nr = curr.row + dr[i];
                int nc = curr.col + dc[i];
                if (nr < 0 || nr > 4 || nc < 0 || nc > 4) continue;
                if (marked[nr][nc]) continue;
                if (place[nr].charAt(nc) == 'X') continue;
                marked[nr][nc] = true;
                q.add(new Point(nr, nc, curr.dist + 1));

            }
        }
        return true;
    }

    static boolean check(String[] place) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (place[r].charAt(c) == 'P') {
                    if (!bfs(place, r, c)) return false; // 거리두기 안되면 false
                }
            }
        }
        return true;
    }

    static private int[] solution(String[][] places) {
        int[] answer = new int[5];
        // 안쪽 배열로 새로운 2차원 배열 만들기
        for (int i = 0; i < 5; i++) {
            if (check(places[i])) {
                answer[i] = 1;
            } else
                answer[i] = 0;
        } // for(i) 종료

        return answer;
    }

    static class Point {
        int row, col, dist;

        Point(int r, int c, int d) {
            row = r;
            col = c;
            dist = d;
        }
    }
}
