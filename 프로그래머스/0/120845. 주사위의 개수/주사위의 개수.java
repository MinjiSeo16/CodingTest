class Solution {
    public int solution(int[] box, int n) {
        int result = 0; 
        result = (box[0] / n) * (box[1] / n) * (box[2] / n);
        
        return result;
    }
}