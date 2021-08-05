package Level2;

import java.util.*;

class Solution06 {
    static ArrayList<Long> numList = new ArrayList<>(); //숫자 담을 리스트
    static ArrayList<Character> opList = new ArrayList<>(); //연산자 담을 리스트
    static boolean visited[] = new boolean[3];
    static char oper[] = {'*', '-', '+'};
    static char priOp[] = new char[3];
    static long answer;

    public long solution(String expression) {
        int len = expression.length();
        answer = 0;
        String val = "";
        for(int i=0; i<len; i++){
            char cur = expression.charAt(i);
            if(cur == '*' || cur == '-' || cur == '+'){
                numList.add(Long.parseLong(val));
                val = "";
                opList.add(cur);
            }else{
                val += cur;
            }
        }
        numList.add(Long.parseLong(val));
        permutation(0);

        return answer;
    }

    public static void permutation(int idx){
        if(idx == 3){ //종료조건
            solve();
            return;
        }

        for(int i=0; i<3; i++){
            if(!visited[i]){
                visited[i] = true;
                priOp[idx] = oper[i];
                permutation(idx+1);
                visited[i] = false;
            }
        }
    }

    public static void solve(){
        ArrayList<Long> num = new ArrayList<>();
        num.addAll(numList);
        ArrayList<Character> op = new ArrayList<>();
        op.addAll(opList);

        for(int i=0; i<3; i++){
            char curOp = priOp[i];

            for(int j=0; j<op.size(); j++){
                if(op.get(j).equals(curOp)){
                    long num1 = num.get(j);
                    long num2 = num.get(j+1);
                    long num3 = calc(num1, num2, curOp);

                    num.set(j, num3);
                    num.remove(j+1);
                    op.remove(j);
                    j--;
                }
            }
        }

        long res = Math.abs(num.get(0));
        answer = Math.max(answer, res);
    }

    public static long calc(long num1, long num2, char op){
        if(op == '-'){
            return num1 - num2;
        }else if(op == '+'){
            return num1 + num2;
        }else{
            return num1 * num2;
        }
    }
}