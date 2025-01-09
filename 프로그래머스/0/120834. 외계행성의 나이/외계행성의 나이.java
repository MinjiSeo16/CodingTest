import java.util.*;

class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> map = new HashMap<>();
        map.put(0,"a");
        map.put(1,"b");
        map.put(2,"c");
        map.put(3,"d");
        map.put(4,"e");
        map.put(5,"f");
        map.put(6,"g");
        map.put(7,"h");
        map.put(8,"i");
        map.put(9,"j");
        
        String s = "" + age;
        for(char c : s.toCharArray()){
            sb.append(map.get(Character.getNumericValue(c)));
        }
        
        return sb.toString();
    }
}