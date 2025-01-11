class Solution {
    public int[] solution(int num, int total) {
        int[] result = new int[num];
        int start = 1;
        
        while(true){
            int sum = 0;
            
            for(int i = start; i < start + num; i++){sum += i;}
            if(sum == total){
                int count = 0;
                for(int j = start; j < start + num; j++){
                    result[count++] = j;
                }
                break;
            }
            else{
                if(sum > total) start--;
                else start++;
            }
        }
        
        return result;
    }
}