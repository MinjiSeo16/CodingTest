class Solution {
    public int[] solution(int[] num_list, int n) {
        int size = (num_list.length % n == 0) ? (num_list.length / n) : (num_list.length / n + 1);
        int[] arr = new int[size];
        int count = 0;
        
        for(int i = 0; i < num_list.length; i += n){
            arr[count++] = num_list[i];
        }
        
        return arr;
    }
}