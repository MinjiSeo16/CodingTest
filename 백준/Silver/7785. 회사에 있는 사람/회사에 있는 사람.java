import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashSet<String> company = new HashSet<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String el = st.nextToken();

			if (el.equals("enter")) {
				company.add(name);
			} else {
				company.remove(name);
			}
		}

		List<String> list = new ArrayList<>(company);
		list.sort(Comparator.reverseOrder());

		StringBuilder sb = new StringBuilder();
		for (String name : list) {
			sb.append(name).append("\n");
		}
        
        System.out.println(sb);
	}
}