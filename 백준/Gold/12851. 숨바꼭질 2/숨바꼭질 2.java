import java.util.*;
import java.io.*;

class Main{
    static int n, k;
    static int[] time = new int[100001];
    static int minTime = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n >= k) {
            System.out.println((n - k) + "\n1");
            return;
        }
        
        bfs();
        System.out.println(minTime + "\n" + count);
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(n);
        time[n] = 1;

        while(!queue.isEmpty()){
            int current = queue.poll();
            
            if(minTime < time[current]) return;

            int[] nextPositions = {current-1, current+1, 2*current};
            for(int next : nextPositions){
                if(next < 0 || next > 100000) continue;
                if(next == k){
                    minTime = time[current];
                    count++;
                }
                if(time[next] == 0 || time[next] == time[current] + 1){
                    queue.add(next);
                    time[next] = time[current] + 1;
                }
            }
        }
    }
}