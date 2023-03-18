import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        ArrayList<String> list = new ArrayList<>(Arrays.asList(my_string.split("")));
        for(int i = 0; i<20; i++){
        list.remove("a");
        list.remove("e");
        list.remove("i");
        list.remove("o");
        list.remove("u");
        }
        
        for(int i=0; i<list.size(); i++){
            answer+=list.get(i);
        }
        return answer;
    }
}