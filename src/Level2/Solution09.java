package Level2;

import java.util.*;

class Solution09 {
    static boolean[] isPrime;
    static char[] arr;
    static char[] temp;
    static boolean[] visited;
    static int n;
    static int answer;
    public int solution(String numbers) {
        answer = 0;
        int MAXNUM = 10000000;
        n= numbers.length();
        arr = numbers.toCharArray();
        temp = new char[n];
        visited = new boolean[n];
        isPrime = new boolean[MAXNUM];
        isPrime[0] = isPrime[1] = true;

        for(int i=2; i*i < MAXNUM; i++){
            if(!isPrime[i]){
                for(int j=i*i; j< MAXNUM; j += i){
                    isPrime[j] = true;
                }
            }
        }

        per(0, "");

        return answer;
    }

    public static void per(int idx, String num){
        if(idx >= 1){
            int number = Integer.parseInt(num);

            if(!isPrime[number]){
                answer++;
                isPrime[number] = true;
            }

            if(idx == n) return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                temp[idx] = arr[i];
                num += arr[i];
                per(idx+1, num);
                num = num.substring(0, num.length() - 1);
                visited[i] = false;
            }
        }
    }
}