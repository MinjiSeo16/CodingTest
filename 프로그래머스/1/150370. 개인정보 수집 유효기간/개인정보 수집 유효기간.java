import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        // terms -> map으로 저장
        Map<String, Integer> map = new HashMap<>();
        for(String term : terms) {
            String key = term.substring(0, 1);
            int value = Integer.parseInt(term.substring(2));
            map.put(key, value);
        }
        
        // privacies 파기할 날짜 계산해서 배열에 저장
        String[] endDay = new String[privacies.length];
        for(int i = 0; i < privacies.length; i++) {
            String[] days = privacies[i].split(" ");
            String day = days[0];
            int months = map.get(days[1]);
            calculateDate(day, months, endDay, i);
        }
        
        // 저장한 파기 날짜들이 오늘이라면 list에 추가
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < endDay.length; i++) {
            if(isExpire(endDay[i], today)) {
                list.add(i + 1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private void calculateDate(String day, int months, String[] endDay, int idx) {
        String[] days = day.split("\\.");
        int year = Integer.parseInt(days[0]);
        int month = Integer.parseInt(days[1]) + months;
        int date = Integer.parseInt(days[2]);
        
        if(month > 12) {
            year += (month - 1) / 12;
            month = month % 12;
            if (month == 0) month = 12;
        }
        
        endDay[idx] = "" + year + " " + month + " " + date;
    }
    
    private boolean isExpire(String endDay, String today) {
        String[] end = endDay.split(" ");
        String[] now = today.split("\\.");

        int endYear = Integer.parseInt(end[0]);
        int endMonth = Integer.parseInt(end[1]);
        int endDate = Integer.parseInt(end[2]);

        int nowYear = Integer.parseInt(now[0]);
        int nowMonth = Integer.parseInt(now[1]);
        int nowDate = Integer.parseInt(now[2]);

        if (nowYear > endYear) return true;
        if (nowYear < endYear) return false;

        if (nowMonth > endMonth) return true;
        if (nowMonth < endMonth) return false;

        return nowDate >= endDate;
    }
}