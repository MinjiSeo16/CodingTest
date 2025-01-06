import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> list = new ArrayList<>();
        String ad = "ad";
        
        for(int i = 0; i < strArr.length; i++){
            if(!(strArr[i].contains(ad))){
                list.add(strArr[i]);
            }
        }
        
        String[] result = new String[0];
        result = list.toArray(result);
        return result;
    }
}