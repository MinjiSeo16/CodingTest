import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            
            if(word.equals("push")){
                int k = Integer.parseInt(st.nextToken());
                queue.offer(k);
            } else if(word.equals("pop")){
                sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
            } else if(word.equals("size")){
                sb.append(queue.size()).append("\n");
            } else if(word.equals("empty")){
                sb.append(queue.isEmpty() ? 1 : 0).append("\n");
            } else if(word.equals("front")){
                sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
            } else if (word.equals("back")) {
                sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}