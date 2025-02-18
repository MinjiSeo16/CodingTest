import java.io.*;
import java.util.*;

class Student{
    String name;
    int k, e, m;
    
    public Student(String name, int k, int e, int m){
        this.name = name;
        this.k = k;
        this.e = e;
        this.m = m;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<>(); 
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            students.add(new Student(name, k, e, m));
        }
        
        students.sort((s1, s2) -> {
            if(s1.k != s2.k) return s2.k - s1.k;
            if(s1.e != s2.e) return s1.e - s2.e;
            if(s1.m != s2.m) return s2.m - s1.m;
            return s1.name.compareTo(s2.name);
        });
        
        StringBuilder sb = new StringBuilder();
        for(Student s : students){
            sb.append(s.name).append("\n");
        }
        System.out.println(sb);
    }
}