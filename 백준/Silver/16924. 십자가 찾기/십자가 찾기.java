import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static char[][] arr;
    static boolean[][] visited;
    static List<int[]> result = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = line.charAt(j);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == '*'){
                    find(i,j);
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == '*' && !visited[i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(result.size());
        for(int[] r : result){
            System.out.println(r[0] + " " + r[1] + " " + r[2]);
        }
    }

    public static void find(int x, int y){
        int size = 0;
        while(true){
            int up = x - size - 1;
            int down = x + size + 1;
            int left = y - size - 1;
            int right = y + size + 1;

            if(up < 0 || down >= N || left < 0 || right >= M) break;
            if(arr[up][y] != '*' || arr[down][y] != '*' || arr[x][left] != '*' || arr[x][right] != '*') break;

            size++;
        }

        if(size > 0){
            visited[x][y] = true;
            for(int i = size; i > 0; i--){
                result.add(new int[]{x + 1, y + 1, i});
                visited[x - i][y] = true;
                visited[x + i][y] = true;
                visited[x][y - i] = true;
                visited[x][y + i] = true;
            }
        }
    }
}