import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[5][5];
        boolean[][] check = new boolean[5][5];
        int count = 0;
        
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                int N = Integer.parseInt(st.nextToken());
                count++;
                
                for(int a=0; a<5; a++){
                    for(int b=0; b<5; b++){
                        if(board[a][b] == N){
                            check[a][b] = true;
                            break;
                        }
                    }
                }
                
                if(Bingo(check) >= 3){
                    System.out.println(count);
                    return;
                }
            }
        }
    }
    
    public static int Bingo(boolean[][] check){
        int bingo = 0;
        
        for(int i=0; i<5; i++){
            boolean isBingo = true;
            for(int j=0; j<5; j++){
                if(!check[i][j]){
                    isBingo = false;
                    break;
                }
            }
            if(isBingo) bingo++;
        }
        
        for(int i=0; i<5; i++){
            boolean isBingo = true;
            for(int j=0; j<5; j++){
                if(!check[j][i]){
                    isBingo = false;
                    break;
                }
            }
            if(isBingo) bingo++;
        }
        
        boolean isBingo = true;
        for(int i=0; i<5; i++){
            if(!check[i][i]){
                isBingo = false;
                break;
            }
        }
        if(isBingo) bingo++;
        
        isBingo = true;
        for(int i=0; i<5; i++){
            if(!check[i][4-i]){
                isBingo = false;
                break;
            }
        }
        if(isBingo) bingo++;
        
        return bingo;
    }
}