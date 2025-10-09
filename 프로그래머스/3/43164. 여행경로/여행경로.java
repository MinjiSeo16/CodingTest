import java.util.*;

class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> route = new LinkedList<>();
    
    public String[] solution(String[][] tickets) {
        
        for(String[] ticket : tickets) {
            String a = ticket[0];
            String b = ticket[1];
            graph.putIfAbsent(a, new PriorityQueue<>());
            graph.get(a).offer(b);
        }
        dfs("ICN");
        return route.toArray(String[]::new);
    }
    
    private void dfs(String current) {
        while(graph.containsKey(current) && !graph.get(current).isEmpty()) {
            String next = graph.get(current).poll();
            dfs(next);
        }
        route.addFirst(current);
    }
}