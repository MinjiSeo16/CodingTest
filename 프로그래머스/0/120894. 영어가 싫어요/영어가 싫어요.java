class Solution {
    public long solution(String numbers) {
        long result = 0;
        
        numbers = numbers.replace("zero","0");
        numbers = numbers.replace("one","1");
        numbers = numbers.replace("two","2");
        numbers = numbers.replace("three","3");
        numbers = numbers.replace("four","4");
        numbers = numbers.replace("five","5");
        numbers = numbers.replace("six","6");
        numbers = numbers.replace("seven","7");
        numbers = numbers.replace("eight","8");
        numbers = numbers.replace("nine","9");
        
        result = Long.parseLong(numbers);
        return result;
    }
}