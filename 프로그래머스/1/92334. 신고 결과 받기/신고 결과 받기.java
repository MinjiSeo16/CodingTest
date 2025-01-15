import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] count = new int[id_list.length];
        ArrayList<Integer> stopList = new ArrayList<>();
        ArrayList <ArrayList<Integer>> reporter = new ArrayList<>();
        int[] result = new int[id_list.length];
        
        for(int i = 0; i < id_list.length; i++){
            reporter.add(new ArrayList<>());
        }

        for(String names : report){
            String[] n = names.split(" ");
            String n1 = n[0];
            String n2 = n[1];
            
            int idx1 = -1, idx2 = -1;
            for(int i = 0; i < id_list.length; i++){
                if(id_list[i].equals(n2)) idx2 = i;
                if(id_list[i].equals(n1)) idx1 = i;
            }
            
            boolean isExist = false;
            for(int number : reporter.get(idx2)){
                if(number == idx1) isExist = true;
            }
            if(!isExist){
                reporter.get(idx2).add(idx1);
                count[idx2]++;
            }
        }
        
        for(int i = 0; i < count.length; i++){
            if(count[i] >= k) stopList.add(i);
        }
        
        for(int n : stopList){
            for(int reporterNum : reporter.get(n)){
                result[reporterNum]++;
            }
        }
        
        return result;
    }
}