class Solution {
    public int solution(String my_string) {
        my_string = my_string.replaceAll("[^0-9]", "");
        int sum = 0; 
        
        for(char c : my_string.toCharArray()){
            sum += c - '0';
        }
        
        return sum;
    }
}