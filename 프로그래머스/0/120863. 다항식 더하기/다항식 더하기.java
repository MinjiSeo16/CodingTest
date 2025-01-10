class Solution {
    public String solution(String polynomial) {
        String[] poly = polynomial.split(" ");
        int x = 0, k = 0;
        String result = "";
        
        for(String s : poly){
            if(s.equals("+")){
                continue;
            }
            if(s.contains("x")){
                x += s.equals("x") ? 1 : Integer.parseInt(s.replace("x", ""));
            } else{
                k += Integer.parseInt(s); 
            }
        }
        
        if(x != 0 && k == 0){
            result = x == 1 ? "x" : x + "x";
        } else if(x != 0 && k != 0){
            result = x == 1 ? "x" + " + " + k : x + "x" + " + " + k;
        } else if(x == 0 && k != 0){
            result = String.valueOf(k);
        }
        
        return result;
    }
}