import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        for(char c : a.toCharArray()){
            if(Character.isUpperCase(c)){
                char lower = Character.toLowerCase(c);
                System.out.print(lower);
            } else{
                char upper = Character.toUpperCase(c);
                System.out.print(upper);
            }
        }
    }
}