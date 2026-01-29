import java.io.*;
import java.util.*;

public class Main {

	static class Tower{
		int height;
		int index;

		Tower(int height, int index) {
			this.height = height;
			this.index = index;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Tower> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for(int i = 1; i <= N; i++) {
			int height = Integer.parseInt(st.nextToken());

			while(!stack.isEmpty() && stack.peek().height < height) {
				stack.pop();
			}

			if(stack.isEmpty()) {
				sb.append(0).append(" ");
			} else {
				sb.append(stack.peek().index).append(" ");
			}

			stack.push(new Tower(height, i));
		}

		System.out.println(sb);
	}
}