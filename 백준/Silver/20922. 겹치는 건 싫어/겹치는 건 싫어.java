import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] number = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		int[] count = new int[100001];
		int start = 0, end = 0;
		int maxLength = 0;

		while(end < N) {
			if(count[number[end]] < K){
				count[number[end]]++;
				end++;
			}
			else{
				count[number[start]]--;
				start++;
			}
			maxLength = Math.max(maxLength, end - start);
		}
		System.out.println(maxLength);
	}
}