import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> flower = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());
            flower.add(new int[]{convertToDay(startMonth, startDay), convertToDay(endMonth, endDay)});
        }
        
        flower.sort((a, b) -> {
            if(a[0] == b[0]){
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        int start = convertToDay(3,1);
        int end = convertToDay(11,30);
        int count = 0;
        int maxEnd = start;
        int newMaxEnd = maxEnd;
        
        for(int i = 0; i < N; i++){
            if(flower.get(i)[0] > maxEnd){
                
                if(newMaxEnd == maxEnd){
                    System.out.println(0);
                    return;
                }
                
                maxEnd = newMaxEnd;
                count++;
                
                if(maxEnd > end){
                    System.out.println(count);
                    return;
                }
            }
            
            if(flower.get(i)[0] <= maxEnd){
                newMaxEnd = Math.max(newMaxEnd, flower.get(i)[1]);
            }
        }
        
        if(newMaxEnd > maxEnd){
            count++;
            maxEnd = newMaxEnd;
        }
        
        if(maxEnd > end){
            System.out.println(count);
        } else{
            System.out.println(0);
        }
    }
    
    public static int convertToDay(int month, int day){
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDay = 0;
        for(int i = 1; i < month; i++){
            totalDay += days[i];
        }
        return totalDay + day;
    }
}
