class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int[][] record = new int[friends.length][friends.length];
        int[][] giftIndex = new int[friends.length][3];
        int[] takeCount = new int[friends.length];
        
        for(int i = 0; i < gifts.length; i++){
            String[] gift = gifts[i].split(" ");
            String giver = gift[0];
            String taker = gift[1];
            int giver_idx = 0, taker_idx = 0;
            
            for(int j = 0; j < friends.length; j++){
                if(friends[j].equals(giver)) giver_idx = j;
                if(friends[j].equals(taker)) taker_idx = j;
            }
            record[giver_idx][taker_idx]++;
            giftIndex[giver_idx][0]++;
            giftIndex[taker_idx][1]++;
        }
        
        for(int i = 0; i < giftIndex.length; i++){
            giftIndex[i][2] = giftIndex[i][0] - giftIndex[i][1];
        }
        
        for(int i = 0; i < friends.length - 1; i++){
            for(int j = i + 1; j < friends.length; j++){
                if(record[i][j] > record[j][i]) takeCount[i]++;
                else if(record[i][j] < record[j][i]) takeCount[j]++;
                else{
                    if(giftIndex[i][2] > giftIndex[j][2]) takeCount[i]++;
                    if(giftIndex[i][2] < giftIndex[j][2]) takeCount[j]++;
                }
            }        
        }
        
        int result = 0; 
        for(int i = 0; i < takeCount.length; i++){
            if(result < takeCount[i]) result = takeCount[i];
        }
        
        return result;
    }
}