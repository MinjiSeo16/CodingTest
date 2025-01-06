class Solution {
    public String solution(String myString, String pat) {
        int idx = 0;
        
        for(int i = 0; i < myString.length(); i++){
            if(myString.substring(i).contains(pat)){
                idx = i;
            } else{
                break;
            }
        }
        
        return myString.substring(0, idx + pat.length());
    }
}