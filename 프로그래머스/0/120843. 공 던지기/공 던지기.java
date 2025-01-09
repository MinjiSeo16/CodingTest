class Solution {
    public int solution(int[] numbers, int k) {
        int count = 2 * (k - 1);
        int idx = count % numbers.length;
        return numbers[idx];
    }
}