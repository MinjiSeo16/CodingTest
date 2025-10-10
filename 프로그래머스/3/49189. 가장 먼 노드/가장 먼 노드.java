import java.util.*;

class Solution {
    LinkedList<Integer>[] graph;
    
    public int solution(int n, int[][] edge) {
        
        //인접리스트
        graph = new LinkedList[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        
        for(int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        //1과의 거리 계산
        int[] distance = bfs(n);
        
        //최대 거리
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            maxDist = Math.max(maxDist, distance[i]);
        }
        
        //최대 거리 노드 수
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(maxDist == distance[i]) {
                count ++;
            }
        }
        
        return count;
    }
    
    private int[] bfs(int n) {
        int[] distance = new int[n + 1];
        boolean[] visit = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(1);
        visit[1] = true;
        distance[1] = 0;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int next : graph[now]) {
                if(!visit[next]) {
                    visit[next] = true;
                    distance[next] = distance[now] + 1;
                    queue.add(next);
                }
            }
        }
        
        return distance;
    }
}