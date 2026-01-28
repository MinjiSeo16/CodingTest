import java.util.Scanner;

public class Main {

	static int N, K;
	static int[] belt;
	static boolean[] robot;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		belt = new int[2 * N];
		robot = new boolean[N];

		for (int i = 0; i < 2 * N; i++) {
			belt[i] = sc.nextInt();
		}

		int step = 0;
		while (true) {
			step++;
			rotate();
			moveRobots();
			putRobot();

			if (countZero() >= K) break;
		}

		System.out.println(step);
	}

	//벨트 + 로봇 회전
	private static void rotate() {
		int last = belt[2 * N - 1];
		for (int i = 2 * N - 1; i > 0; i--) {
			belt[i] = belt[i - 1];
		}
		belt[0] = last;

		for (int i = N - 1; i > 0; i--) {
			robot[i] = robot[i - 1];
		}
		robot[0] = false;
		robot[N - 1] = false;
	}

	//로봇 이동
	private static void moveRobots() {
		for (int i = N - 1; i > 0; i--) {
			if(robot[i - 1] && !robot[i] && belt[i] > 0) {
				robot[i] = true;
				robot[i - 1] = false;
				belt[i]--;
			}
		}
		robot[N - 1] = false;
	}

	//로봇 올리기
	private static void putRobot() {
		if(belt[0] > 0) {
			robot[0] = true;
			belt[0]--;
		}
	}

	private static int countZero() {
		int cnt = 0;
		for(int x : belt) {
			if(x == 0) cnt++;
		}
		return cnt;
	}
}