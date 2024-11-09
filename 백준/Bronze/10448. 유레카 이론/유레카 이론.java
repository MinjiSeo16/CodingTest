import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int arr[] = new int[45];
        for(int i=1; i<45; i++){
            arr[i] = i * (i+1) / 2;
        }
        
        for(int i=0; i<T; i++){
            int K = Integer.parseInt(br.readLine());
            boolean found = false;
            
            for(int j=1; j<45 && !found; j++){
                for(int k=1; k<45 && !found; k++){
                    for(int h=1; h<34 && !found; h++){
                        if(K == arr[j] + arr[k] + arr[h]){
                            found = true;
                        }
                    }
                }
            }
            
            if(found){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}