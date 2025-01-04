class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        char[] arr = my_string.toCharArray();
        
        for(int i =  arr.length - n; i <= arr.length - 1; i++){
            answer += arr[i];
        }
        
        return answer;
    }
}