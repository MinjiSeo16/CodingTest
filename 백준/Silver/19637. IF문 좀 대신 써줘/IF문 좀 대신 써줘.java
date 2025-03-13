import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> titles = new ArrayList<>();
        List<Integer> powers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            if (powers.isEmpty() || powers.get(powers.size() - 1) != power) {
                titles.add(name);
                powers.add(power);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int p = Integer.parseInt(br.readLine());
            int idx = binarySearch(powers, p);
            sb.append(titles.get(idx)).append("\n");
        }

        System.out.print(sb);
    }
    
    static int binarySearch(List<Integer> powers, int target) {
        int left = 0, right = powers.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (powers.get(mid) >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
