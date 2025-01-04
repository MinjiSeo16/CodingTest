class Solution {
    public int solution(String my_string, String is_prefix) {
        String[] arr = new String[my_string.length()];
        boolean isValid = false;
        
        for(int i = 0; i < my_string.length(); i++){
            arr[i] = my_string.substring(0, my_string.length() - i);
        }
        
        for(int i = 0; i < arr.length; i++){
            if(is_prefix.equals(arr[i])) isValid = true;
        }
        
        return isValid ? 1 : 0;
    }
}