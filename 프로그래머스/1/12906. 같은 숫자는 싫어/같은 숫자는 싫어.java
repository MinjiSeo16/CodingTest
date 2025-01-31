import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < arr.length; i++){
            if(stack.isEmpty() || arr[i] != stack.peek()){
                stack.add(arr[i]);
            }
        }
        
        int[] answer = new int[stack.size()];
        for(int i = answer.length - 1; i >= 0; i--){
            answer[i] = stack.pop();
        }
        
        return answer;
    }
}