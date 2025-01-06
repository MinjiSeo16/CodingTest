class Solution {
    public int solution(String myString, String pat) {
        myString = myString.replace('A', 'x');
        myString = myString.replace('B', 'y');
        myString = myString.replace('x', 'B');
        myString = myString.replace('y', 'A');
        
        if(myString.contains(pat)) return 1;
        else return 0;
    }
}