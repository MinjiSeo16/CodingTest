class Solution {
    public int[] solution(int[][] edges) {
        int[] input = new int[1000001];
        int[] output = new int[1000001];
        int center = 0, index1 = 0, index2 = 0, index3 = 0;
        
        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            output[a]++;
            input[b]++;
        }
        
        for(int i = 1; i < 1000001; i++){
            if(output[i] >= 2 && input[i] == 0) center = i;
            else if(output[i] == 0 && input[i] >= 1) index2++;
            else if(output[i] >= 2 && input[i] >= 2) index3++;
        }
        
        index1 = output[center] - index2 - index3;
        
        return new int[]{center, index1, index2, index3};
    }
}