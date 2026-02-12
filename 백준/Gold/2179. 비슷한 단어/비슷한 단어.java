import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        
		String[] words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}

		int maxLcp = 0;
		int sIndex = 0;
		int tIndex = 1;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				int lcp = getLCP(words[i], words[j]);
				if (lcp > maxLcp) {
					maxLcp = lcp;
					sIndex = i;
					tIndex = j;
				}
			}
		}

		System.out.println(words[sIndex]);
		System.out.println(words[tIndex]);
	}

	private static int getLCP(String a, String b) {
		int len = 0;
		int minLength = Math.min(a.length(), b.length());
		while (len < minLength && a.charAt(len) == b.charAt(len)) {
			len++;
		}

		return len;
	}
}