package Level2;

import java.util.*;

class Solution07
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int len = s.length();

        stack.push(s.charAt(0));
        for(int i=1; i<len; i++){
            char cur;
            if(!stack.empty()) {cur = stack.peek();}
            else cur = '0';

            if(cur == s.charAt(i)){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }

        if(stack.empty()) answer = 1;

        return answer;
    }
}
