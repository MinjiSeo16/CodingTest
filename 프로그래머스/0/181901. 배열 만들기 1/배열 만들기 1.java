class Solution {
    public int[] solution(int n, int k) {
        int idx = n / k;
        int[] answer = new int[idx];

        for(int i = 0; i < idx; i++){
            answer[i] = k * (i + 1);
        }
        
        return answer;
    }
}