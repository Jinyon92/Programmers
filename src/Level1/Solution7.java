package Level1;

import java.util.*;

class Solution7 {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int[] person1 = {1,2,3,4,5};
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};

        int size = answers.length;
        int idx1 = 0, idx2 = 0, idx3 = 0;
        int []score = new int[3];
        for(int i=0; i<size; i++, idx1++, idx2++, idx3++){
            if(idx1 % 5 == 0) idx1 = 0;
            if(idx2 % 8 == 0) idx2 = 0;
            if(idx3 % 10 == 0) idx3 = 0;
            if(answers[i] == person1[idx1]) score[0]++;
            if(answers[i] == person2[idx2]) score[1]++;
            if(answers[i] == person3[idx3]) score[2]++;
        }

        int maxScore = score[0];
        int ans = 1;
        for(int i=1; i<3; i++){
            if(maxScore < score[i]){
                maxScore = score[i];
                ans = i+1;
            }
        }

        answer.add(ans);

        for(int i=0; i<3; i++){
            if(maxScore == score[i] && ans != i+1){
                answer.add(i+1);
            }
        }

        Collections.sort(answer);
        return answer;
    }
}
