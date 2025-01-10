class Solution {
    public String[] solution(String[] quiz) {
        String[] result = new String[quiz.length];
        
        for(int i = 0; i < quiz.length; i++){
            String[] cal = quiz[i].split(" ");
            int X = Integer.parseInt(cal[0]);
            int Y = Integer.parseInt(cal[2]);
            int Z = Integer.parseInt(cal[4]);
            
            if(cal[1].equals("+")){
                if(X + Y == Z) result[i] = "O";
                else result[i] = "X";
            }
            else if(cal[1].equals("-")){
                if(X - Y == Z) result[i] = "O";
                else result[i] = "X";
            }
        }
        
        return result;
    }
}