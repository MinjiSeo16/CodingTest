import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; 
        int[] score = {0, 0, 0};
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == one[i % 5]) score[0]++;
            if(answers[i] == two[i % 8]) score[1]++;
            if(answers[i] == three[i % 10]) score[2]++;
        }
        
        int max = 0;
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < 3; i++){
            if(max < score[i]){
                max = score[i];
            }
        }
        
        for(int i = 0; i < 3; i++){
            if(score[i] == max){
                result.add(i + 1);
            }
        }
        
        return result.stream().mapToInt(a -> a).toArray();
    }
}