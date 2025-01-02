class Solution {
    public int solution(int a, int b) {
        String ab = ""+ a+b;
        String ba = ""+ b+a;

        int AB = Integer.valueOf(ab);
        int BA = Integer.valueOf(ba);

        return AB > BA ? AB : BA;
    }
}