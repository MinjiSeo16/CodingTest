import java.io.*;
import java.util.*;

public class Main {
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int[][] ground;
	static boolean[][] visit;
	static int[][] count;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ground = new int[n][m];
		visit = new boolean[n][m];
		count = new int[n][m];
		int startX = 0, startY = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
				if(ground[i][j] == 2){
					startX = i;
					startY = j;
				}
			}
		}

		bfs(startX, startY);

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(ground[i][j] == 0 || ground[i][j] == 2){
					sb.append("0 ");
				}
                else if(!visit[i][j] && ground[i][j] == 1){
					sb.append("-1 ");
				}
				else sb.append(count[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void bfs(int x, int y){
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x,y});
		visit[x][y] = true;

		while(!q.isEmpty()){
			int[] p = q.poll();
			for(int i = 0; i < 4; i++){
				int nx = p[0] + dx[i];
				int ny = p[1] + dy[i];
				if(0 <= nx && nx < n && 0 <= ny && ny < m && ground[nx][ny] == 1 && !visit[nx][ny]){
					visit[nx][ny] = true;
					q.add(new int[]{nx, ny});
					count[nx][ny] = count[p[0]][p[1]] + 1;
				}
			}
		}
	}
}