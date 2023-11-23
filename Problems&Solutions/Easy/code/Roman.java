package code;
public class Roman {
    public int romanToInt(String s){
        //convert roman to int
        //I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
        /*Plan: First handle the simple cases,
         * such as 1, 5, 10, 50, 100, 500, 1000
         * then move to more complex cases
         * such as 4, 9, 40, 90, 400, 900
         */
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'I'){
                if(i + 1 < s.length() && s.charAt(i + 1) == 'V'){
                    result += 4;
                    i++;
                }
                else if(i + 1 < s.length() && s.charAt(i + 1) == 'X'){
                    result += 9;
                    i++;
                }
                else{
                    result += 1;
                }
            }
            else if(s.charAt(i) == 'V'){
                result += 5;
            }
            else if(s.charAt(i) == 'X'){
                if(i + 1 < s.length() && s.charAt(i + 1) == 'L'){
                    result += 40;
                    i++;
                }
                else if(i + 1 < s.length() && s.charAt(i + 1) == 'C'){
                    result += 90;
                    i++;
                }
                else{
                    result += 10;
                }
            }
            else if(s.charAt(i) == 'L'){
                result += 50;
            }
            else if(s.charAt(i) == 'C'){
                if(i + 1 < s.length() && s.charAt(i + 1) == 'D'){
                    result += 400;
                    i++;
                }
                else if(i + 1 < s.length() && s.charAt(i + 1) == 'M'){
                    result += 900;
                    i++;
                }
                else{
                    result += 100;
                }
            }
            else if(s.charAt(i) == 'D'){
                result += 500;
            }
            else if(s.charAt(i) == 'M'){
                result += 1000;
            }
        }


        return 0;
    }
}
