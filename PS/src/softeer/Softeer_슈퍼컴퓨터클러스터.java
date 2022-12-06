package softeer;

import java.io.*;
import java.util.*;

public class Softeer_슈퍼컴퓨터클러스터 {
    static class Node implements Comparable<Node>{
        int initValue;
        int increase;
        int lastValue;

        public Node(int initValue){
            this.initValue = initValue;
            increase = 0;
            lastValue = initValue;
        }

        @Override
        public int compareTo(Node o) {
            return this.lastValue - o.lastValue;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i =0; i < N; i++){
            pq.add(new Node(Integer.parseInt(st.nextToken())));
        }

        long usedValue = 0;
        // pq에서 하나씩 빼서 값 증가시키기

        while(true){
            Node node = pq.poll();

            long tmpValue = usedValue - (long)Math.pow(node.increase, 2) + (long)Math.pow(node.increase + 1, 2);

            // 분기처리하고 괜찮으면 increase++, lastValue = initValue + increase
            if(tmpValue > B){
                pq.add(node);
                break;
            }

            usedValue = tmpValue;
            node.increase = node.increase + 1;
            node.lastValue = node.initValue + node.increase;
            pq.add(node);
        }


        System.out.println(pq.poll().lastValue);
    }

}