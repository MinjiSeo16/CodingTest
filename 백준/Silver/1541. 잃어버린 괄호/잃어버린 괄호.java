import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] numbers = input.split("-");
        int minusSum = 0;
        int plusSum = 0;
        int sum = 0;
        
        for(int i = 0; i < numbers.length; i++){
            String[] str = numbers[i].split("\\+");
            for(String number : str){
                if(i == 0){
                    plusSum += Integer.parseInt(number);
                }
                else{
                    minusSum += Integer.parseInt(number);
                }
            }
        }
        
        sum = plusSum - minusSum;
        System.out.println(sum);
    }
}