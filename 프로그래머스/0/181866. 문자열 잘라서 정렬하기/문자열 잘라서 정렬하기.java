import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] str = myString.split("x");
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i < str.length; i++){
            if(!str[i].isEmpty()) list.add(str[i]);
        }
        
        String[] result = list.toArray(new String[list.size()]); 
        Arrays.sort(result);
        return result;
    }
}