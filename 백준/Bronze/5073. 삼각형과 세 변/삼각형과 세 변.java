import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if(a == 0 && b == 0 && c == 0) break;
            
            int[] triangle = {a, b, c};
            Arrays.sort(triangle);
            a = triangle[0];
            b = triangle[1];
            c = triangle[2];
            
            if(c >= a + b){
                System.out.println("Invalid");
            } 
            else if(a == b && b == c && a == c){
                System.out.println("Equilateral");
            } 
            else if(a == b || b == c || c == a){
                System.out.println("Isosceles");
            } 
            else {
                System.out.println("Scalene");
            }
        }
    }
}
