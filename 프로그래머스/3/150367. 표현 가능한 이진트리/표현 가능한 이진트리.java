class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);
            String process = processToFullBinaryTree(binary);
            answer[i] = isValidBinaryTree(process) ? 1 : 0;
        }
            
        return answer;
    }
    
    private String processToFullBinaryTree(String binary) {
        int len = binary.length();
        int h = 0;
        while((1 << h) - 1 < len) {
            h++;
        }
        
        int fullLength = (1 << h) - 1;
        int padding = fullLength - len;       
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < padding; i++) {
            sb.append('0');
        }
        
        sb.append(binary);
        return sb.toString();
    }
    
    private boolean isValidBinaryTree(String s) {
        if(s.length() == 1) return true;
        
        int mid = s.length() / 2;
        char root = s.charAt(mid);
        
        String left = s.substring(0,mid);
        String right = s.substring(mid + 1);
        
        if(root == '0') {
            if(left.contains("1") || right.contains("1")) {
                return false;
            }
        }
        
        return isValidBinaryTree(left) && isValidBinaryTree(right);
    }
}