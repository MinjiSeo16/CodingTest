import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int total_count = 153;
        int result_count = 0;

        if (a == b){
            result_count = total_count - (10 - a);
        } else{
            int Rank = (a + b) % 10;

            for(int i=1; i<=10; i++){
                for(int j = i+1; j <= 10; j++){
                    if(Rank > (i + j) % 10){
                        if((i == a && j == b) || (i == b && j == a)){
                            continue;
                        } else if(i == a || j == a || i == b || j == b){
                            result_count += 2;
                        } else{
                            result_count += 4;
                        }
                    }
                }
            }
        }

        System.out.printf("%.3f%n", (double) result_count / total_count);
    }
}
