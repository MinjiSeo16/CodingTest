class Solution {
    public int[] solution(int money) {
        int[] result = new int[2];
        int count = money / 5500;
        int rest = money - 5500 * count;
        
        result[0] = count;
        result[1] = rest;
        
        return result;
    }
}