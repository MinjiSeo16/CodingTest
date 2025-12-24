import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] result = new int[commands.length];
            
        for(int idx = 0; idx < commands.length; idx++) {
            int i = commands[idx][0];
            int j = commands[idx][1];
            int k = commands[idx][2];
            
            int[] arr = new int[j - i + 1];
            int cnt = 0;
            for(int s = i - 1; s < j; s++) {
                arr[cnt++] = array[s];
            }
            
            Arrays.sort(arr);
            result[idx] = arr[k - 1];
        }
        
        return result;
    }
}