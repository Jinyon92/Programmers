package Level1;

import java.util.*;

class Solution11 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2 ){
                if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
                else{
                    return s1.charAt(n) - s2.charAt(n);
                }
            }
        });

        return strings;
    }
}
