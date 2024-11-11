import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int ballSite = 1;
    
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            
            if(ballSite == X){
                ballSite = Y;
            }else if(ballSite == Y){
                ballSite = X;
            }else{
                continue;
            }
        }
        
        System.out.println(ballSite);
    }
}