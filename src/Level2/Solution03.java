package Level2;

import java.util.*;

class Solution03 {
    static HashMap<Character, Integer> map;
    static String[] d;
    static int answer;
    static boolean[] visited;
    static int[] friends;

    public int solution(int n, String[] data) {
        d = data;
        map = new HashMap<>();
        visited = new boolean[8];
        friends = new int[8];
        answer = 0;

        map.put('A',0);
        map.put('C',1);
        map.put('F',2);
        map.put('J',3);
        map.put('M',4);
        map.put('N',5);
        map.put('R',6);
        map.put('T',7);

        permutation(0);
        return answer;
    }

    public void permutation(int idx){
        if(idx == 8){
            if(check()) answer++;
        }else{
            for(int i=0; i<8; i++){
                if(!visited[i]){
                    visited[i] = true;
                    friends[idx] = i;
                    permutation(idx+1);
                    visited[i] = false;
                }
            }
        }
    }

    public static boolean check(){
        int a,b,gap;
        char op;
        for(String data : d){
            a = friends[map.get(data.charAt(0))];
            b = friends[map.get(data.charAt(2))];
            op = data.charAt(3);
            gap = data.charAt(4) - '0' + 1;

            if(op == '='){
                if(Math.abs(a-b) != gap) return false;
            }else if(op == '<'){
                if(Math.abs(a-b) >= gap) return false;
            }else{
                if(Math.abs(a-b) <= gap) return false;
            }
        }

        return true;
    }
}
