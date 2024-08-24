import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(" ");
        int N = Integer.parseInt(string[0]);
        int M = Integer.parseInt(string[1]);
        int min = Integer.MAX_VALUE;
        
        char[][] board = new char[N][M];
        
        for(int i=0; i<N; i++){
            String row = br.readLine();
            for(int j=0; j<M; j++){
                board[i][j] = row.charAt(j);
            }
        }
        
        for(int startX = 0; startX <= N - 8; startX++){
            for(int startY = 0; startY <= M - 8; startY++){
                int count_W = 0;
                
                for(int i=0; i<8; i++){
                    for(int j=0; j<8; j++){
                        if((i+j) % 2 == 0){
                            if(board[startX + i][startY + j] != 'W') count_W++;
                        } else{
                            if(board[startX + i][startY + j] != 'B') count_W++;
                        }
                    }
                }
                
                int count_B = 64 - count_W;
                int current_min = Math.min(count_W, count_B);
                
                if(current_min < min) min = current_min;
            }
        }
        
        System.out.println(min);
    }
}