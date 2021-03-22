package Level1;

class Solution8 {
    public String solution(int a, int b) {
        //31,29,31,30,31,30,31,31,30,31,30,31

        for(int i=1; i<a; i++){
            if(i%2 == 0) {
                if(i >= 8) {b += 31;}
                else if(i == 2) {b += 29;}
                else {b += 30;}
            }else{
                if(i < 9) {b += 31;}
                else {b += 30;}
            }
        }

        b = b%7;
        if(b==0) {return "THU";}
        else if(b==1) {return "FRI";}
        else if(b==2) {return "SAT";}
        else if(b==3) {return "SUN";}
        else if(b==4) {return "MON";}
        else if(b==5) {return "TUE";}
        else if(b==6) {return "WED";}
        return "";
    }
}