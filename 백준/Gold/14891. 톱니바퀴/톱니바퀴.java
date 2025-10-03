import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] wheel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		wheel = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String line = br.readLine();
			for(int j = 0; j < 8; j++) {
				wheel[i][j] = line.charAt(j) - '0';
			}
		}

		//회전
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int wheelNum = Integer.parseInt(st.nextToken());
			int way = Integer.parseInt(st.nextToken());
			Rotate(wheelNum, way);
		}

		//점수계산
		int score = 0;
		score += (wheel[0][0] == 1) ? 1 : 0;
		score += (wheel[1][0] == 1) ? 2 : 0;
		score += (wheel[2][0] == 1) ? 4 : 0;
		score += (wheel[3][0] == 1) ? 8 : 0;

		System.out.println(score);
	}

	private static void Rotate(int wheelNum, int way) {
		int idx = wheelNum - 1;
		//회전 방향 저장(0, 1, -1)
		int[] dir = new int[4];
		dir[idx] = way;

		//왼쪽검사
		for (int i = idx; i > 0; i--) {
			if (wheel[i][6] != wheel[i - 1][2]) {
				dir[i - 1] = -dir[i];
			} else break;
		}

		//오른쪽검사
		for (int i = idx; i < 3; i++) {
			if (wheel[i][2] != wheel[i + 1][6]) {
				dir[i + 1] = -dir[i];
			}
		}

		//회전
		for (int i = 0; i < 4; i++) {
			if (dir[i] == 1) {  //시계방향
				int temp = wheel[i][7];
				for (int j = 7; j > 0; j--) {
					wheel[i][j] = wheel[i][j - 1];
				}
				wheel[i][0] = temp;
			}

			if (dir[i] == -1) {  //반시계방향
				int temp = wheel[i][0];
				for (int j = 0; j < 7; j++) {
					wheel[i][j] = wheel[i][j + 1];
				}
				wheel[i][7] = temp;
			}
		}

	}
}