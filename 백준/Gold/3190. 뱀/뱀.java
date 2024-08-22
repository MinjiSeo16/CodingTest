import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[][] board = new int[N][N];
        
        int K = sc.nextInt();
        for(int i=0; i<K; i++){
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            board[r][c] = 1; 
        }
        
        int L = sc.nextInt();
        List<int[]> directions = new ArrayList<>();
        for (int i=0; i<L; i++){
            int X = sc.nextInt();
            char C = sc.next().charAt(0);
            directions.add(new int[]{X, C});
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        int direction = 0; 
        int time = 0;
        int x = 0, y = 0;
        Deque<int[]> snake = new ArrayDeque<>();
        snake.offer(new int[]{x, y});
        board[x][y] = 2; 
        
        int idx = 0;
        while(true){
            time++;
            x += dx[direction];
            y += dy[direction];
            
            if(x < 0 || x >= N || y < 0 || y >= N || board[x][y] == 2){
                System.out.println(time);
                break;
            }

            if(board[x][y] == 1){
                board[x][y] = 2;
                snake.offer(new int[] {x, y});
            } else{
                board[x][y] = 2;
                snake.offer(new int[] {x, y});
                int[] tail = snake.poll();
                board[tail[0]][tail[1]] = 0;
            }

            if(idx < L && time == directions.get(idx)[0]){
                if(directions.get(idx)[1] == 'L'){
                    direction = (direction - 1 + 4) % 4;
                } else{
                    direction = (direction + 1) % 4;
                }
                idx++;
            }
        }
    }
}
