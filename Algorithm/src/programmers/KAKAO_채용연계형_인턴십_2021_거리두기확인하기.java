package programmers;

/**
 * P는 응시자가 앉아있는 자리를 의미
 * O는 빈 테이블을 의미
 * X는 파티션을 의미
 * 대기실 별로 거리두기가 지켜지고 있으면 1, 아니라면 0을 담아서 출력하라.
 */
public class KAKAO_채용연계형_인턴십_2021_거리두기확인하기 {

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

    // 팔방탐색 12시방향부터 시계방향으로
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static private int[] solution(String[][] places) {
        int[] answer = new int[5];
        // 안쪽 배열로 새로운 2차원 배열 만들기
        for (int i = 0; i < 5; i++) {
            char[][] waitingRoom = new char[5][5];
            for (int j = 0; j < 5; j++) {
                waitingRoom[j] = places[i][j].toCharArray();
            }
            answer[i] = search(waitingRoom) ? 0 : 1;
        } // for(i) 종료

        return answer;
    }

    static boolean search(char[][] waitingRoom){
        boolean flag = false; // 사람있으면 true

        // 팔방탐색
        outer: for (int r = 0; r < waitingRoom.length; r++) {
            for (int c = 0; c < waitingRoom[r].length; c++) {
                if(waitingRoom[r][c] != 'P')continue ;

                // 상하좌우 탐색
                // 방향 정하기
                for (int d = 0; d < dr.length; d += 2) {
                    // 상하좌우는 2칸떨어진곳까지 확인
                    for (int k = 0; k < 2; k++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (isNotRange(nr, nc)) break;

                        if (waitingRoom[nr][nc] == 'X') break;
                        if (waitingRoom[nr][nc] == 'P') {
                            flag = true;
                            break outer;
                        }

                    }
                }
                // 대각선 탐색
                for (int d = 1; d < dr.length; d += 2) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (isNotRange(nr, nc)) continue;

                    if (waitingRoom[nr][nc] == 'X') continue;
                    if (waitingRoom[nr][nc] == 'P') {
                        // 거리두기가 지켜지지 않는다면 가는 길이 모두 파티션되어있어야함.
                        int[] direction = {d-1,d+1};
                        flag = isPartition(waitingRoom,nr,nc, direction);
                        if(flag)
                            break outer;
                    }
                }
            }
        }

        return flag;
    }

    static boolean isPartition(char[][] waitingRoom,int r, int c, int[] d) {
        boolean flag = false;
        // d 전과 후 1개씩 확인해서 모두 파티션이 있어야 함.
        for (int i = 0; i < d.length; i++) {
            if(d[i] <0 || d[i] >=5) continue;
            int nr = r + dr[d[i]];
            int nc = c + dc[d[i]];
            if(isNotRange(nr,nc)) continue;

            if(waitingRoom[nr][nc] != 'X'){
                flag = true;
                break;
            }
        }

        return flag;
    }

    /**
     * 범위를 벗어나는 위치인지 확인
     * @param r 가로
     * @param c 세로
     * @return 벗어난다면 true
     */
    static boolean isNotRange(int r, int c) {
        return r<0 || r>=5 || c<0 || c>=5;
    }
}
