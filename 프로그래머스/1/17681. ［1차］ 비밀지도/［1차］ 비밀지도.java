class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb = new StringBuilder();
        char[][] arr3 = new char[n][n];
        char[][] arr4 = new char[n][n];
        
        for(int i = 0; i < n; i++) {
            String binary3 = Integer.toBinaryString(arr1[i]);
            String binary4 = Integer.toBinaryString(arr2[i]);
            
            while(binary3.length() < n) {
                binary3 = "0" + binary3;
            }
            while(binary4.length() < n) {
                binary4 = "0" + binary4;
            }
            
            arr3[i] = binary3.toCharArray();
            arr4[i] = binary4.toCharArray();
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr3[i][j] == '0' && arr4[i][j] == '0'){
                    sb.append(' ');
                } else {
                    sb.append('#');
                }
            }
            answer[i] = sb.toString();
            sb.setLength(0);
        }
        
        return answer;
    }
}