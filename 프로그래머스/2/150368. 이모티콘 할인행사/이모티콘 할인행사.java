class Solution {
    static int[] discount = {10,20,30,40};
    static int maxUser, maxSales;
    
    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0, new int[emoticons.length], users, emoticons);
        return new int[]{maxUser, maxSales};
    }
    
    //모든 이모티콘 할인 조합 탐색
    private void dfs(int depth, int[] rates, int[][] users, int[] emoticons) {
        if(depth == emoticons.length) {
            calculate(rates, users, emoticons);
            return;
        }
        
        for(int d : discount) {
            rates[depth] = d;
            dfs(depth + 1, rates, users, emoticons);
        }
    }
    
    //힐인율에 따라 가입자수와 매출 계산
    private void calculate(int[] rates, int[][] users, int[] emoticons) {
        int userCount = 0;
        int totalSales = 0;
        
        for(int[] user : users) {
            int rate = user[0];
            int price = user[1];
            int sum = 0;
            
            for(int i = 0; i < emoticons.length; i++) {
                if(rates[i] >= rate) {
                    sum += emoticons[i] * (100 - rates[i]) / 100;
                }
            }
            
            if(sum >= price) {
                userCount++;
            } else {
                totalSales += sum;
            }
        }
        
        if (userCount > maxUser) {
            maxUser = userCount;
            maxSales = totalSales;
        } else if(userCount == maxUser && totalSales > maxSales) {
            maxSales = totalSales;
        }
    }
}