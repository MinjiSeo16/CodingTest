import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String start = br.readLine();
        char startL = start.charAt(0);
        char startR = start.charAt(2);
        String string = br.readLine();
        int count = 0;
        
        Map<Character, int[]> consonantMap = new HashMap<>();
        Map<Character, int[]> vowelMap = new HashMap<>();
        consonantMap.put('q', new int[]{1, 1});
        consonantMap.put('w', new int[]{1, 2});
        consonantMap.put('e', new int[]{1, 3});
        consonantMap.put('r', new int[]{1, 4});
        consonantMap.put('t', new int[]{1, 5});
        consonantMap.put('a', new int[]{2, 1});
        consonantMap.put('s', new int[]{2, 2});
        consonantMap.put('d', new int[]{2, 3});
        consonantMap.put('f', new int[]{2, 4});
        consonantMap.put('g', new int[]{2, 5});
        consonantMap.put('z', new int[]{3, 1});
        consonantMap.put('x', new int[]{3, 2});
        consonantMap.put('c', new int[]{3, 3});
        consonantMap.put('v', new int[]{3, 4});
        
        vowelMap.put('y', new int[]{1, 6});
        vowelMap.put('u', new int[]{1, 7});
        vowelMap.put('i', new int[]{1, 8});
        vowelMap.put('o', new int[]{1, 9});
        vowelMap.put('p', new int[]{1, 10});
        vowelMap.put('h', new int[]{2, 6});
        vowelMap.put('j', new int[]{2, 7});
        vowelMap.put('k', new int[]{2, 8});
        vowelMap.put('l', new int[]{2, 9});
        vowelMap.put('b', new int[]{3, 5});
        vowelMap.put('n', new int[]{3, 6});
        vowelMap.put('m', new int[]{3, 7});
        
        int[] left = consonantMap.get(startL);
        int[] right = vowelMap.get(startR);
        
        for(int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            
            if(consonantMap.containsKey(c)){
                int[] site = consonantMap.get(c);
                int diff = Math.abs(left[0] - site[0]) + Math.abs(left[1] - site[1]);
                count += diff + 1;
                left = site;
            } else{
                int[] site = vowelMap.get(c);
                int diff = Math.abs(right[0] - site[0]) + Math.abs(right[1] - site[1]);
                count += diff + 1;
                right = site;
            }
        }
        
        System.out.println(count);
    }
}