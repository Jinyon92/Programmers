package Level2;

import java.util.*;

class Solution01 {
    public int solution(String s) {
        int len = s.length();
        int answer = len;

        for(int unit=1; unit <= len/2; unit++){
            int ret = compress(s, unit, len).length();
            answer = Math.min(answer, ret);
        }

        return answer;
    }

    public String compress(String str, int unit, int len){
        String pattern = "";
        String compression = "";
        int count = 1;

        for(int i=0; i<len; i += unit){
            String nowStr;
            if(i+unit <= len){
                nowStr = str.substring(i, i+unit);
            }else{ //범위 초과일때
                nowStr = str.substring(i, len);
            }

            if(nowStr.equals(pattern)){
                count++;
            }else{ //다르다면
                if(count >= 2){ //기존 압축
                    compression += count + pattern;
                }else{
                    compression += pattern;
                }
                count = 1;
            }

            pattern = nowStr;
        }

        if(count >= 2){
            compression += count + pattern;
        }else{
            compression += pattern;
        }
        return compression;
    }
}
