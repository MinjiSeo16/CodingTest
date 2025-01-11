class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] newlist = new int[numlist.length];
        int[] result = new int[numlist.length];
        int count = 0;
        int k = 0; 
        
        for(int i = 0; i < numlist.length; i++){
            newlist[i] = Math.abs(numlist[i] - n);
        }
        
        while(k < numlist.length){
            int idx = -1;
            int min = 10000;
            
            for(int i = 0; i < numlist.length; i++){
                if(min > newlist[i] || (min == newlist[i] && (idx == -1 || numlist[i] > numlist[idx]))){
                    min = newlist[i];
                    idx = i;
                }
            }
            
            result[count++] = numlist[idx];
            newlist[idx] = 10000; 
            k++;
        }
        
        return result;
    }
}