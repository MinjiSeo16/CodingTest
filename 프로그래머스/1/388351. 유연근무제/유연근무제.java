class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int result = 0;
        int[] hopeTime = new int[schedules.length];
        
        for(int i = 0; i < schedules.length; i++){
            int time = schedules[i];
            hopeTime[i] = getTime(time);
        }
        
        for(int i = 0; i < timelogs.length; i++){
            int stop = startday;
            boolean pass = true;
            
            for(int j = 0; j < timelogs[i].length; j++){
                if(stop == 8){
                    stop = 1;
                }
                
                if(stop != 6 && stop != 7){
                    if(timelogs[i][j] > hopeTime[i]){
                        pass = false;
                        break;
                    }
                }
                stop++;
            }
            if(pass) result++;
        }
        
        return result;
    }
    
    public static int getTime(int t){
        int h = t / 100;
        int m = t % 100;
        m += 10;
        if(m >= 60){
            h += 1;
            m -= 60;
        }
        return (h * 100) + m;
    }
}