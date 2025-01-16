class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int endTime = attacks[attacks.length - 1][0];
        int strength = health;
        int success = 0;
        int time = bandage[0];
        int extraRecover = bandage[2];
        int secondRecover = bandage[1];
        int attackIndex = 0;

        for(int i = 0; i <= endTime; i++){
            if(attackIndex < attacks.length && i == attacks[attackIndex][0]){
                strength -= attacks[attackIndex][1];
                if(strength < 0) return -1;
                success = 0;
                attackIndex++;
            } 
            else{
                if(i != 0) success++;
                
                if(strength < health){
                    strength += secondRecover;
                    
                    if(success == time){
                        strength += extraRecover;
                        success = 0;
                    }
                    
                    if(strength > health) strength = health;
                }
            }
        }
        
        return strength <= 0 ? -1 : strength;
    }
}