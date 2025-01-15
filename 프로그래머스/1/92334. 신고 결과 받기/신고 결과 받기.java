import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] count = new int[id_list.length];
        ArrayList<String> stopList = new ArrayList<>();
        ArrayList <ArrayList<String>> reporter = new ArrayList<>();
        int[] result = new int[id_list.length];
        
        for(int i = 0; i < id_list.length; i++){
            reporter.add(new ArrayList<>());
        }

        for(String names : report){
            String[] n = names.split(" ");
            String n1 = n[0];
            String n2 = n[1];
            
            int idx = -1;
            for(int i = 0; i < id_list.length; i++){
                if(id_list[i].equals(n2)){
                    idx = i;
                    break;
                }
            }
            
            boolean isExist = false;
            for(String s : reporter.get(idx)){
                if(s.equals(n1)) isExist = true;
            }
            if(!isExist){
                reporter.get(idx).add(n1);
                count[idx]++;
            }
        }
        
        for(int i = 0; i < count.length; i++){
            if(count[i] >= k) stopList.add(id_list[i]);
        }
        
        for(String str : stopList){
            for(int i = 0; i < id_list.length; i++){
                if(str.equals(id_list[i])){
                    for(String reporterName : reporter.get(i)){
                        for(int j = 0; j < id_list.length; j++){
                            if(reporterName.equals(id_list[j])){
                                result[j]++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        return result;
    }
}