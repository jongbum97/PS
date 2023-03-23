import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<my_string.length(); i++){
            list.add(my_string.charAt(i)+"");
        }
        
        for(int i=my_string.length()-1; i>=0; i--){
            if(Collections.frequency(list,my_string.charAt(i)+"")>1){
                list.remove(i);
            }
        }
        for(String s : list){
            answer+=s;
        }
        
        
        return answer;
    }
}