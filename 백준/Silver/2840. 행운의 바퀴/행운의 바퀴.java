import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); 

        char[] wheel = new char[N];
        Arrays.fill(wheel, '?');
        boolean[] used = new boolean[26];
        int position = 0;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); 
            char ch = st.nextToken().charAt(0); 

            position = (position - S % N + N) % N;

            if (wheel[position] == ch) {
                continue;  
            } else if (wheel[position] != '?' && wheel[position] != ch) {
                System.out.println("!");
                return;
            }

            if (wheel[position] == '?') {
                if (used[ch - 'A']) {  
                    System.out.println("!");
                    return;
                }
                wheel[position] = ch;
                used[ch - 'A'] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(wheel[(position + i) % N]);
        }
        System.out.println(sb.toString());
    }
}
