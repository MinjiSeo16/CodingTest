import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        Set<String> result = new HashSet<>();
        
        dfs(0, user_id, banned_id, new HashSet<>(), result);
        
        return result.size();
    }
    
    private void dfs(int idx, String[] user_id, String[] banned_id, Set<String> selected, Set<String> result){
        if(idx == banned_id.length) {
            List<String> list = new ArrayList<>(selected);
            Collections.sort(list);
            result.add(String.join(",", list));
            return;
        }
        
        for(String user : user_id) {
            if(!selected.contains(user) && match(user, banned_id[idx])) {
                selected.add(user);
                dfs(idx + 1, user_id, banned_id, selected, result);
                selected.remove(user);
            }
        }
    }
    
    private boolean match(String user, String banned) {
        if(user.length() != banned.length()) return false;
        for(int i = 0; i < user.length(); i++) {
            if(banned.charAt(i) == '*') continue;
            if(user.charAt(i) != banned.charAt(i)) return false;
        }
        return true;
    }
}