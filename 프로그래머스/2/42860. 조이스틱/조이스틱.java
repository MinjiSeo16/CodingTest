class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        
        for(int i = 0; i < len; i++) {
            char c = name.charAt(i);
            int up = c - 'A';
            int down = 'Z' - c + 1;
            answer += Math.min(up, down);
        }
        
        //오른쪽으로만 끝까지 이동
        int move = len - 1;
        
        for(int i = 0; i < len; i++) {
            int next = i + 1;
            
            while(next < len && name.charAt(next) == 'A') {
                next++;
            }
            
            //오른쪽으로 갔다가 되돌아오는 경우
            int right = i * 2 + (len - next);
            
            //왼쪽으로 갔다가 되돌아오는 경우
            int left = (len - next) * 2 + i;
            
            move = Math.min(move, Math.min(right, left));
        }
        
        return answer + move;
    }
}