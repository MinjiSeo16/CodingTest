import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int sum = 0;
        Queue<Integer> trucks = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        
        for(int i = 0; i < truck_weights.length; i++){
            trucks.add(truck_weights[i]);
        }
        
        for(int i = 0; i < bridge_length; i++){
            bridge.add(0);
        }
        
        while(!trucks.isEmpty() || sum > 0){
            time++;
            sum -= bridge.poll();
            
            if(!trucks.isEmpty()){
                if(sum + trucks.peek() <= weight){
                    int newTruck = trucks.poll();
                    bridge.add(newTruck);
                    sum += newTruck;
                } else{
                    bridge.add(0);
                }
            }
        }
        
        return time;
    }
}