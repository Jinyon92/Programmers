package Level1;

import java.util.*;

class Solution4 {
    public int solution(int n, int[] lost, int[] reserve) {         //체육복
        int lostSize = lost.length;
        int reserveSize = reserve.length;
        int answer = n - lostSize;
        boolean visited[] = new boolean[reserveSize];
        boolean visited2[] = new boolean[lostSize];
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i=0; i<lostSize; i++){
            for(int j=0; j<reserveSize; j++){
                if(lost[i] == reserve[j]){
                    visited[j] = true;
                    visited2[i] = true;
                    answer += 1;
                    break;
                }
            }
        }

        for(int i=0; i<lostSize; i++){
            if(visited2[i] == false){
                int key = lost[i];

                for(int j=0; j<reserveSize; j++){
                    if(key-1 <= reserve[j] && key+1 >= reserve[j] && visited[j] == false){
                        visited[j] = true;
                        answer += 1;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
