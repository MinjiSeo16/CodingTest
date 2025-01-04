class Solution {
    public int[] solution(int[] num_list, int n) {
        int size = num_list.length - n + 1;
        int[] result = new int[size];
        int count = 0;
        
        for(int i = n - 1; i < num_list.length; i++){
            result[count++] = num_list[i];
        }
        
        return result;
    }
}