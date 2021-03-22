package Level1;

import java.util.*;

class Solution5 {       //
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();

        while(n > 0){
            result.add(n%3);
            n /= 3;
        }

        int len = result.size();
        int val = 1;
        for(int i=len-1; i>=0; i--){
            answer += result.get(i)*val;
            val *= 3;
        }
        return answer;
    }
}
