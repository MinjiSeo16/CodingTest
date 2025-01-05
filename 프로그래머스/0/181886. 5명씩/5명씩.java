class Solution {
    public String[] solution(String[] names) {
        int size = (names.length % 5 == 0) ? names.length / 5 : names.length / 5 + 1;
        String[] str = new String[size];
        int idx = 0;
        
        for(int i = 0; i < names.length; i++){
            if(i % 5 == 0){
                str[idx++] = names[i];
            }
        }
        
        return str;
    }
}