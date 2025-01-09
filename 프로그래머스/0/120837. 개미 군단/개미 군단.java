class Solution {
    public int solution(int hp) {
        int count = 0;
        
        int x = hp / 5;
        int y = (hp % 5) / 3;
        int z = hp - (x * 5 + y * 3);
        
        count = x + y + z;
        return count;
    }
}