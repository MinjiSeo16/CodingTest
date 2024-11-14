import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int maxProfit = 0;
        
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        
        maxProfit = calculateProfit(1,0,N,T,P);
        System.out.println(maxProfit);
    }
    
    public static int calculateProfit(int day, int profit, int N, int[] T, int[] P){
        if(day > N){
            return profit;
        }
        
        int profitWithoutConsult = calculateProfit(day+1, profit, N, T, P);
        int profitWithConsult = 0;
        if(day + T[day] - 1 <= N){
            profitWithConsult = calculateProfit(day+T[day], profit+P[day], N, T, P);
        }
        return Math.max(profitWithoutConsult, profitWithConsult);
    }
}