package Level1;

import java.util.*;

public class Solution9 {
    public ArrayList<Integer> solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int len = arr.length;

        int key = arr[0];
        answer.add(key);
        for(int i=1; i<len; i++){
            if(key ==  arr[i]) continue;
            else{
                key = arr[i];
                answer.add(key);
            }
        }

        return answer;
    }
}
