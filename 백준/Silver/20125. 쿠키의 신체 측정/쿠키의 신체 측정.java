import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] c = new char[N][N];
        
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                c[i][j] = line.charAt(j);
            }
        }
        
        int headY = 0, heartX = 0;
        boolean found = false;
        for(int i = 0; i < N && !found; i++){
            for(int j = 0; j < N; j++){
                if(c[i][j] == '*'){
                    heartX = j;
                    headY = i;
                    found = true;
                    break;
                }
            }
        }
        int heartY = headY + 1;
        System.out.println((heartY + 1) + " " + (heartX + 1));
        
        int leftA = 0, rightA = 0;
        for(int i = 0; i < heartX; i++){
            if(c[heartY][i] == '*') leftA++;
        }
        for(int i = heartX + 1; i < N; i++){
            if(c[heartY][i] == '*') rightA++;
        }
        
        int waist = 0, waistY = heartY;
        for(int i = heartY + 1; i < N; i++){
            if(c[i][heartX] == '*'){
                waist++;
                waistY = i;
            } else break;
        }
        
        int leftL = 0, rightL = 0;
        for(int i = waistY + 1; i < N; i++){
            if(heartX - 1 >= 0 && c[i][heartX - 1] == '*') leftL++;
            if(heartX + 1 < N && c[i][heartX + 1] == '*') rightL++;
        }
        
        System.out.println(leftA + " " + rightA + " " + waist + " " + leftL + " " + rightL);
    }
}