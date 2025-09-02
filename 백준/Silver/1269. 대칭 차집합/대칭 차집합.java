import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		HashSet<Integer> setA = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			setA.add(Integer.parseInt(st.nextToken()));
		}

		HashSet<Integer> setB = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for (int i = 0; i < B; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (!setA.contains(num)) {
				cnt++;
			}
			setB.add(num);
		}

		for (int num : setA) {
			if (!setB.contains(num)) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}