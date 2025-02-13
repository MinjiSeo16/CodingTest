import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Set<String> names = new HashSet<>();
        String game = st.nextToken();
        
        for(int i = 0; i < N; i++){
            names.add(br.readLine());
        }
     
        switch(game){
            case "Y":
                System.out.println(names.size());
                break;
            case "F":
                System.out.println(names.size() / 2);
                break;
            case "O":
                System.out.println(names.size() / 3);
                break;
        }
    }
}