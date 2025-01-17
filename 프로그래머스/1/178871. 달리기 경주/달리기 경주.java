import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> rank = new HashMap<>();
        
        for(int i = 0; i < players.length; i++){
            rank.put(players[i], i + 1);
        }
        
        for(String name : callings){
            int idx = rank.get(name);
            
            String tmp = players[idx - 2];
            players[idx - 2] = players[idx - 1];
            players[idx - 1] = tmp;
            
            rank.put(players[idx - 2], idx - 1);
            rank.put(players[idx - 1], idx);
        }
        
        return players;
    }
}