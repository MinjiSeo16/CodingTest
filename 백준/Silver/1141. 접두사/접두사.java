import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<String> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}

		list.sort((a, b) -> Integer.compare(a.length(), b.length()));

		int count = N;
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				if(list.get(j).startsWith(list.get(i))) {
					count--;
					break;
				}
			}
		}

		System.out.println(count);
	}
}