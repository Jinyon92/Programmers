package Level1;

import java.util.*;

class Solution13 {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        int len = nums.length;

        for(int i=0; i<len; i++){
            set.add(nums[i]);
        }

        if(set.size() > len/2) answer = len/2;
        else{
            answer = set.size();
        }
        return answer;
    }
}
