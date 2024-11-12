import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[14];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<14; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int B = BNP(N, arr);
        int T = TIMING(N, arr);
        if(B == T){
            System.out.println("SAMESAME");
        } else if(B < T){
            System.out.println("TIMING");
        } else{
            System.out.println("BNP");
        }
    }
    
    public static int BNP(int N, int[] arr){
        int cash = N;
        int stock_count = 0;
        for(int i=0; i<14; i++){
            if(arr[i] <= cash){
                int count = cash / arr[i];
                stock_count += count;
                cash -= count * arr[i];
            }
        }
        return cash + (stock_count * arr[13]);
    }
    
    public static int TIMING(int N, int[] arr){
        int cash = N;
        int stock_count = 0;
        int upDay = 0; 
        int downDay = 0;
        
        for(int i=1; i<14; i++){
            if(arr[i] > arr[i-1]){
                upDay++;
                downDay = 0;
            } else if(arr[i] < arr[i-1]){
                downDay++;
                upDay = 0;
            } else{
                upDay = 0;
                downDay = 0;
            }
            
            if(upDay >= 3 && stock_count > 0){
                cash += stock_count * arr[i];
                stock_count = 0;
            }
            if(downDay >= 3 && cash >= arr[i]){
                int count = cash / arr[i];
                stock_count += count;
                cash -= count * arr[i];
            }
        }
        return cash + (stock_count * arr[13]);
    }
}