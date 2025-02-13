import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if(N % 4 == 1 || N % 4 == 3){
            System.out.println("SK");
        }
        else{
            System.out.println("CY");
        }
    }
}