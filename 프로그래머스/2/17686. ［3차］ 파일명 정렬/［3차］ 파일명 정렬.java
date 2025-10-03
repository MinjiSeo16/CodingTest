import java.util.Arrays;

class Solution {
    public String[] solution(String[] files) {
        
        Arrays.sort(files, (o1, o2) -> {
            //head
            String head1 = o1.split("[0-9]")[0];
            String head2 = o2.split("[0-9]")[0];
            int headCompare = head1.toLowerCase().compareTo(head2.toLowerCase()); 
            if(headCompare != 0) return headCompare;
            
            //number
            String num1 = o1.substring(head1.length()).split("[^0-9]")[0];
            String num2 = o2.substring(head2.length()).split("[^0-9]")[0];
            int numberCompare = Integer.parseInt(num1) - Integer.parseInt(num2);
            if(numberCompare != 0) return numberCompare;
            
            //원래 순서 유지
            return 0; 
        });
    
        return files;
    }
}