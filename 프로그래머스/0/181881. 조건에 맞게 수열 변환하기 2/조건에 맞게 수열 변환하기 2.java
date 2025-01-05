import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int x = 0;
        int[] prevArr = arr.clone();
        int[] currentArr;
        
        while(true){
            currentArr = prevArr.clone();
            for (int i = 0; i < currentArr.length; i++){
                if (currentArr[i] >= 50 && currentArr[i] % 2 == 0){
                    currentArr[i] /= 2;
                } else if(currentArr[i] < 50 && currentArr[i] % 2 != 0){
                    currentArr[i] = currentArr[i] * 2 + 1;
                }
            }
            x++;
            
            if(Arrays.equals(prevArr, currentArr)){
                break;
            }
            
            prevArr = currentArr;
        }
        
        return x - 1;
    }
}