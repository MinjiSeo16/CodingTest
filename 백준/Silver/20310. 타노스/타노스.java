import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int zeroCnt = 0, oneCnt = 0;
        
        for(char c : S.toCharArray()){
            if(c == '1') oneCnt++;
            if(c == '0') zeroCnt++;
        }
        
        zeroCnt /= 2;
        oneCnt /= 2;
        
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '1' && oneCnt > 0){
                oneCnt--;
            }
            else sb1.append(S.charAt(i));
        }
        
        for(int i = sb1.length() - 1; i >= 0; i--){
            if(sb1.charAt(i) == '0' && zeroCnt > 0){
                zeroCnt--;
            }
            else sb2.append(sb1.charAt(i));
        }
        
        System.out.println(sb2.reverse());
    }
}