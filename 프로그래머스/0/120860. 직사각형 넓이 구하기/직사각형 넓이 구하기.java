class Solution {
    public int solution(int[][] dots) {
        int result = 0;
        int minX = 256, minY = 256;
        int maxX = -256, maxY = -256;
        
        for(int[] d : dots){
            minX = Math.min(minX, d[0]);
            minY = Math.min(minY, d[1]);
            maxX = Math.max(maxX, d[0]);
            maxY = Math.max(maxY, d[1]);
        }
        
        result = (maxX - minX) * (maxY - minY);
        return result;
    }
}