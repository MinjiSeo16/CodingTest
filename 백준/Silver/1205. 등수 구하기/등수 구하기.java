import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int TS = scanner.nextInt();
        int P = scanner.nextInt();
        
        Integer[] scores = new Integer[N];
        for(int i = 0; i < N; i++){
            scores[i] = scanner.nextInt();
        }
        
        Arrays.sort(scores, Collections.reverseOrder());
        
        if(N == P && TS <= scores[N - 1]){
            System.out.println(-1);
        }
        else{
            int rank = 1;
            for(int i = 0; i < N; i++){
                if(TS < scores[i]) rank++;
                else break;
            }
            System.out.println(rank);
        }
    }
}