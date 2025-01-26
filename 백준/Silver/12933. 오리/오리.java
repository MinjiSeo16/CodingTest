import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sound = br.readLine();
        char[] duck = {'q', 'u', 'a', 'c', 'k'};
        int count = 0;

        if (sound.length() % 5 != 0) {
            System.out.println(-1);
            return;
        }

        boolean[] visit = new boolean[sound.length()];
        int idx;

        for(int i = 0; i < sound.length(); i++){
            if(!visit[i] && sound.charAt(i) == 'q'){
                idx = 0;
                for(int j = i; j < sound.length(); j++){
                    if(!visit[j] && sound.charAt(j) == duck[idx]){
                        visit[j] = true;
                        idx++;
                        if(idx == 5){
                            idx = 0;
                        }
                    }
                }
                if(idx != 0){
                    System.out.println(-1);
                    return;
                }
                count++;
            }
        }

        for(boolean v : visit){
            if(!v){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(count);
    }
}