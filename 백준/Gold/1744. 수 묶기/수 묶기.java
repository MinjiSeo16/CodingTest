import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<Integer> negative = new ArrayList<>();
    static ArrayList<Integer> positive = new ArrayList<>();
        
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i = 0; i < N; i++){
            int number = Integer.parseInt(br.readLine());
            if(number == 1){
                sum += 1;
                continue;
            }
            if(number <= 0){
                negative.add(number);
            }
            else{
                positive.add(number);
            }
        }
        
        Collections.sort(negative);
        Collections.sort(positive, Collections.reverseOrder());
        int minusSum = getMaxSum(negative);
        int plusSum = getMaxSum(positive);
        sum += (minusSum + plusSum);
        
        System.out.println(sum);
    }
    
    public static int getMaxSum(ArrayList<Integer> list){
        int sum = 0;
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

        for(int i = 0; i < arr.length - 1; i+=2){
            sum += arr[i] * arr[i + 1];
        }
        
        if(arr.length % 2 != 0){
            sum += arr[arr.length - 1];
        }
        return sum;
    }
}