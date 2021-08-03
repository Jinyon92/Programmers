package Level2;

class Solution04 {
    public String solution(int n) {
        String answer = "";
        while(n > 0){
            boolean flag = false;
            if(n % 3 == 0){
                answer = "4" + answer;
                flag = true;
            }else if(n % 3 == 1){
                answer = "1" + answer;
            }else if(n % 3 == 2){
                answer = "2" + answer;
            }
            n /= 3;

            if(flag) n -= 1;
        }
        return answer;
    }
}
