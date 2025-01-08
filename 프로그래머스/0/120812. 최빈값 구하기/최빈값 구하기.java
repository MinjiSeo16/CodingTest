import java.util.HashMap;

class Solution {
    public int solution(int[] array) {
        int[] arr = new int[1000];
        int max = -1;
        int result = -1;
        
        for(int i = 0; i < array.length; i++){
            arr[array[i]]++;
        }
        
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
                result = i;
            } else if(max == arr[i]) result = -1;
        }
        
        return result;
    }
}