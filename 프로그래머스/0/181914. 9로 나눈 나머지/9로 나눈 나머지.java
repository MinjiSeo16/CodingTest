class Solution {
    public int solution(String number) {
        int sum = 0;
        
        for(char c : number.toCharArray()){
            sum += c - '0';
        }
        
        int answer = sum % 9;
        return answer;
    }
}