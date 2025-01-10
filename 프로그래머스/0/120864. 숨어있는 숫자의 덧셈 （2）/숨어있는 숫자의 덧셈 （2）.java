class Solution {
    public int solution(String my_string) {
        int result = 0;
        my_string = my_string.replaceAll("[^0-9]", " ");
        String[] s = my_string.split("\\s+");
    
        for(String str : s){
            if(!str.isEmpty()) result += Integer.parseInt(str);
        }
        
        return result;
    }
}