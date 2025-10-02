class Solution {
    private static final char[][] keypad = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'},
        {'*', '0', '#'}
    };
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        //현재 엄지 손가락 위치
        int[] cntL = new int[]{3,0};
        int[] cntR = new int[]{3,2};
        
        for(int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            int[] site = findSite(n);
            int row = site[0];
            int col = site[1];
            
            //무조건 왼쪽 클릭
            if(n == 1 || n == 4 || n == 7) {
                sb.append("L");
                cntL[0] = row;
                cntL[1] = col;
            }
            
            //무조건 오른쪽 클릭
            else if(n == 3 || n == 6 || n == 9) {
                sb.append("R");
                cntR[0] = row;
                cntR[1] = col;
            }
            
            //무조건 오른쪽 클릭
            else {
                int difR = Math.abs(cntR[0] - row) + Math.abs(cntR[1] - col);
                int difL = Math.abs(cntL[0] - row) + Math.abs(cntL[1] - col);
                if(difR < difL) {   //오른쪽이 더 가까울 때
                    sb.append("R");
                    cntR[0] = row;
                    cntR[1] = col;
                } else if(difR > difL) {   //왼쪽이 더 가까울 때
                    sb.append("L");
                    cntL[0] = row;
                    cntL[1] = col;
                } else {  //거리가 똑같을 때
                    //오른손잡이 
                    if(hand.equals("right")) { 
                        sb.append("R");
                        cntR[0] = row;
                        cntR[1] = col;
                    } else { //왼손잡이
                        sb.append("L");  
                        cntL[0] = row;
                        cntL[1] = col;
                    }
                }
            }
        }
        
        return sb.toString();
    }
    
    //숫자 위치 찾기
    private int[] findSite(int num) {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                if(keypad[i][j] - '0' == num) {
                    return new int[]{i,j};
                }
            }
        }
        
        return new int[]{0,0};
    }
}