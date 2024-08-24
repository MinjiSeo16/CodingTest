import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int count = 0; //종말의 수가 포함된 숫자의 개수 
        int number = 666; //시작할 숫자 
        
        while(count < n){
            String str = Integer.toString(number);
            
            if(str.contains("666")){
                count++;  //문자열에 666있는지 검사 
            }
            if(count == n){
                System.out.println(number);
                return;
            }
            number++;
        }
    }
}