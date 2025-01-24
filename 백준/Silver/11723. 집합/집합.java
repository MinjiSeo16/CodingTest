import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int number = 0;
            if(st.hasMoreTokens()){
                number = Integer.parseInt(st.nextToken());
            }
            
            switch(command){
                case "add":
                    set.add(number);
                    break;
                case "remove":
                    set.remove(number);
                    break;
                case "check":
                    int x = set.contains(number) ? 1 : 0;
                    sb.append(x).append("\n");
                    break;
                case "toggle":
                    if(set.contains(number)){
                        set.remove(number);
                    } else{
                        set.add(number);
                    }
                    break;
                case "all":
                    set.clear();
                    for(int j = 1; j <= 20; j++){
                        set.add(j);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.println(sb);
    }
}