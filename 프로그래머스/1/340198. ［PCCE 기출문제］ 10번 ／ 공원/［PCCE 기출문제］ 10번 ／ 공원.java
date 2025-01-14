import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        
        for(int m = mats.length - 1; m >= 0; m--){
            int mat = mats[m];
            
            for(int i = 0; i < park.length; i++){
                for(int j = 0; j < park[0].length; j++){
                    if(park[i][j].equals("-1")){
                        if(check(park, i, j, mat)) return mat;
                    }
                }
            }
        }
        return -1;
    }
    
    public boolean check(String[][] park, int x, int y, int mat){
        if(x + mat > park.length || y + mat > park[0].length) return false;
        
        for(int i = x; i < x + mat; i++){
            for(int j = y; j < y + mat; j++){
                if(!park[i][j].equals("-1")) return false;
            }
        }
        return true;
    }
}