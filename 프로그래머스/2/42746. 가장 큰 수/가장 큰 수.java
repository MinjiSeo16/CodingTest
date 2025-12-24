import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] strNum = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            strNum[i] = numbers[i] + "";
        }
        
        Arrays.sort(strNum, (a, b) -> (b + a).compareTo(a + b)); 
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strNum.length; i++) {
            sb.append(strNum[i]);
        }
        
        if(sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
}