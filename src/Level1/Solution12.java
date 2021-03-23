package Level1;

class Solution12 {
    boolean solution(String s) {
        boolean answer = false;
        int cnt[] = new int[2];
        int len = s.length();

        for(int i=0; i<len; i++){
            char key = s.charAt(i);
            if(key == 'p' || key == 'P') cnt[0]++;
            else if(key == 'y' || key == 'Y') cnt[1]++;
        }

        if(cnt[0] == cnt[1]) answer = true;
        return answer;
    }
}