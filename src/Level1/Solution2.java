package Level1;

import java.util.*;

class Solution2 {
    public ArrayList<Integer> solution(int[] numbers) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        HashSet<Integer> hs = new HashSet<Integer>();
        int len = numbers.length;

        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                hs.add(numbers[i]+numbers[j]);
            }
        }

        Iterator<Integer> it = hs.iterator();
        while (it.hasNext()) {
            answer.add(it.next());
        }

        Collections.sort(answer);

        return answer;
    }
}
