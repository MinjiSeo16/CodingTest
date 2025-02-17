class Solution {
    public int solution(int[] players, int m, int k) {
        int result = 0; 
        int[] server = new int[24]; 
        
        for(int i = 0; i < players.length; i++){
            int need = players[i] / m;
            int current = server[i];
            
            if(current < need){
                int newServer = need - current;
                result += newServer;
                
                for(int j = i; j < Math.min(24, i + k); j++){
                    server[j] += newServer;
                }
            }
        }
        
        return result;
    }
}