import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        
        for(int idx = 0; idx < commands.length; idx++){
            int i = commands[idx][0];
            int j = commands[idx][1];
            int k = commands[idx][2];
            
            int[] newArray = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(newArray);
            int value = newArray[k - 1];
            result[idx] = value;
        }
        
        return result;
    }
}