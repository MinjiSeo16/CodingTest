import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumber = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            strNumber[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strNumber, (a, b) -> (b + a).compareTo(a+b));
        
        StringBuilder result = new StringBuilder();
        for(String str : strNumber){
            result.append(str);
        }
        
        if(result.charAt(0) == '0'){
            return "0";
        }
        
        return result.toString();
    }
}