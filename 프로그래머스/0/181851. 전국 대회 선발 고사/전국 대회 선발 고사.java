import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int size = 0;
        int a = 0, b = 0, c = 0;
        
        for(int i = 0; i < attendance.length; i++){
            if(attendance[i]) size++;
        }
        int[] arr = new int[size];
        
        int cnt = 0;
        for(int i = 0; i < rank.length; i++){
            if(attendance[i]) arr[cnt++] = rank[i];
        }
        
        Arrays.sort(arr);
        for(int i = 0; i < rank.length; i++){
            if(arr[0] == rank[i]) a = i;
            if(arr[1] == rank[i]) b = i;
            if(arr[2] == rank[i]) c = i;
        }
        
        int sum = 10000 * a + 100 * b + c;
        return sum;
    }
}