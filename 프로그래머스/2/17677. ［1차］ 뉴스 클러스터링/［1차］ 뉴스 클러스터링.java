import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        if(str1.length() == 0 && str2.length() == 0) return 65536;
        
        //소문자통일
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        //집합만들기
        String[] s1 = makeSet(str1);
        String[] s2 = makeSet(str2);
        
        //교집합개수
        int secCnt = 0;
        for(int i = 0; i < s1.length; i++) {
            for(int j = 0; j < s2.length; j++) {
                if(s2[j] != null && s1[i].equals(s2[j])) {
                    s2[j] = null;
                    secCnt++;
                    break;
                }
            }
        }
        
        //합집합개수
        int sumCnt = s1.length + s2.length - secCnt;
        if (sumCnt == 0) return 65536;
        
        return (int)((secCnt / (double)sumCnt) * 65536);
    }
    
    private String[] makeSet(String str) {
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i < str.length() - 1; i++) {
            char a = str.charAt(i);
            char b = str.charAt(i + 1);
            if(Character.isLetter(a) && Character.isLetter(b)) {
                list.add("" + a + b);
            }
        }
        
        return list.toArray(String[]::new);
    }
}