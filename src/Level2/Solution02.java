package Level2;

import java.util.*;

class Solution02 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n = progresses.length;
        int idx = 0;

        while(idx < n){
            for(int i=idx; i<n; i++){
                progresses[i] += speeds[i];
            }

            int count = 0;
            for(int i=idx; i<n; i++){
                if(progresses[i] >= 100) {
                    count++;
                }else{
                    break;
                }
            }
            idx += count;
            if(count > 0){
                list.add(count);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
