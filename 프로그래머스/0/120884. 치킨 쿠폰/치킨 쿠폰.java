class Solution {
    public int solution(int chicken) {
        int service = 0, coupon = chicken;
        
        while(coupon >= 10){
            int service1 = coupon / 10;
            service += service1;
            coupon = coupon % 10 + service1;
        }
        
        return service;
    }
}