package Level1;

class Solution3 {
    public String solution(String new_id) {         //신규 아이디 추천
        String answer = "";
        StringBuilder sb = new StringBuilder();
        answer = new_id;
        int size = answer.length();

        for(int i=0; i<size; i++){          //1단계
            int tmp = answer.charAt(i);
            if(tmp >= 65 && tmp <= 90){     //대문자인 경우
                sb.append((char)(tmp+32));
            }else{
                sb.append(answer.charAt(i));
            }
        }

        for(int i=0; i<sb.length(); i++){      //2단계
            int tmp = sb.charAt(i);
            if((tmp >= 48 && tmp <= 57) || (tmp >= 97 && tmp <= 122) || sb.charAt(i) == '-' || sb.charAt(i) == '_' || sb.charAt(i) == '.'){}
            else{
                sb.deleteCharAt(i);
                i--;
            }
        }

        for(int i=1; i<sb.length(); i++){       //3단계
            if(sb.charAt(i-1) == '.' && sb.charAt(i) == '.'){
                sb.deleteCharAt(i);
                i--;
            }
        }

        if(sb.charAt(0) == '.') {       //4단계
            sb.deleteCharAt(0);
        }
        size = sb.length();
        if(size > 0 && sb.charAt(size-1) == '.') {
            sb.deleteCharAt(size-1);
        }

        if(sb.length() == 0) {             //5단계
            sb.append('a');
        }

        if(sb.length() >= 16){          //6단계
            sb.setLength(15);
            size = sb.length();
            if(size > 0 && sb.charAt(size-1) == '.') {
                sb.deleteCharAt(size-1);
            }
        }

        if(sb.length() <= 2){           //7단계
            char tmp = sb.charAt(sb.length()-1);
            while(sb.length() < 3){
                sb.append(tmp);
            }
        }

        answer = sb.toString();
        return answer;
    }
}