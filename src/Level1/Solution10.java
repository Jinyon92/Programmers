package Level1;

import java.util.*;

class Solution10 {
    public ArrayList<Integer> solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int len = arr.length;

        for(int i=0; i<len; i++){
            if(arr[i]%divisor == 0) answer.add(arr[i]);
        }

        if(answer.size() == 0) answer.add(-1);
        else{
            Collections.sort(answer);
        }
        return answer;
    }
}
