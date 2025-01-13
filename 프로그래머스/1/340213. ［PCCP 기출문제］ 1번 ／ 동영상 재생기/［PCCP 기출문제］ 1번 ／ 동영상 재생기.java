class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] v = video_len.split(":");
        String[] p = pos.split(":");
        String[] os = op_start.split(":");
        String[] oe = op_end.split(":");
        int videoTime = Integer.parseInt(v[0]) * 60 + Integer.parseInt(v[1]);
        int posTime = Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
        int op_startTime = Integer.parseInt(os[0]) * 60 + Integer.parseInt(os[1]);
        int op_endTime = Integer.parseInt(oe[0]) * 60 + Integer.parseInt(oe[1]);
        String mm = "", ss = "", result = "";
        
        for(int i = 0; i < commands.length; i++){
            String command = commands[i];
            
            if(posTime >= op_startTime && posTime <= op_endTime){
                posTime = op_endTime;
            }
            
            if(command.equals("next")){
                posTime += 10;
                if(posTime >= op_startTime && posTime <= op_endTime){
                    posTime = op_endTime;
                }
                if(posTime > videoTime - 10) posTime = videoTime;
                
            }
            else{
                posTime -= 10;
                if(posTime >= op_startTime && posTime <= op_endTime){
                    posTime = op_endTime;
                }
                if(posTime < 10) posTime = 0;
            }
        }
        
        int minute = (posTime / 60);
        int second = (posTime - 60 * (posTime/60));
        if(minute < 10) mm = "0" + minute;
        else mm = "" + minute;
        if(second < 10) ss = "0" + second;
        else ss = "" + second;
        result = mm + ":" + ss;
        
        return result;
    }
}