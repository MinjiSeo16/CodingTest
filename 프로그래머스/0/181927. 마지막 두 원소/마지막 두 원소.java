import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int add = 0;
        int l = num_list.length - 1;
        String answer = "";
        
        if(num_list[l] > num_list[l-1]){
            add = num_list[l] - num_list[l-1];
        }
        else{
            add = num_list[l] * 2;
        }
        
        int[] result = Arrays.copyOf(num_list, l+2);
        result[l+1] = add;
        return result;
    }
}