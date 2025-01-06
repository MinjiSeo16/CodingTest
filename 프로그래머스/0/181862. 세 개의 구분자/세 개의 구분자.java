import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] arr = myStr.split("[abc]");
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            if(!arr[i].isEmpty()) list.add(arr[i]);
        }
        
        if(list.size() == 0) return new String[]{"EMPTY"};
        
        return list.toArray(new String[list.size()]);
    }
}