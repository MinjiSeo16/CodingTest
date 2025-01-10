class Solution {
    public String[] solution(String my_str, int n) {
        int l = my_str.length();
        int size = (l % n == 0) ? (l / n) : (l / n + 1);
        String[] result = new String[size];
        int count = 0;
        
        for(int i = 0; i < l; i += n){
            result[count++] = my_str.substring(i, Math.min(i + n, l));
        }
        
        return result;
    }
}