import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer="";
        String s = my_string.toLowerCase();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            list.add(s.charAt(i)+"");
        }
        Collections.sort(list);
        for(String k : list){
            answer+=k;
        }
        return answer;
        
        
    }
}