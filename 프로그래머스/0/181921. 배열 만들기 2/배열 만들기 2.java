import java.util.*; 

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();

        for (int i = l; i <= r; i++){
            String str = Integer.toString(i);
            boolean t = true;
            
            for(char c : str.toCharArray()){
                if(c != '5' && c != '0'){
                    t = false;
                    break;
                }
            }
            
            if(t) list.add(i);
        }
        
        if(list.isEmpty()) list.add(-1);
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}