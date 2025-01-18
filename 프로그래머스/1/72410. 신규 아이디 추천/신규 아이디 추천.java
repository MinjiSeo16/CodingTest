class Solution {
    public String solution(String new_id) {
        //1 
        new_id = new_id.toLowerCase();
        
        //2
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        
        //3
        while(new_id.contains("..")){
            new_id = new_id.replace("..", ".");
        }
        
        //4
        if(!new_id.isEmpty() && new_id.charAt(0) == '.'){
            new_id = new_id.substring(1);
            //while(!new_id.isEmpty() && new_id.charAt(0) == '.'){
            //    new_id = new_id.substring(1);
            //}
        }
        if(!new_id.isEmpty() && new_id.charAt(new_id.length() - 1) == '.'){
            new_id = new_id.substring(0, new_id.length() - 1);
            //while(!new_id.isEmpty() && new_id.charAt(new_id.length() - 1) == '.'){
            //    new_id = new_id.substring(0, new_id.length() - 1);
            //}
        }
        
        //5
        if(new_id.equals("")) new_id = "a";
        
        //6
        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15);
            if(new_id.charAt(14) == '.'){
                new_id = new_id.substring(0, 14);
            }
        }
        
        //7
        if(new_id.length() <= 2){
            char extra = new_id.charAt(new_id.length() - 1);
            
            while(true){
                if(new_id.length() > 2) break;
                new_id += extra;
            }
        }
        
        return new_id;
    }
}