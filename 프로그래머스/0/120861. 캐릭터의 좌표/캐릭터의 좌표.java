class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] result = new int[2];
        int X = 0, Y = 0;
        int xLimit = board[0] / 2;
        int yLimit = board[1] / 2;
        
        for(String s : keyinput){
            if(s.equals("left")){
                if(X > -xLimit) X--;
            }
            else if(s.equals("right")){
                if(X < xLimit) X++;
            }
            else if(s.equals("up")){
                if(Y < yLimit) Y++;
            }
            else if(s.equals("down")){
                if(Y > -yLimit) Y--;
            }
        }
        
        result[0] = X;
        result[1] = Y;
        return result;
    }
}