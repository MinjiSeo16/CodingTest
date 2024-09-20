import java.util.*;
import java.io.*;

public class Main{
    
    static class Node{
        char value;
        Node left;
        Node right;
        
        Node(char value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    
    static Node head = new Node('A', null, null);
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            
            makeNode(head, root, left, right);
        }
        
        preorder(head);
        System.out.println();
        
        inorder(head);
        System.out.println();
        
        postorder(head);
        System.out.println();
    }
    
    public static void makeNode(Node node, char root, char left, char right){
        if(node.value == root){
            node.left = (left == '.') ? null : new Node(left, null, null);
            node.right = (right == '.') ? null : new Node(right, null, null);
        } else{
            if(node.left != null) makeNode(node.left, root, left, right);
            if(node.right != null) makeNode(node.right, root, left, right);
        }
    }
    
    public static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value); 
        preorder(node.left);          
        preorder(node.right);         
    }

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);           
        System.out.print(node.value);
        inorder(node.right);         
    }

    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);         
        postorder(node.right);       
        System.out.print(node.value);
    }

}
