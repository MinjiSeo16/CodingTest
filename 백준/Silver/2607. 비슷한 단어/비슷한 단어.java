import java.io.*;

public class Main{
	static String word;
	static int count = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		word = br.readLine();

		for(int i = 0; i < N - 1; i++){
			String curWord = br.readLine();
			if(isSimilar(curWord)){
				count++;
			}
		}

		System.out.println(count);
	}

	static boolean isSimilar(String curWord){
		int len1 = word.length();
		int len2 = curWord.length();

		if(Math.abs(len1 - len2) > 1){
			return false;
        }

		int[] freq1 = new int[26];
		int[] freq2 = new int[26];

		for(char c : word.toCharArray()){
			freq1[c - 'A']++;
		}
		for(char c : curWord.toCharArray()){
			freq2[c - 'A']++;
		}

		int diffCount = 0;
		for(int i = 0; i < 26; i++){
			diffCount += Math.abs(freq1[i] - freq2[i]);
		}
 
		if(diffCount == 0) return true;
		if(diffCount == 1) return true;
		if(diffCount == 2 && len1 == len2) return true;

		return false;
	}
}