class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String[] number = binomial.split(" ");
        int a = Integer.parseInt(number[0]);
        String op = number[1];
        int b = Integer.parseInt(number[2]);
        
        if (op.equals("+")){
            answer = a + b;
        } else if (op.equals("-")){
            answer = a - b;
        } else if (op.equals("*")){
            answer = a * b;
        }
        
        return answer;
    }
}