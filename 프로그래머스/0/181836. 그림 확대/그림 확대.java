class Solution {
    public String[] solution(String[] picture, int k) {
        String[] result = new String[picture.length * k];
        int idx = 0;
        
        for(String str : picture){
            StringBuilder sb = new StringBuilder();
            
            for(char c : str.toCharArray()){
                sb.append(String.valueOf(c).repeat(k));
            }
            
            for(int i = 0; i < k; i++){
                result[idx++] = sb.toString();
            }
        }
        
        return result;
        
    }
}