package Level2;

import java.util.*;

class Solution08 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int answer = 0;
        int len = scoville.length;

        for(int i=0; i<len; i++){
            heap.offer(scoville[i]);
        }

        while(heap.peek() < K){
            if(heap.size() <= 1) {
                answer = -1;
                break;
            }

            int val1 = heap.poll();
            int val2 = heap.poll();
            int newVal = val1 + (val2 * 2);

            heap.offer(newVal);
            answer++;
        }

        return answer;
    }
}
