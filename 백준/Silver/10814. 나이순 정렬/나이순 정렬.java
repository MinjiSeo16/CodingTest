import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        String[][] string = new String[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            string[i][0] = st.nextToken();
            string[i][1] = st.nextToken();
        }
        
        Arrays.sort(string, (s1, s2) -> {
            return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
        });
        
        for(int i=0; i<N; i++){
            sb.append(string[i][0] + " " + string[i][1]).append('\n');
        }
        
        System.out.println(sb);
    }
}
