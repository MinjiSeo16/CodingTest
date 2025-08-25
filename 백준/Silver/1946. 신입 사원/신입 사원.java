import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] interviewRank = new int[N + 1]; //index = 서류등수, value = 면접등수

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int doc = Integer.parseInt(st.nextToken());
				int iv = Integer.parseInt(st.nextToken());
				interviewRank[doc] = iv;
			}

			int minIv = Integer.MAX_VALUE;
			int count = 0;
			for (int doc = 1; doc <= N; doc++) {
				int iv = interviewRank[doc];
				if (iv < minIv) {
					count++;
					minIv = iv;
				}
			}
			sb.append(count).append('\n');
		}

		System.out.println(sb.toString());
	}
}