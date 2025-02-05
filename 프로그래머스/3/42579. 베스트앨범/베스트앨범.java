import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalCount = new HashMap<>();
        Map<String, List<int[]>> map = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            totalCount.put(genres[i], totalCount.getOrDefault(genres[i], 0) + plays[i]);
            
            if(!map.containsKey(genres[i])){
                map.put(genres[i], new ArrayList<>());
            }
            map.get(genres[i]).add(new int[]{i, plays[i]});
        }
        
        List<String> list = new ArrayList<>(totalCount.keySet()); 
        list.sort((a, b) -> totalCount.get(b) - totalCount.get(a));
        
        List<Integer> best = new ArrayList<>();
        for(String genre : list){
            List<int[]> songs = map.get(genre);
            songs.sort((a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);
            for(int i = 0; i < Math.min(songs.size(), 2); i++){
                best.add(songs.get(i)[0]);
            }
        }
        
        return best.stream().mapToInt(i -> i).toArray();
    }
}