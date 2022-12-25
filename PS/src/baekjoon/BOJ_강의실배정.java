package baekjoon;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// Please name your class Main
class BOJ_강의실배정 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Room[] arr = new Room[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Room(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            } else {
                return o1.start - o2.start;
            }
        });


        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(arr[0].end);
        for (int i = 1; i < arr.length; i++) {
            Room room = arr[i];
            if (room.start >= pq.peek()) {
                pq.poll();
            }
            pq.offer(room.end);
        }
        int res = pq.size();
        System.out.println(res);
    }

    static class Room {
        int start;
        int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}