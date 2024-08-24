import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int count = 0;
        int number = 666; 
        
        while(count < n){
            String str = Integer.toString(number);
            
            if(str.contains("666")){
                count++; 
            }
            if(count == n){
                System.out.println(number);
                return;
            }
            number++;
        }
    }
}