import java.util.*;
class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        
        List<int[]> structure = new ArrayList<>();
        
        for(int[] b : build_frame) {
            int x = b[0];
            int y = b[1];
            int a = b[2];
            int bType = b[3];
            
            //설치
            if(bType == 1) {
                structure.add(new int[]{x, y, a});
                if(!isValid(structure)) {
                    structure.remove(structure.size() - 1);
                }
            } else {  //삭제
                int removeIndex = -1;
                for(int i = 0; i < structure.size(); i++) {
                    int[] s = structure.get(i);
                    if(s[0] == x && s[1] == y && s[2] == a) {
                        removeIndex = i;
                        break;
                    }
                }
                if (removeIndex != -1) {
                    int[] removed = structure.remove(removeIndex);
                    if (!isValid(structure)) {
                        structure.add(removed);
                    }
                }
            }
        }
        
        //정렬
        structure.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) return o1[2] - o2[2];
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        
        //배열로변환
        int[][] answer = new int[structure.size()][3];
        for(int i = 0; i < structure.size(); i++) {
            answer[i] = structure.get(i);
        }
        
        return answer;
    }
    
    //구조물이 유효한지 검사
    private boolean isValid(List<int[]> structure) {
        for(int[] s : structure) {
            int x = s[0];
            int y = s[1];
            int a = s[2];
            
            if(a == 0) { //기둥
                if(y == 0
                   || check(structure, x, y - 1, 0)
                   || check(structure, x - 1, y, 1)
                   || check(structure, x, y, 1)) {
                    continue;
                }
                return false;
            }
            else if(a == 1) { //보
                if(check(structure, x, y - 1, 0)
                   || check(structure, x + 1, y - 1, 0)
                   || (check(structure, x - 1, y, 1) && check(structure, x + 1, y, 1))) { 
                    continue;
                }
                return false;
            }
        }
        return true;
    }
    
    //존재여부확인
    private boolean check(List<int[]> structure, int x, int y, int a) {
        for(int[] s : structure) {
            if(s[0] == x && s[1] == y && s[2] == a) return true;
        }
        return false;
    }
}