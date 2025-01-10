class Solution {
    public int solution(String my_string) {
        String[] cal = my_string.split(" ");
        int result = Integer.parseInt(cal[0]);
        
        for(int i = 1; i < cal.length; i+=2){
            String op = cal[i];
            int number = Integer.parseInt(cal[i + 1]);
            
            if(op.equals("+")){
                result += number;
            } else if(op.equals("-")){
                result -= number;
            }
        }
        
        return result;
    }
}