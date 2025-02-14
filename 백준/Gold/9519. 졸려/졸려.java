import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        Map<Integer, String> map = new HashMap<>();
        int X = Integer.parseInt(br.readLine());
        String input = br.readLine();
        map.put(0, input);

        for(int i = 1; i <= X; i++){
            StringBuilder sb1 = new StringBuilder();
            for(int j = 0; j < input.length(); j += 2){
                sb1.append(input.charAt(j));
            }

            StringBuilder sb2 = new StringBuilder();
            for(int j = 1; j < input.length(); j += 2){
                sb2.append(input.charAt(j));
            }

            input = sb1.append(sb2.reverse()).toString();
            if(map.get(0).equals(input)){
                input = map.get(X % i);
                break;
            }
            map.put(i, input);
        }

        result.append(input);
        System.out.println(result.toString());
    }
}
