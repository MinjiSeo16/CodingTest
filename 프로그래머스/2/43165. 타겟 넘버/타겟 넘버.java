class Solution {
    static int[] visit;
    static int[] arr;
    static int goal;
    static int count = 0;
    
    public int solution(int[] numbers, int target) {
        visit = new int[numbers.length];
        arr = numbers;
        goal = target;
        dfs(0, 0);
        
        return count;
    }
    
    static void dfs(int index, int sum){
        if(index == arr.length){
            if(sum == goal){
                count++;
            }
            return;
        }
        
        dfs(index + 1, sum + arr[index]);
        dfs(index + 1, sum - arr[index]);
    }
}