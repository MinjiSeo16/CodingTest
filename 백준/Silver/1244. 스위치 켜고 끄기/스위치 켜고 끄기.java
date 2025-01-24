import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int switchNumber = Integer.parseInt(reader.readLine()); 
        int[] switches = new int[switchNumber + 1];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= switchNumber; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int studentNumber = Integer.parseInt(reader.readLine());
        for (int i = 0; i < studentNumber; i++) {
            st = new StringTokenizer(reader.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int j = number; j <= switchNumber; j += number) {
                    switches[j] = switches[j] == 0 ? 1 : 0;
                }
            } else if (gender == 2) {
                int left = number; 
                int right = number; 
                while (left > 0 && right <= switchNumber && switches[left] == switches[right]) {
                    left--;
                    right++;
                }
                left++;
                right--;
                for (int j = left; j <= right; j++) {
                    switches[j] = switches[j] == 0 ? 1 : 0;
                }
            }
        }

        for (int i = 1; i <= switchNumber; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}
